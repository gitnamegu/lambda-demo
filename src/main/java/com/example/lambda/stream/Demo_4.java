package com.example.lambda.stream;

import com.example.lambda.pojo.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实战
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Demo_4 {

    public List<Book> bookList() {
        Book book1 = new Book(1, "java", LocalDate.parse("2018-11-11"));
        Book book2 = new Book(1, "java", LocalDate.parse("2018-11-12"));
        Book book3 = new Book(3, "net", LocalDate.parse("2018-11-13"));
        Book book4 = new Book(4, "go", LocalDate.parse("2018-11-14"));
        Book book5 = new Book(5, "js", LocalDate.parse("2018-11-15"));
        Book book6 = new Book(6, "shell", LocalDate.parse("2018-11-16"));
        Book book7 = new Book(null, "shell", LocalDate.parse("2018-11-16"));
        List<Book> resultList = new ArrayList<>();
        resultList.add(book1);
        resultList.add(book2);
        resultList.add(book3);
        resultList.add(book4);
        resultList.add(book5);
        resultList.add(book6);
        resultList.add(book7);
        return resultList;
    }


    /**
     * 拿出所有的id的集合
     */
    @Test
    public void test1() {
        List<Book> bookList = bookList();
        List<Integer> idList = bookList.stream()
                .map(Book::getId)
                .collect(Collectors.toList());
        System.out.println(idList);
    }

    /**
     * 拿出所有的id, 然后拼成字符串
     */
    @Test
    public void test2() {
        List<Book> bookList = bookList();
        String resultStr = bookList.stream()
                .map(book -> book.getId() + "")
                .collect(Collectors.joining(",", "(", ")"));
        System.out.println(resultStr);
    }

    /**
     * 根据name排序, 正序排， 倒序排
     */
    @Test
    public void test3() {
        List<Book> bookList = bookList();
        List<String> list = bookList.stream()
                .map(Book::getName)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println(list);

    }

    /**
     * 根据id排序， 如果id一样， 根据发布时间倒序排
     */
    @Test
    public void test4() {
        List<Book> bookList = bookList();

        List<Book> resultList = bookList.stream()
                .sorted(Comparator.comparing(Book::getId)
                        .thenComparing(Comparator.comparing(Book::getPublishDate).reversed())
                )
                .collect(Collectors.toList());
        System.out.println(resultList);

    }

    /**
     * 转换为map, key为id, value为book
     * 注意的问题：转换为map时, 如果key重复, 会抛异常。为了避免抛异常, 使用下面的方法指定保留新数据还是老数据。
     */
    @Test
    public void test5() {
        List<Book> bookList = bookList();

        Map<Integer, Book> resultMap = bookList.stream()
                .collect(Collectors.toMap(Book::getId, book -> book, (oldValue,newValue) -> newValue));
        System.out.println(resultMap);

    }

    /**
     * 获取到id最大的book, 如果id最大值有多个怎么办？
     */
    @Test
    public void test6() {
        List<Book> bookList = bookList();

        Book book = bookList.stream()
                .max(Comparator.comparing((Book a) -> a.getId() == null ? 1 : a.getId()))
                .get();
        System.out.println(book);

    }

    /**
     * 根据id分组
     */
    @Test
    public void test7() {
        List<Book> bookList = bookList();

        Map<Integer, List<Book>> resultList = bookList.stream()
                .collect(Collectors.groupingBy(a -> a.getId() == null? 0 : 1, Collectors.toList()));
        System.out.println(resultList);

    }

    /**
     * 统计每种id的数量
     */
    @Test
    public void test8() {
        List<Book> bookList = bookList();

        Map<Integer, Long> resultMap = bookList.stream()
                .collect(Collectors.groupingBy(book -> book.getId()==null?0:book.getId(), Collectors.counting()));
        System.out.println(resultMap);

    }

    /**
     * 统计名为java的id的和
     */
    @Test
    public void test9() {
        List<Book> bookList = bookList();

        Map<String, Integer> resultMap = bookList.stream()
                .collect(Collectors.groupingBy(Book::getName, Collectors.summingInt(book -> book.getId()==null?0:1)));
        System.out.println(resultMap);

    }

}
