package com.main.hybriddb;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.spark.api.java.JavaRDD;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public Test test(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Test(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/test2")
    public Test test2(@RequestParam(value = "name", defaultValue = "Earth") String name) {
        return new Test(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/test5")
    public Test test5(@RequestParam(value = "name", defaultValue = "Earth") String name) {
        SparkTest ST = new SparkTest();
        JavaRDD<String> c = ST.cnt();
        return new Test(counter.incrementAndGet(), String.format(template, c));
    }


//    @GetMapping("/test4")
//    public Test test4(@RequestParam(value = "name", defaultValue = "Earth") String name) {
//        String logFile = "exp.txt";
//        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
//        Dataset<String> logData = spark.read().textFile(logFile).cache();
//        String ret = "123";
//        //long n = logData.count();
//        //String ret = "Lines in " +  logFile + " file: " + n; //n;// + ", lines with b: " + numBs;
//        spark.stop();
//        return new Test(counter.incrementAndGet(), String.format(template, ret));
//    }

//    @GetMapping("/test4")
//    piblic String test4(){
//        String logFile = "exp.txt";
//        //SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
//        //Dataset<String> logData = spark.read().textFile(logFile).cache();
//        //long n = logData.count();
//        String ret = "Lines : " +logFile; //n;// + ", lines with b: " + numBs;
//        //
//        return ret;
//    }
}