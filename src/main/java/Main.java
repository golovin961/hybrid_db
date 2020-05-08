import com.opencsv.CSVReader;
import com.steelbridgelabs.oss.neo4j.structure.Neo4JElementIdProvider;
import com.steelbridgelabs.oss.neo4j.structure.Neo4JGraph;
import com.steelbridgelabs.oss.neo4j.structure.providers.DatabaseSequenceElementIdProvider;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Transaction;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String DB_USER = "neo4j";
    private static final String DB_PASS = "admin";
    private static final String URI = "bolt://localhost:7687/";
    private static Graph graph;
    private static Transaction transaction;

    public static void main(String[] args) {
        System.out.println("Hello World");
        // create driver instance
        Driver driver = GraphDatabase.driver(URI,
                AuthTokens.basic(DB_USER, DB_PASS));
        // create id provider
        Neo4JElementIdProvider<?> provider = new DatabaseSequenceElementIdProvider(driver);
        // create graph instance
        graph = new Neo4JGraph(driver, DB_USER, provider, provider);
        transaction = graph.tx();
        // create another vertex in current graph with label
        // class with CSV file as a parameter.
        try {
            FileReader fileReaderAirlines = new FileReader(new File("./airlines.csv"));
            buildNode("airline", fileReaderAirlines);
            FileReader fileReaderAirports = new FileReader(new File("./airports.csv"));
            buildNode("airport", fileReaderAirports);
            //FileReader fileReaderFlights = new FileReader(new File("./flights.csv"));
            //buildNode("flight", fileReaderFlights);





            FileReader fileReaderFlights = new FileReader(new File("./flights.csv"));
            try {
                // Create an object of filereader
                // create csvReader object passing
                // file reader as a parameter
                CSVReader csvReader = new CSVReader(fileReaderFlights);
                String[] nextRecord;
                List<String> titles = new ArrayList<>();
                boolean isFirst = true;
                ArrayList<Vertex> vers = new ArrayList<>();
                // we are going to read data line by line
                while ((nextRecord = csvReader.readNext()) != null) {
                    Vertex ver = graph.addVertex("flight");
                    vers.add(ver);
                    for (int i = 0; i < nextRecord.length; i++) {
                        if (isFirst) titles.add(nextRecord[i]);
                        else ver.property(titles.get(i), nextRecord[i]);
                        //System.out.print(cell + "\t");
                    }
                    //System.out.println();
                    isFirst = false;
                }

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }











        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*SparkConf conf = new SparkConf();
          JavaSparkContext sc = new JavaSparkContext(conf);
          sc.textFile("/tmp/csv/address.csv").map()
          VertexProgram.Builder a =  BulkLoaderVertexProgram.build();
       */
    }

    private static void buildNode(String label, FileReader filereader) {
        //----------------------- Reading file -----------------------//
        try {
            // Create an object of filereader
            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            List<String> titles = new ArrayList<>();
            boolean isFirst = true;
            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                Vertex ver = graph.addVertex(label);
                for (int i = 0; i < nextRecord.length; i++) {
                    if (isFirst) titles.add(nextRecord[i]);
                    else ver.property(titles.get(i), nextRecord[i]);
                    //System.out.print(cell + "\t");
                }
                //System.out.println();
                isFirst = false;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
