package cn.ligiarui.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> p = s -> s.length() > 3;
        System.out.println("正常:" + p.test("hello"));
        System.out.println("非操作:" + p.negate().test("hello"));
        System.out.println("与操作:" + p.and(s -> s.equals("abc")).test("hello"));
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("ccc");
        list.add("bb");
        list.forEach(param -> {
            if(p.test(param)) {
                System.out.println(param);
            }
        });

        list.forEach(System.out::println);
    }
}
