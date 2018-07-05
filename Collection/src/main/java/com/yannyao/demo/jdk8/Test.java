package com.yannyao.demo.jdk8;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {
    /**
     * Lambda  表达式
     * @param args
     */
//    public static void main(String[] args) {
//        /*老版本写法*/
//        List<String> names = Arrays.asList("ae", "b", "ce", "e");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//
//        /*lamdba写法*/
//        Collections.sort(names, (String a, String b) -> {
//            return b.compareTo(a);
//        });
//        System.out.println(names);
//    }
    /****************************************************************************/
//    /**
//     * 函数式接口
//     * @param args
//     */
//    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//        Integer converted = converter.convert("123");
//        System.out.println(converted);
//    }
//    /**
//     * 函数式接口(指仅包含一个抽象方法的接口)
//     * 如果FunctionalInterface没有指定上面的代码也是对的  加了注解更加眼镜
//     */
//    @FunctionalInterface
//    interface Converter<F,T>{
//        T convert(F from);
//    }
//
    /****************************************************************************/

    /**
     * 方法与构造函数引用
     * @param args
     */
//    public static void main(String[] args) {
//        //::会帮你选择合适的构造函数
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert("123");
//        System.out.println(converted);
//
//        PersonFactory<Person> personFactory = Person::new;
//        Person person = personFactory.create("Peter", "Parker");
//        System.out.println(person.firstName);
//    }
//    /**
//     * 函数式接口(指仅包含一个抽象方法的接口)
//     * 如果FunctionalInterface没有指定上面的代码也是对的  加了注解更加眼镜
//     */
//    @FunctionalInterface
//    interface Converter<F,T>{
//        T convert(F from);
//    }
//    interface PersonFactory<P extends Person> {
//        P create(String firstName, String lastName);
//    }

    /****************************************************************************/


//    public static void main(String[] args) {
//        /**
//         * Function接口
//         */
//        Function<String, Integer> toInteger = Integer::valueOf;
//        Function<String, String> backToString = toInteger.andThen(String::valueOf);
//        backToString.apply("123");     // "123"
//        /**
//         * supplier接口  不接受参数
//         */
//        Supplier<Person> personSupplier = Person::new;
//        personSupplier.get();
//        /**
//         * consumer接口  接收一个参数
//         */
//        Consumer<String> greeter = System.out::println;
//        greeter.accept("hahaha");

//    }
    /****************************************************************************/

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))  //类似的还有 .map .match  .count
                .forEach(System.out::println);
        System.out.println(stringCollection);
        System.out.println(stringCollection.stream());
    }
}
