FROM openjdk:17-slim
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]

# run
# docker build -t safdarthaheem/job-app .