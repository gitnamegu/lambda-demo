package com.example.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 并行流（多线程） parallel()
 * 单线程         sequential()
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_2 {

    public static void main(String[] args) {
        // 设置Stream的线程数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        // 求和
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(4);
        list.add(4);
        int sum = list.stream()
                .parallel()
                .mapToInt(num -> num)
                .sum();
        System.out.println(sum);

    }
}
