FROM openjdk:8
VOLUME /tmp
ADD ./target/BankAccountMainMS-0.0.1-SNAPSHOT.jar bank-account-main.jar
ENTRYPOINT ["java","-jar","/bank-account-main.jar"]