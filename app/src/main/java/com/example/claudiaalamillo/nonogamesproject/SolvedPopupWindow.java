package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SolvedPopupWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved_popup_window);

        Button levelSelectionButton = (Button) findViewById(R.id.levelSelectionSPW);
        Button mainMenuButton = (Button) findViewById(R.id.mainMenuButtonSPW);

        // comment
//        levelSelectionButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                goToLevelSelection();
//            }
//        });
//        mainMenuButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                goToMainMenu();
//            }
//        });
    }

    private void goToLevelSelection()
    {
        Intent intent = new Intent(this, LevelSelection.class);
        startActivity(intent);
    }

    private void goToMainMenu()
    {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
