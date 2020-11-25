package com.example.mywargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView left_card, right_card;
    TextView score_morty, score_rick;
    ImageButton play;
    GameRunner gameRunner ;
    private List<Player> players;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        left_card = (ImageView) findViewById(R.id.leftcard);
        right_card = (ImageView) findViewById(R.id.rightcard);
        score_morty = (TextView) findViewById(R.id.mortyscore);
        score_rick = (TextView) findViewById(R.id.rickscore);
        play = (ImageButton) findViewById(R.id.play);


       initViews();






    }


    public void initViews() {
        gameRunner = new GameRunner();

        score_morty.setText("" + gameRunner.players.get(0).getScore());
        score_rick.setText("" + gameRunner.players.get(1).getScore());
    /*
    on each click if we still have cards to pop,  call the function 'start game'.
     */
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameRunner.players.get(0).getPlayerDeck().deckIsEmpty() == 0 || gameRunner.players.get(1).getPlayerDeck().deckIsEmpty() == 0){
                    checkWinner();
                }else {
                    start_game();
                }
            }
        });
    }


    private void start_game() {
        Card leftCard = gameRunner.players.get(0).getPlayerDeck().getCard();
        Card rightCard = gameRunner.players.get(1).getPlayerDeck().getCard();
        String leftCardName = leftCard.getRank().getRankName() +"_" + "of" + "_" +  leftCard.getSuit().getSuitName();
        String rightCardName = rightCard.getRank().getRankName() +"_" + "of" + "_" + rightCard.getSuit().getSuitName();
        int id1 = getResources().getIdentifier(leftCardName,"drawable", getPackageName());
        int id2 = getResources().getIdentifier(rightCardName,"drawable", getPackageName());
        left_card.setImageResource(id1);
        right_card.setImageResource(id2);
        calculateScore(leftCard, rightCard);
    }
    /*
       check which player got higher card, add points to the player with the higher card value,
       if both have the same value - add point to both of them.
     */
    private void calculateScore(Card leftCard, Card rightCard){
        int leftCardValue = leftCard.getCardPoints();
        int rightCardValue= rightCard.getCardPoints();
        if(leftCardValue > rightCardValue){
            gameRunner.players.get(0).addScore();
            score_morty.setText("" + gameRunner.players.get(0).getScore());
        }else if(leftCardValue < rightCardValue){
            gameRunner.players.get(1).addScore();
            score_rick.setText("" + gameRunner.players.get(1).getScore());
        }else if(leftCardValue == rightCardValue){
            gameRunner.players.get(0).addScore();
            gameRunner.players.get(1).addScore();
            score_morty.setText("" + gameRunner.players.get(0).getScore());
            score_rick.setText("" + gameRunner.players.get(1).getScore());
        }
    }

    public void checkWinner(){
        int score = 0;
        int player = 0;// 1-player1 , 2-player2 ,3- teco
        if(gameRunner.players.get(0).getScore() > gameRunner.players.get(1).getScore()){
            score = gameRunner.players.get(0).getScore();
            player = 1;
        }else if(gameRunner.players.get(0).getScore() < gameRunner.players.get(1).getScore()){
            score = gameRunner.players.get(1).getScore();
            player = 2;
            //go to winner activity with player 2 name
        }else {
            score = gameRunner.players.get(1).getScore();
            player = 3;
        }
        Intent myIntent = new Intent(MainActivity.this, WinnerActivity.class);
        myIntent.putExtra(WinnerActivity.PLAYER,player);
        myIntent.putExtra(WinnerActivity.SCORE,score);
        startActivity(myIntent);
        finish();

    }


}