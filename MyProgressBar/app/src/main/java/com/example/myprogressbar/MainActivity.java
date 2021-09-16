package com.example.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pb);
        progressBar1 = findViewById(R.id.pb1);
        progressBar2 = findViewById(R.id.pb_progressbar);

    }

    public void ACEClick(View view) {
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    public void load(View view) {
        int progress = progressBar1.getProgress();
        progress += 10;
        progressBar1.setProgress(progress);
    }

    public void customload(View view) {
        int progress1 = progressBar2.getProgress();
        progress1 += 10;
        progressBar2.setProgress(progress1);

        int progress2 = progressBar2.getSecondaryProgress();
        progress2 += 5;
        progressBar2.setSecondaryProgress(progress2);
    }
}