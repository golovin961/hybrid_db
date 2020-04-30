package com.main.hybriddb;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;;

public class SparkTest {

//    private final long id;
//    public String ret;

    public JavaRDD<String> cnt() {//long id
        //this.id = id;
        System.out.println("*********** START ***********");
        SparkConf conf = new SparkConf();
        //System.out.println(2);
        conf.setAppName("my spark application");
        System.out.println("---------------- " +3);
        conf.setMaster("local[*]");
        System.out.println("---------------- " + 4);
        JavaSparkContext sc = new JavaSparkContext(conf);
        System.out.println("---------------- " + 5);
        JavaRDD<String> textFile = sc.textFile("a.txt");
        System.out.println("---------------- " + 6);
        //System.out.println("---------------- N is: " + textFile.count());
        System.out.println("---------------- " + 7);
        return textFile;

        //Dataset<String> logData = spark.read().textFile(logFile).cache();
        //long n = logData.count();
        //this.ret = "Lines : " + n;// + ", lines with b: " + numBs;


    }

//    public long myCounter(Dataset<Row> df){
//        return df.count();
//    }
}
