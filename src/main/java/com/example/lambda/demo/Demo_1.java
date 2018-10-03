package com.example.lambda.demo;

import java.util.concurrent.Callable;

/**
 * @author dabing
 * @create 2018/10/2
 * @since 1.0.0
 */
public class Demo_1 {

    /**
     * 线程对象调用Runnable接口
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> exec()).start();
        System.out.println(Thread.currentThread().getName());
    }

    public static void exec() {
        System.out.println(Thread.currentThread().getName());
    }

}
