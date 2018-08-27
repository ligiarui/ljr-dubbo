package cn.ligiarui.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplierTest {

    public static void main(String[] args) {
//        User user = new User("user","word");
//        Consumer<User> userConsumer = u -> u.setName("ljr");
//        userConsumer.accept(user);
//        System.out.println(user.getName());
        Supplier<String> supplier = () -> "hello world";
        //get方法不接受参数，返回一个结果
        System.out.println("supplier = [" + supplier.get() + "]");

        User user = new User("user",null);
        List<User> list = Arrays.asList(user);
        list.forEach(u-> {
            if(1 ==  u.getAge()){
                u.setName("aaa");
            }
            System.out.println(u.toString());
        });
    }

    static class User{
        private String name;
        private String password;
        private Integer age;

        public User(String name,String password){
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
