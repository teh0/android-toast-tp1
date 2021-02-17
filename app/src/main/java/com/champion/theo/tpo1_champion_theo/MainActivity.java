package com.champion.theo.tpo1_champion_theo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * Text view containing count value
     */
    private TextView textView;

    /**
     * Button used to increment count
     */
    private Button countButton;

    /**
     * Button to display toast
     */
    private Button toastButton;

    /**
     * Counter value
     */
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViews();
        this.initEventsViews();
    }

    /**
     * Methods that allow to retrieve the instance of views in the layout
     */
    private void initViews() {
        this.textView = findViewById(R.id.countValue);
        this.countButton = findViewById(R.id.count);
        this.toastButton = findViewById(R.id.toast);
        this.textView.setText(String.valueOf(this.count));
    }

    /**
     * Register and init all events of view elements
     */
    private void initEventsViews() {
        this.onClickCountButton();
        this.onCLickToastButton();
    }

    /**
     * Event handler for count button click
     */
    private void onClickCountButton() {
        this.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(String.valueOf(count));

            }
        });
    }

    /**
     * Event handler for toast button click
     */
    private void onCLickToastButton() {
        this.toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, this.getToastText(count) , Toast.LENGTH_SHORT).show();
            }

            /**
             * Return text displayed into the toast
             */
            private String getToastText(Integer countValue) {
                return "Value of count : " +  String.valueOf(count);
            }
        });
    }
}