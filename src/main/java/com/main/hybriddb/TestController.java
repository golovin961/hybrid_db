package com.main.hybriddb;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.spark.api.java.JavaRDD;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.Dataset;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public Test test(@RequestParam(value = "name", defaultValue = "1World") String name) {
        return new Test(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/spark1")
    public Test spark1(@RequestParam(value = "name", defaultValue = "Earth") String name) {
        SparkTest ST = new SparkTest();
        JavaRDD<String> c = ST.simple_test();
        return new Test(counter.incrementAndGet(), String.format(template, c));
    }

    @GetMapping("/spark2")
    public Test spark2(@RequestParam(value = "name", defaultValue = "Earth") String name) {
        SparkTest ST = new SparkTest();
        ST.sqltest();
        return new Test(counter.incrementAndGet(), String.format(template, "E"));
    }
}