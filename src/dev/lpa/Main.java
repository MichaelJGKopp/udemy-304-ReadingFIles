package dev.lpa;

import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    // reads one integer at a time, meaning 4 bytes in java
    try (FileReader reader = new FileReader("file.txt")) {  // default buffer size, being loaded at once

      int data;
      while ((data = reader.read()) != -1) {  // end reached when -1
        System.out.println((char) data);  // first was disc read, else buffered read from memory
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
