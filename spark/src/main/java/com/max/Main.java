package com.max;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import static com.max.Main.def;

public class Main {

    static void def(){
        System.out.println("0");
        SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkTest");
        System.out.println("1");
        JavaSparkContext context = new JavaSparkContext(conf);

        System.out.println("2");
        JavaRDD<String> stringJavaRDD = context.textFile("src/main/resources/exp.txt");
        System.out.println("3");
        System.out.println(stringJavaRDD.count());
    }
    public static void main(String[] args){
        def();
    }
}
