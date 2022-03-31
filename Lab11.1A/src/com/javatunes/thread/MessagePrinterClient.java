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
    // DONE: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("Spongebob", 30, 500);
    printer1.setName("message prin");
    printer1.start();

    MessagePrinter printer2 = new MessagePrinter("Squarepants", 20, 800);
    printer2.start();

    MessagePrinter printer3 = new MessagePrinter("I'm Ready!");
    printer3.start();
  }
}