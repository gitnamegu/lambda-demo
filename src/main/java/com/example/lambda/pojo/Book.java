package com.example.lambda.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author dabing
 * @create 2018/10/3
 * @since 1.0.0
 */
public class Book {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String  name;
    @Getter
    @Setter
    private LocalDate publishDate;

    public Book(Integer id, String name, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
