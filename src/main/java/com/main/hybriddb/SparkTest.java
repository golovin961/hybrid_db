package com.main.hybriddb;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class SparkTest {

//    private final long id;
    public String ret;

    public SparkTest() {//long id
        //this.id = id;
        String logFile = "exp.txt";
        this.ret = "0";
        try{
            this.ret =  this.ret + "1";
            SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
            this.ret =  this.ret + "2";
            spark.stop();
            this.ret =  this.ret + "3";
        }
        catch (){
            this.ret =  this.ret + "4";
        }
        //Dataset<String> logData = spark.read().textFile(logFile).cache();
        //long n = logData.count();
        //this.ret = "Lines : " + n;// + ", lines with b: " + numBs;


    }

    public long myCounter(Dataset<Row> df){
        return df.count();
    }
}
