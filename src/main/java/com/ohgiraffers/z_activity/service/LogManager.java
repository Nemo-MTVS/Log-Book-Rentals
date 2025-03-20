package com.ohgiraffers.z_activity.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class LogManager {
    public static void logTransaction(String record, String filePath) {
        // Try Catch 선언.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
        writer.write(record);
        System.out.println("Log Transaction: " + record + " Complete \n");

        } catch (IOException e) {
            System.out.println("Error while loggin : " + e.getMessage());
        }
    }
}
