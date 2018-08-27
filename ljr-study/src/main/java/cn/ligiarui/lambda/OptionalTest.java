package cn.ligiarui.lambda;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        User user = new User("name",null);
        System.out.println(Optional.ofNullable(user).
                map(u-> u.getName()).map(r-> r + "ljr").
                orElse("no name"));
        System.out.println(
                Optional.ofNullable(user).map(u-> u.getPassword()).orElse("no password"));
        //System.out.println(Optional.ofNullable(user).map(u-> u.getPassword()).orElseThrow(()-> new NullPointerException()));
        User option  = Optional.ofNullable(user).
                filter(u-> u.getName() == "name").
                orElseGet(()->new User("no one","no password"));
        System.out.println(option.getName());


    }

    static class User{
        private String name;
        private String password;

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
    }
}
