package com.example.quotesmaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuotesList {
    ArrayList<Quote> quotes;
    Quote currentQuote;

    QuotesList() {
        quotes = new ArrayList<>();
    }

    void loadQuotes(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line1;
            String line2;
            while ((line1 = reader.readLine()) != null && (line2 = reader.readLine()) != null) {
                currentQuote = new Quote();
                currentQuote.parseLines(line1, line2);
                quotes.add(currentQuote);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Quote getRandomQuote() {
        return quotes.get((int) (Math.random() * (quotes.size())));
    }

    void print() {
        for (Quote quote : quotes) {
            quote.print();
        }
    }
}
