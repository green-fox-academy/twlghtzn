package com.twlghtzn.day3exercises;

import com.twlghtzn.day3exercises.coloring.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day3exercisesApplication implements CommandLineRunner {
  private Printer printer;
  private MyColor myColor;

  public static void main(String[] args) {
    SpringApplication.run(Day3exercisesApplication.class, args);
  }

  @Autowired
  public Day3exercisesApplication(Printer printer, MyColor myColor) {
    this.printer = printer;
    this.myColor = myColor;
  }

  @Override
  public void run(String... args) throws Exception {
    myColor.printColor();
    printer.log("Szevasztok");
  }
}
