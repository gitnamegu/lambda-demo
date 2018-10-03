package com.example.lambda.demo;

/**
 * 静态方法的引用
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_2 {

    public static void main(String[] args) {

        // 方法的引用, 无参, 无返回值
        Function_NoneParam demo1 = Demo_2::function1;
        demo1.fun();

        // 方法的引用, 有参, 无返回值
        Function_Param demo2 = Demo_2::function2;
        demo2.fun(1);

        Function_Param_Call demo3 = Demo_2::function3;
        Integer num = demo3.fun(2);
        System.out.println(num);
    }

    public static void function1() {
        System.out.println("静态方法引用");
    }

    public static void function2(Integer num) {
        System.out.println(num);
    }

    public static Integer function3(Integer num) {
        return num;
    }

    @FunctionalInterface
    interface Function_NoneParam {
        void fun();
    }

    @FunctionalInterface
    interface Function_Param {
        void fun(Integer num);
    }

    @FunctionalInterface
    interface Function_Param_Call {
        Integer fun(Integer num);
    }
}
