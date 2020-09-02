package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    int count = 0;
    String winnerStr;
    int activePlayer = 0;
    int[] gamestate = {2, 2, 2, 2 ,2 ,2 ,2 ,2, 2};
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    public void TapTap(View view){
        ImageView img = (ImageView)view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gameReset(view);
            return;
        }
        if(gamestate[tappedImage] == 2) {
            gamestate[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn! Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn! Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition: winPositions)
        {
            count = 0;
            if(gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2)
            {
                gameactive = false;
                if(gamestate[winPosition[0]] == 0)
                {
                    winnerStr = "X has won";
                    count = 1;
                }
                else
                {
                    winnerStr = "O has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
                count = 1;
                break;
            }


        }
        if(gamestate[0]  != 2 && gamestate[1]  != 2 && gamestate[2]  != 2 &&
                gamestate[3]  != 2 && gamestate[4]  != 2 && gamestate[5]  != 2 &&
                gamestate[6]  != 2 && gamestate[7]  != 2 && gamestate[8]  != 2 && count == 0 ){
            winnerStr = "Match draw";
            TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
            gameactive = false;
            count = 0;
        }

    }
    public void gameReset(View view)
    {
        gameactive = true;
        activePlayer = 0;
        for(int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
