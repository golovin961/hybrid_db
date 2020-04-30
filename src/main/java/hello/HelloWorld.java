package hello;

import org.joda.time.LocalTime;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
//import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("********** START **********");
        SparkConf conf = new SparkConf();
        //System.out.println(2);
        conf.setAppName("my spark application");
        //System.out.println(3);
        conf.setMaster("local[*]");
        //System.out.println(4);
        JavaSparkContext sc = new JavaSparkContext(conf);
        //System.out.println(5);
        JavaRDD<String> textFile = sc.textFile("a.txt");
        System.out.println(6);
        System.out.println("*************** N is: " + textFile.count());
        System.out.println(7);
    }
}