package com.main.hybriddb;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import scala.math.Ordering;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;

public class SparkTest {

    public String sql_test() {
        String path_csv = "airlines.csv";
        String path_txt = "a.txt";
        System.out.println("********** SPARK SQL TEST START **********");
        SparkSession spark_session = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();
        System.out.println("++++++++++++++++++++ 2");
        StructType schema = new StructType()
                .add("IATA_CODE1", "string")
                .add("AIRLINE1", "string");
        System.out.println("++++++++++++++++++++ 3");
        Dataset<Row> df = spark_session.read()
                .option("mode", "DROPMALFORMED")
                .schema(schema)
                .csv(path_csv);
//     JavaRDD<String> textFile = sc.textFile(file);
//       Dataset<Row> df = spark.read().option("header","true").textFile(file);
//        spark_session.read()
//                .text(path_txt)
//                .show();
//                .option("mode", "DROPMALFORMED")
//                .schema(schema)

        System.out.println("++++++++++++++++++++ 4");
        df.show(5);
        System.out.println(df.toString());
        System.out.println("++++++++++++++++++++ 5");
        df.createOrReplaceTempView("air");
        System.out.println("++++++++++++++++++++ 6");
        Dataset<Row> sql_query = (spark_session.sql("SELECT * FROM air"));
        System.out.println("++++++++++++++++++++ 7");
        sql_query.show();
        String out = "EEE";

        return out;
    }

//    LAST VERSIONS before 245
//    public String sql_test() {
//        String file = "airlines.csv";
//        String out = "sql";
//        System.out.println("********** SPARK SQL TEST START **********");
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Java Spark SQL Example")
//                .config("spark.master", "local")
//                .getOrCreate();
//        System.out.println("++++++++++++++++++++ 2");
//
//        Dataset<java.lang.String> df = spark.read().option("header","true").textFile(file);
//        System.out.println("++++++++++++++++++++ 3");
//        df.show();
//        return out;
//    }
//
    public String simple_test() {
        String file = "a.txt";
        String out = "from the file + '" + file + "' gettin next data: ";
        System.out.println("********** SPARK SIMPLE TEST START **********");
        SparkConf conf = new SparkConf().setAppName("JavaWordCount").setMaster("local");
        System.out.println("++++++++++++++++++++ 2");
        SparkContext context = new SparkContext(conf);
        System.out.println("++++++++++++++++++++ 3");
        RDD<String> textFile = context.textFile(file,1);
        System.out.println("========== Print Schema ============");
        long num = textFile.count();
        out += "num of rows: " + num + "; ";
        int i = 5;
        out += "info about element №" + i + ": " + textFile.take(i) + "; ";
        out += "data about RDD: " + textFile.toString() + "; ";
        System.out.println("========== collect: " + textFile.collect());
        System.out.println("========== inf about element " + i + ": " + (textFile.take(i)));
        System.out.println("========== inf about created RDD: " + (textFile.toString()));
        System.out.println("========== Num of rows " + num);
        return out;
    }

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

