package com.my.config;

public class DBConfig {
    public static final String URL = "jdbc:mysql://localhost:3306/Bank";
    public static final String USER = "root";
    public static final String PASSWORD = "0000";


    private DBConfig() {
        // 생성자 private: 인스턴스 생성 못 하게
    }
}
