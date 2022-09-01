package com.example.simplesearchengine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText txtSearch;
    Button btnSearch;
    WebView webView;
    ImageView imgBanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = findViewById(R.id.txtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        webView = findViewById(R.id.webView);
        imgBanner = findViewById(R.id.imgBanner);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard((Button)view);
                webView.setVisibility(View.VISIBLE);
                imgBanner.setVisibility(View.GONE);
                String searchText = txtSearch.getText().toString();
                if(!searchText.equals("")){
                    webView.loadUrl("https://www.google.com/search?q=" + searchText);
                }

            }
        });


    }
    public void hideKeyboard(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch(Exception ignored) {
        }
    }


}