# QN3-AquaSmart-Meter

Java implementation of the AquaSmart metering module, featuring encapsulated logic and automated unit testing.

## How to Run
This project uses JUnit 5 for validation.

1. Compile the code:
   `javac -cp .:junit-platform-console-standalone-1.9.3.jar *.java`
2. Run the tests:
   `java -jar junit-platform-console-standalone-1.9.3.jar -cp . -c SmartMeterTest`

## Project Structure
* `SmartMeter.java`: The core logic class. Uses encapsulation to protect credit balances and manage valve states.
* `SmartMeterTest.java`: JUnit 5 test suite verifying valve logic and consumption limits.
