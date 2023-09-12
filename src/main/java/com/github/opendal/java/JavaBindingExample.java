package com.github.opendal.java;

import org.apache.opendal.Operator;

import java.util.HashMap;
import java.util.Map;

public class JavaBindingExample {

    // s3 storage
    public static void writeToS3() {
        Map<String, String> params = new HashMap<>();
        params.put("bucket", "test");
        params.put("region", "us-east-1");
        Operator operator = new Operator("s3", params);
        operator.write("test.txt", "Hello, World!");
        operator.close();
    }

    // sftp storage
    public static void writeToSftp() {
        Map<String, String> params = new HashMap<>();
        params.put("root", "/tmp");
        params.put("endpoint", "127.0.0.1");
        params.put("user", System.getenv("USER"));
        params.put("key", System.getenv("HOME") + "/.ssh/id_rsa");
        Operator operator = new Operator("sftp", params);
        operator.write("test.txt", "Hello, World!");
    }

    // redis storage
    public static void writeToRedis() {
        Map<String, String> params = new HashMap<>();
        params.put("endpoint", "tcp://127.0.0.1:6379");
        params.put("db", "0");
        Operator operator = new Operator("redis", params);
        operator.write("test", "Hello, World!");
    }

    public static void main(String[] args) {
        writeToS3();
        writeToSftp();
        writeToRedis();
    }
}
