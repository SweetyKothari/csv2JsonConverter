### This project is responsible for cconverting csv data into json format

#### Build & Instruction

####Env
1. Maven 3.6.0
2. Java 8



#### How to Run
1. Go to root project directory
2. Hit command mvn clean install 
3. Executable jar present with name <csv2JsonConverter-1.0-SNAPSHOT-jar-with-dependencies.jar>
4. Run command by passing necessary argument 
java -jar <jarfileName_with_depdencies> <inputFilePath> <outputDirectory> <dataTypeNeeded in Json(Y/N)>
where 
inputFilePath : Full Path for input CSV file ,
outputDirectory : directory where json file will be created
dataTypeNeeded : to include 'type' attribute in json


For example : 
java -jar target/csv2JsonConverter-1.0-SNAPSHOT-jar-with-dependencies.jar  /Users/kothari/Documents/input1.csv /Users/kothari/Documents/output/ Y
