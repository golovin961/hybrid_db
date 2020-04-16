package com.max;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        //String logFile = "D:/Magistracy/TRPO/hybrid_db/spark/src/main/resources/exp.txt";
        String logFile = "exp.txt";
        System.out.println("0");
        SparkConf conf = new SparkConf().setAppName("Simple Application");
        System.out.println("1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        System.out.println("2");
        JavaRDD<String> logData = sc.textFile(logFile).cache();
        System.out.println("3");
        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
    }
}