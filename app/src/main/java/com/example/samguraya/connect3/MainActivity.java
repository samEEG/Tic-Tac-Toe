package com.example.samguraya.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //First player is 0, o and second player is 1, x
    // -1 is empty
    int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0;
    boolean gameActive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tapCounter = Integer.valueOf(counter.getTag().toString());
        if(gameState[tapCounter] == -1 && gameActive) {
            counter.animate().alpha(0);
            gameState[tapCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.ooo);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.xxx);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != -1) {
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "O";
                    } else {
                        winner = "X";
                    }
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    playAgainButton.setVisibility(View.VISIBLE);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + " has won");
                    winnerTextView.setVisibility(View.VISIBLE);

                }
            }
            counter.animate().alpha(1).setDuration(300);
        }
    }
    public void playAgain(View view){
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for(int i = 0; i < gameState.length; i++){
            gameState[i] = -1;
        }
        activePlayer = 0;
        gameActive = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
