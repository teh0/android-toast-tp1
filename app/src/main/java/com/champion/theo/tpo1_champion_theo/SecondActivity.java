package com.champion.theo.tpo1_champion_theo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.champion.theo.tpo1_champion_theo.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    /**
     * Binding entity to retrieve activity views
     */
    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configActivity();
        initEvents();
    }

    /**
     * Handle configuration of activity
     */
    private void configActivity() {
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * Init activity views events
     */
    private void initEvents() {
        this.onClickCalculateButton();
    }

    /**
     * Event handler for calculate button click
     */
    private void onClickCalculateButton() {
        this.binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.handleResultDisplay();
            }

            /**
             * Handle logic of displaying sum result
             */
            private void handleResultDisplay() {
                String valueInputNumberOne = binding.inputNumberOne.getText().toString();
                String valueNumberTwo = binding.inputNumberTwo.getText().toString();

                if (!"".equals(valueInputNumberOne) && !"".equals(valueNumberTwo)) {
                    Integer result = Integer.parseInt(valueInputNumberOne) + Integer.parseInt(valueNumberTwo);
                    binding.result.setText(String.valueOf(result));
                }
            }
        });
    }
}