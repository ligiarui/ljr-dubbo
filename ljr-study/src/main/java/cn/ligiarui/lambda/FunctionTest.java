package cn.ligiarui.lambda;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> add = e -> e + e;
        Function<Integer, String> toString = e -> e + "String";
        System.out.println("andThen value=" + add.andThen(toString).apply(3));
        System.out.println("compose value=" + toString.compose(add).apply(3));
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);

    }
}
