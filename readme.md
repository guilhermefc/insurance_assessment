#Origin-backend-take-home-assignment
https://github.com/OriginFinancial/origin-backend-take-home-assignment

##(1) Instructions to run the code; 
Requirements:
- Java 11

Option 1: clone the project, open pom.xml in your IDE, build it and run it.<br>
Option 2: download the jar file and execute the command <code>java -jar origin-0.0.1-SNAPSHOT.jar</code>

After the server goes up and running, just have fun: <br>
```CODE
curl --location --request POST 'localhost:8080/api/v1/risk-assessment' \
--header 'Content-Type: application/json' \
--data-raw '{
"age": 35,
"dependents": 2,
"house": {"ownership_status": "owned"},
"income": 0,
"marital_status": "married",
"risk_questions": [0, 1, 0],
"vehicle": {"year": 2018}
}'
```
You should receive a response like:<br>
```JSON
{
    "auto": "REGULAR", 
    "disability": "INELIGIBLE",
    "home": "ECONOMIC",
    "life": "REGULAR"
} 
```

##(2) what were the main technical decisions you made; 
1. Project language and framework: I choose Java and Spring Boot due to my previous experiences as an Android developer (before moving to Kotlin) and nowadays building backend solutions with my team.
2. Business rules implementation: I really enjoyed this puzzle, at first look it seemed a simple risk engine but depending on how you approach it, it could easily become a highly coupled code resulting in difficulty to support and maintain. So I built a simple approach using a list of rules that made it easy to test unitary each risk rule and ineligibility case and also tried to made it extensible and open to new insurance lines.   



##(3) relevant comments about your project
I tried to keep the architecture and functions scope as close to required as possible to focus on the correctness and testability of the main use case that was the risk engine. So I did not build any persistence layer, error handling layer  neither additional features out of scope.