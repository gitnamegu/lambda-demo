package com.example.lambda.demo;

/**
 * 实例方法的引用
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_3 {

    public static void main(String[] args) {

        // 方法的引用
        Function_NoneParam demo1 = new Demo_3().new User()::ping;
        demo1.fun_none();

        // 有返回值
        Function_Param demo2 = new Demo_3().new User()::select;
        demo2.fun(2);
    }


    class User {
        void ping() {
            System.out.println("ping");
        }

        void pong() {
            System.out.println("pong");
        }

        User select(Integer id) {
            System.out.println(id);
            User user = new User();
            user.pong();
            return user;
        }
    }

    @FunctionalInterface
    interface Function_NoneParam {
        void fun_none();
    }

    @FunctionalInterface
    interface Function_Param {
        User fun(Integer id);
    }

}
