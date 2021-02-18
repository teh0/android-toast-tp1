package com.champion.theo.tpo1_champion_theo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.champion.theo.tpo1_champion_theo.databinding.ActivityMainBinding;
import com.champion.theo.tpo1_champion_theo.databinding.ActivitySecondBinding;

public class MainActivity extends AppCompatActivity {

    /**
     * Binding entity to retrieve activity views
     */
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configActivity();
        this.initEventsViews();
    }

    /**
     * Handle configuration of activity
     */
    private void configActivity() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * Register and init all events of view elements
     */
    private void initEventsViews() {
        this.onClickToastActivityButton();
        this.onClickCalculatorActivityButton();
        this.onClickSendMailButton();
    }

    /**
     * Event handler for toast activity button click
     */
    private void onClickToastActivityButton() {
        this.binding.toToastActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Event handler for calculator activity button click
     */
    private void onClickCalculatorActivityButton() {
        this.binding.toCalculatorActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Event handler for send mail button click
     */
    private void onClickSendMailButton() {
        this.binding.sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                this.configSendIntent(
                        intent,
                        "tochampion38@gmail.com",
                        "Test email",
                        "Bonjour :)"
                );
                startActivity(Intent.createChooser(intent, "Send email"));
            }

            /**
             * Config intent by providing all necessary infos to send mail
             */
            private void configSendIntent(Intent intent, String recipient, String subject, String body) {
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);
            }
        });
    }
}