package com.example.layoutscodelab.testhashcode;

import java.io.PrintStream;

class Java8 {
  interface Logger {
    void log(String s);
  }

  public static void main(String... args) {
    sayHi(getOut()::println);
  }

  private static PrintStream getOut() {
    return System.out;
  }

  private static void sayHi(Logger logger) {
    logger.log("Hello!");
  }
}