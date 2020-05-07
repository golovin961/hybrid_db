package com.main.hybriddb;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;

public class SparkTest {

//    private JavaSparkContext sc;

    public void sqltest(){
        String file = "/airlines.csv";
        System.out.println("********** SPARK SQL TEST START **********");
        SparkConf conf = new SparkConf().setAppName("JavaWordCount").setMaster("local");
        System.out.println("++++++++++++++++++++ 2");
        SparkContext context = new SparkContext(conf);
        System.out.println("++++++++++++++++++++ 3");
        SparkSession sparkSession = new SparkSession(context);
        System.out.println("++++++++++++++++++++ 4");
        RDD<String> textFile = context.textFile(file,2);
        System.out.println("========== Print Schema ============");
//        Dataset<Row> df = sparkSession
//                .read()
//                .format("com.databricks.spark.csv")
//                .option("header", true)
//                .option("inferSchema", true)
//                .load(file);
//        System.out.println("++++++++++++++++++++ 5");
//        //("hdfs://localhost:9000/usr/local/hadoop_data/loan_100.csv");
//        System.out.println("========== Print Schema ============");
//        df.printSchema();
//        System.out.println("========== Print Data ==============");
//        df.show();
//        System.out.println("========== Print title ==============");
//        df.select("title").show();

    }


//    public void sqltest(){
//        String file = "airlines.csv";
//        System.out.println("********** SPARK SQL TEST START **********");
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Java Spark SQL Example")
//                .config("spark.master", "local")
//                .getOrCreate();
//        System.out.println(2);
//        StructType schema = new StructType()
//                .add("department", "string")
//                .add("designation", "string")
//                .add("ctc", "long")
//                .add("state", "string");
//        System.out.println(3);
//        Dataset<Row> df = spark.read()
//                .option("mode", "DROPMALFORMED")
//                .schema(schema)
//                .csv(file);
//        System.out.println(df.toString());
//        return;
//
//    }
//    public void sqltest(){
//        String file = "airlines.csv";
//        System.out.println("********** SPARK SQL TEST START **********");
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Java Spark SQL Example")
//                .config("spark.master", "local")
//                .getOrCreate();
//        System.out.println(2);
//        StructType schema = new StructType()
//                .add("department", "string")
//                .add("designation", "string")
//                .add("ctc", "long")
//                .add("state", "string");
//        System.out.println(3);
//        Dataset<Row> df = spark.read()
//                .option("mode", "DROPMALFORMED")
//                .schema(schema)
//                .csv(file);
//        System.out.println(df.toString());
//        return;
//
//    }
//
//    SparkConf conf = new SparkConf();
//        System.out.println("++++++++++++++++++++ 1");
//        conf.setAppName("simple spark sql test");
//        System.out.println("++++++++++++++++++++ 2");
//        conf.setMaster("local[*]");
//        System.out.println("++++++++++++++++++++ 3");
//    JavaSparkContext sc = new JavaSparkContext(conf);
//        System.out.println("++++++++++++++++++++ 4");
//    SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
//        System.out.println("++++++++++++++++++++ 5");
//
//    DataFrame dfr = sqlContext.read()
//            .format("com.databricks.spark.csv")
//            .option("header", "true")
//            .option("mode", "DROPMALFORMED")
//            .load(file);
//        System.out.println("++++++++++++++++++++ 6");


    // тест что что-то вообще работает 2.10/1.6.0
//    public JavaRDD<String> simple_test() {
//        System.out.println("*********** SPARK SIMPLE TEST START ***********");
//        SparkConf conf = new SparkConf();
//        conf.setAppName("simple spark test");
//        conf.setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        JavaRDD<String> textFile = sc.textFile("a.txt");
//        System.out.println("*********** SPARK DONE ***********");
//        return textFile;
//    }
}
