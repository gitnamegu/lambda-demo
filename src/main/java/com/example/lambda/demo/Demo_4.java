package com.example.lambda.demo;

/**
 *      对象方法的引用: 前提是函数式接口的抽象方法必须要有参数
 *      使用方式: 其中对象方法引用的语法最为麻烦, 对象方法引用时, 抽象方法的第一个参数类型刚好是实例方法的类型, 抽象方法剩余的参数恰好可以
 * 当作实例方法的参数。如果函数式接口的实现能由上面说的实例方法调用来实现的话, 那么就可以使用对象方法引用。
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_4 {

    public static void main(String[] args) {

        // 方法的引用
        Function_Param demo1 = User::insert;
        Integer num = demo1.fun(new User());
        System.out.println(num);

        // 方法的引用, 多参数
        Function_Param2 demo2 = User::equal;
        Boolean flag = demo2.fun(new User(), 1);
        System.out.println(flag);
    }


    static class User {
        static Integer insert(User user) {
            return 1;
        }

        static Boolean equal(User user, Integer id) {
            return false;
        }

    }

    @FunctionalInterface
    interface Function_Param {
        Integer fun(User user);
    }

    @FunctionalInterface
    interface Function_Param2 {
        Boolean fun(User user, Integer id);
    }

}
