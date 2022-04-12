package com.elizwy.javatech.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileRead {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/zwyeli/Downloads/optimus-20220326-test.txt")));
        String line;
        String[] linePart;
        while ((line = br.readLine()) != null) {
            linePart = line.split("\\t");
            System.out.println(linePart.length);
    }
    }
}
