package dev.lpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    // reads one integer at a time, meaning 4 bytes in java
    try (FileReader reader = new FileReader("file.txt")) {  // default buffer size, being loaded at once
      char[] block = new char[1_000];
      int data;
      while ((data = reader.read(block)) != -1) {  // end reached when -1
        String content = new String(block, 0, data);
        System.out.printf("---> [%d chars] %s%n", data, content);  // first was disc read, else buffered read from memory
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("----------------------------------");
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {

      bufferedReader.lines().forEach(System.out::println);  // using streams
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
