package com.example.quotesmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView quoteText;
    TextView quoteAuthor;
    ImageView quoteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteImage = findViewById(R.id.quote_image);
        quoteText = findViewById(R.id.quote_text);
        quoteAuthor = findViewById(R.id.quote_author);
        refresh(getCurrentFocus());//load an initial quote
    }

    public void refresh(View view) {//TODO: check if new random quote is the same
        QuotesList quotesList = new QuotesList();
        InputStream inputStream = this.getResources().openRawResource(R.raw.quotes);
        quotesList.loadQuotes(inputStream);
        Quote currentQuote = quotesList.getRandomQuote();
        String filename= (String) currentQuote.author.subSequence(0,currentQuote.author.indexOf(" "));
        System.out.println(filename);
        quoteImage.setImageResource(this.getResources().getIdentifier(filename.toLowerCase(Locale.ROOT),"drawable",getPackageName()));
        quoteText.setText(currentQuote.message);
        quoteAuthor.setText(currentQuote.author);
    }
}