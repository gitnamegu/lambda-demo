package com.example.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_1 {

    public static void main(String[] args) {
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
                .mapToInt(num -> num)
                .sum();
        System.out.println(sum);

        // 最大值
        Integer maxValue = list.stream()
                .max((num1, num2) -> num1 - num2)
                .get();
        System.out.println(maxValue);

        // 查找
        Integer anyNum = list.stream()
                .filter(num -> num % 2 == 0)
                .findAny()
                .get();
        System.out.println(anyNum);

        // 前50个数的集合
        List<Integer> collect = Stream.iterate(1, x -> x + 1)
                .limit(50)
                .collect(Collectors.toList());
        System.out.println(collect);



        String sourceStr = "1, 2, 3, 4";
        int sum1 = Arrays.asList(sourceStr.split(","))
                .stream()
                .mapToInt(str -> Integer.valueOf(str.trim()))
                .sum();
        System.out.println(sum1);

    }
}
