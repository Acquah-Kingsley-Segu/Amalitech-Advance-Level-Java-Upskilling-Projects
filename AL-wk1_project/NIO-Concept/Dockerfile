FROM openjdk:17-slim
WORKDIR /java/nio
COPY src/main/java/org/example/Main.java .
RUN ["javac", "Main.java"]
CMD ls
CMD ["java", "/java/nio/Main"]