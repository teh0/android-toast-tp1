package com.champion.theo.tpo1_champion_theo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.champion.theo.tpo1_champion_theo.databinding.ActivityAddImageBinding;
import com.champion.theo.tpo1_champion_theo.databinding.ActivityMainBinding;

public class AddImageActivity extends AppCompatActivity {
    /**
     * Binding entity to retrieve activity views
     */
    ActivityAddImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        this.configActivity();
        injectImage();
    }

    /**
     * Handle configuration of activity
     */
    private void configActivity() {
        binding = ActivityAddImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * Inject image into activity view
     */
    private void injectImage() {
        Glide.with(this).load("https://source.unsplash.com/random").into(binding.imageContainer);
    }
}