FROM openjdk:8-jre-alpine

MAINTAINER maristas@gmail.com

ARG environment
ENV environment ${environment}

RUN apk add --no-cache tzdata
RUN apk add --no-cache curl

ENV TZ America/Lima

ADD application-v1.jar application-v1.jar

EXPOSE 8020

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=${environment}", "-Djava.awt.headless=true -Xms768m -Xmx768m -XX:+UseG1GC -XX:+DisableExplicitGC -XshowSettings:properties -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1","/application-v1.jar"]