mvn compile
mvn package
cd target
spark-submit --class hello.HelloWorld --master local gs-maven-0.1.0.jar
cd ../