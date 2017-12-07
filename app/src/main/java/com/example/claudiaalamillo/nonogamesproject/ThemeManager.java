package com.example.claudiaalamillo.nonogamesproject;

/**
 * Created by Ryan Rackemann on 12/4/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThemeManager extends AppCompatActivity implements View.OnClickListener {
    public static int currentTheme = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        updateTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_manager);
        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onBackPressed();
            }
        });
        findViewById(R.id.black_theme_button).setOnClickListener(this);
        findViewById(R.id.amethyst_theme_button).setOnClickListener(this);
        findViewById(R.id.android_green_theme_button).setOnClickListener(this);
        findViewById(R.id.antique_ruby_theme_button).setOnClickListener(this);
        findViewById(R.id.axolotl_theme_button).setOnClickListener(this);
        findViewById(R.id.amazonite_theme_button).setOnClickListener(this);
    }
    @Override
    public void onClick(View currentView) {
        switch (currentView.getId()) {
            case R.id.black_theme_button:
                changeTheme(this, 1);
                break;
            case R.id.amethyst_theme_button:
                changeTheme(this, 2);
                break;
            case R.id.android_green_theme_button:
                changeTheme(this, 3);
                break;
            case R.id.antique_ruby_theme_button:
                changeTheme(this, 4);
                break;
            case R.id.axolotl_theme_button:
                changeTheme(this, 5);
                break;
            case R.id.amazonite_theme_button:
                changeTheme(this, 6);
                break;
            default:
                changeTheme(this, 1);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainMenuActivity.class));
    }
    public static void changeTheme(Activity currentActivity, int theme)
    {
        currentTheme = theme;
        currentActivity.finish();
        currentActivity.startActivity(new Intent(currentActivity, currentActivity.getClass()));
    }
    public static void updateTheme(Activity currentActivity) {
        switch (currentTheme)
        {
            case 1: // Black
                currentActivity.setTheme(R.style.AppTheme);
                break;
            case 2: // Amethyst
                currentActivity.setTheme(R.style.AppTheme_Amethyst);
                break;
            case 3: // Android Green
                currentActivity.setTheme(R.style.AppTheme_Android_Green);
                break;
            case 4: // Antique Ruby
                currentActivity.setTheme(R.style.AppTheme_Antique_Ruby);
                break;
            case 5: // Axolotl
                currentActivity.setTheme(R.style.AppTheme_Axolotl);
                break;
            case 6: // Amazonite
                currentActivity.setTheme(R.style.AppTheme_Amazonite);
                break;
            default: // Black
                currentActivity.setTheme(R.style.AppTheme);
                break;
        }
    }
}