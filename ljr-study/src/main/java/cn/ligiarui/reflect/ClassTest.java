package cn.ligiarui.reflect;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lijiarui
 * @create: 2019-01-18 14:55
 **/
public class ClassTest {

    public static void main(String[] args) throws Exception{
        //Declared 声明的
        Class a = Info.class;
        //获取类对象的三种方法
        getClassOject();
        //获取变量
        getClassField(a);
        //获取全部方法
        getClassMethod(a);
        //获取接口
        getClassInterface(a);
        //获取注解
        getClassAnnotation(a);
        //获取父类
        getClassSuper(a);
        //示例化对象
        testnewClassInstance(a);
        //获取构造方法、
        getClassConstructor(a);
    }

    public static void getClassOject() throws ClassNotFoundException{
     //1.通过类名获取      类名.class
     //2.通过对象获取      对象名.getClass()
     //3.通过全类名获取    Class.forName(全类名)
        Class a = Info.class;
        Info info = new Info();
        Class b = info.getClass();
        Class c = Class.forName("cn.ligiarui.reflect.Info");
        System.out.println(a==b);
        System.out.println(c==b);
    }

    public static void getClassField(Class info) throws Exception{
        //  1.1 获取所有字段 -- 字段数组
        //     可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fs = info.getDeclaredFields();
        //  1.2获取指定字段
        Field field = info.getDeclaredField("mname");
        System.out.println(field.getName());
        //2.使用字段
        //  2.1获取指定对象的指定字段的值,get中的值是对象
        //如果字段是私有的，不管是读值还是写值，都必须先调用setAccessible（true）方法
        field.setAccessible(true);
        Info o = (Info)info.newInstance();
        Object val = field.get(o);
        System.out.println(val);
        //  2.2设置指定对象的指定对象Field值
        field.set(o, "DEF");
        System.out.println(o.getName());

    }

    public static void getClassMethod(Class info) throws Exception{
        //  1.1 获取取clazz对应类中的所有方法--方法数组（一）
        //     不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = info.getMethods();
        //  1.2.获取所有方法，包括私有方法 --方法数组（二）
        //  所有声明的方法，都可以获取到，且只获取当前类的方法
        Method[] ms = info.getDeclaredMethods();
        //
        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = info.getDeclaredMethod("setMname", String.class);
        System.out.println(method);
        AnnoSimple anno = method.getAnnotation(AnnoSimple.class);
        if(anno != null){
            System.out.println("拦截方法里的注解");
        }
        //  这样写是获取不到的，如果方法的参数类型是int型
        //  如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
         //  要么获取方法的参数写成int.class

        //
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        Info obje = (Info)info.newInstance();
        method.invoke(obje,"名称");
        //如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
        //私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
        Method getTName = info.getDeclaredMethod("getTName",String.class);
        getTName.setAccessible(true);
        getTName.invoke(obje,"aaa");
    }

    public static void getClassInterface(Class info){
        Class[] c = info.getInterfaces();
        for(int i =0 ;i< c.length;i++){
            System.out.println(c[i].getName());
        }
    }

    public static void getClassAnnotation(Class info){
        Annotation[] c = info.getAnnotations();
        for(int i =0 ;i< c.length;i++){
            System.out.println(c[i].annotationType());
        }
    }

    public static void getClassSuper(Class info){
        Class c = info.getSuperclass();
        System.out.println(c.getName());
    }

    public static void getClassConstructor(Class info) throws Exception{
        Constructor[] c = info.getConstructors();
        Constructor[] cc = info.getDeclaredConstructors();
        //  1.2获取某一个，需要参数列表
        Constructor<Info> constructor = info.getConstructor(Integer.class,String.class);
        System.out.println(constructor);

        //2. 调用构造器的 newInstance() 方法创建对象
        Object obj = constructor.newInstance(1,"zhagn");
        System.out.println(obj);
    }

    public static void testnewClassInstance(Class info) throws Exception{
        Info obj =  (Info)info.newInstance();
        System.out.println(obj);
        obj.start();

    }
}

