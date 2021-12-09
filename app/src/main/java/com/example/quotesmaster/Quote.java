package com.example.quotesmaster;

public class Quote {
    String message;
    String author;
    String book;

    void parseLines(String line1, String line2) {
        parseMessage(line1);
        parseInfo(line2);
    }

    void print() {
        System.out.println("Message: " + this.message);
        System.out.println("Author: " + this.author);
        System.out.println("Book: " + this.book);
    }

    private void parseMessage(String msg) {
        this.message = msg.substring(1, msg.length() - 1);
    }

    private void parseInfo(String info) {
        this.author = info.substring(2, info.indexOf(","));
        this.book = info.substring(info.indexOf(",")).substring(2);
    }
}
