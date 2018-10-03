package com.example.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 实战
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_3 {

    public static void main(String[] args) {
        // 设置Stream的线程数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");

        // 案例1
        String params = "name=zhangsan&age=1&id=2";
        Map<String, String> resultMap = Stream.of(params.split("&"))
                .parallel()
                .map(strArrays -> strArrays.split("="))
                .collect(Collectors.toMap(paramArr -> paramArr[0], paramArr -> paramArr[1]));
        System.out.println(resultMap);




    }
}
