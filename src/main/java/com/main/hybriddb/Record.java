package com.main.hybriddb;
import java.io.*;

public class Record implements Serializable {
    String IATA_CODE;
    String AIRLINE;
    public Record(String IATA_CODE, String AIRLINE){
        this.IATA_CODE = IATA_CODE;
        this.AIRLINE = AIRLINE;
    }
}