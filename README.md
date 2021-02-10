# Integer To Roman 
This project contains the spring boot application of Integer to Roman 
Given an integer within range(1-3999) the application will give the Roman value 


## Overview
The Application supports two queries 
##### Input : localhost:8080/romannumeral?query=1  
              ```
                  {output=CCXCIX, input=299}
               ```

##### Output :


##### Input : localhost:8080/romannumeral?min=1&max=3
##### Output :
         ```
         {"conversions":[{"output":"I","input":1},{"output":"II","input":2},{"output":"III","input":3},{"output":"IV","input":4}]}
         ```



## Steps to run the application 
   1.Clone the repo into any of the directory (Example C:/adobe)  
   2. Change into directory C:/adobe  
   3. simple check . Execute "ls" command to see "src" directory, pom.xml, Dockerfile  
   4. execute mvn clean install (please check if maven is installed or not) if not please install maven ans yd then execute the next steps  
   5. run "ls" command and you can see "target" folder created   
   

   ### Running as Docker contaner 
    6. docker build -t <tagname> . (you can provide any tag) for example docker build -t adobe. 
    7. docker ps -a  or docker images gives you list of docker immages that are running and you can see tagged(adobe) is also presnet  
    8. docker run -p 8080:8080 -t <tagname> . example docker run -p 8080:8080 -t adobe.  
    9. this will run the application on 8080  
 
      ```mvn clean install
           docker bu,ild -t adobe .
           docker run -p 8080:8080 -t adobe .
        ```
   ### Running as JAR file
    6.  java -jar target/spring-boot-0.0.1-SNAPSHOT.jar  
           
        ``` mvn clean install
         java -jar target/spring-boot-0.0.1-SNAPSHOT.jar
         ```
 
 ## Health status 
      1. localhost:8080/acumulater/health
 
## Statastics
      1. http://localhost:8080/stats
      ```
            {FAILURE COUNT=0, TOTAL REQUEST COUNT=1, SUCCESSFUL COUNT=1}
       ```

## Contributing
Pull requets are welcome. For major changes please drop a comment 


