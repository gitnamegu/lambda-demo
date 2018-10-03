package com.example.lambda.demo;

/**
 * @author dabing
 * @create 2018/10/2
 * @since 1.0.0
 */
public class Demo_5 {

    /**
     * 线程对象调用Runnable接口
     * @param args
     */
    public static void main(String[] args) {

    }

    class User {

        public User() {

        }
    }

    @FunctionalInterface
    interface Function_interface {
        User getUser();
    }
}
