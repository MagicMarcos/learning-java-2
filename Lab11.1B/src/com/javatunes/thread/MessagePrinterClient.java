/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // We can pass in the name of our thread as a second argument to new Thread()
    Thread printer1 = new Thread(new MessagePrinter("Spongebob", 30, 500));
    printer1.start();

    Thread printer2 = new Thread(new MessagePrinter("Squarepants", 20, 800));
    printer2.start();

    Thread printer3 = new Thread(new MessagePrinter("I'm Ready!"));
    printer3.start();
  }
}