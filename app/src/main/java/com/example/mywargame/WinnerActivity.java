package com.example.mywargame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class WinnerActivity extends Activity {
    public static final String SCORE = "SCORE";
    public static final String PLAYER = "PLAYER";
    TextView Winner_LBL;
    TextView Final_Score_LBL;
    int player = 0;
    int score = 0;
    ImageView winner_IMG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_activity);
        winner_IMG = findViewById(R.id.winner_IMG);
        Winner_LBL = findViewById(R.id.Winner_LBL);
        Final_Score_LBL = findViewById(R.id.Final_Score_LBL);
        initViews();
    }

//    private void findViews() {
//        winner_IMG = findViewById(R.id.winner_IMG);
//        Winner_LBL = findViewById(R.id.Winner_LBL);
//        Final_Score_LBL = findViewById(R.id.Final_Score_LBL);
//    }
    /*
       get the score of each player, and the avatar of the winner to show on the screen
     */
    private void initViews() {
        player = getIntent().getIntExtra(PLAYER, -1);
        score = getIntent().getIntExtra(SCORE,-1);
        if(player == 1) {
            winner_IMG.setImageResource(R.drawable.morty);
            Winner_LBL.setText("The Winner is: \n       morty! player "+ player);
            Final_Score_LBL.setText("Your Score: " + score);
        }else if (player == 2){
            winner_IMG.setImageResource(R.drawable.rick);
            Winner_LBL.setText("The Winner is: \n       rick! player "+ player);
            Final_Score_LBL.setText("Your Score: " + score);
        }
        else {
            Winner_LBL.setText("     It's A Tie!!");
            Final_Score_LBL.setText("Your Score: " + score);
//            winner_IMG.setImageResource(R.drawable.win);

        }
    }

}
