package com.main.hybriddb;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.StructType;

public class SparkTest {

//    private JavaSparkContext sc;

    public void sqltest(){
        String file = "airlines.csv";
        System.out.println("*********** SPARK SQL TEST START ***********");
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();
        System.out.println("================= 1");

        Dataset<Row> peopleDF = spark.read().format("csv").load(file);
        peopleDF.select("IATA_CODE").write().format("parquet").save("namesAndAges.parquet");

        System.out.println("================= 2");

//        Dataset<Row> df = spark.read()
//                .option("mode", "DROPMALFORMED")
//                .schema(schema)
//                .csv(file);
//
//        System.out.println("================= 3");
////        df.show();
//        System.out.println("================= 4");
    }


    // тест что что-то вообще работает
    public JavaRDD<String> simple_test() {
        System.out.println("*********** SPARK SIMPLE TEST START ***********");
        SparkConf conf = new SparkConf();
        conf.setAppName("simple spark test");
        conf.setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> textFile = sc.textFile("a.txt");
        System.out.println("*********** SPARK DONE ***********");
        return textFile;
    }
}
