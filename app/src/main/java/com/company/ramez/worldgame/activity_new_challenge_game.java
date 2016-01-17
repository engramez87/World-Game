package com.company.ramez.worldgame;
import ramez.company.com.worldgame.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_new_challenge_game extends Activity {

      static boolean gamemode =false;
    static  boolean diffcultmode=false;
    static double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();
        super.onCreate(savedInstanceState);
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_activity_new_challenge_game);

    }

    public void OnButtonClickedListener(View view) {
        CheckBox countrflag = (CheckBox) findViewById(R.id.new_challenge_country_to_flag);
        CheckBox capitaltoflag= (CheckBox) findViewById(R.id.new_challenge_capital_to_flag);
        CheckBox countrytocapital= (CheckBox) findViewById(R.id.new_challenge_country_to_capital);

        CheckBox easy = (CheckBox) findViewById(R.id.new_game_difficulty_easy);
        CheckBox medium= (CheckBox) findViewById(R.id.new_game_difficulty_medium);
        CheckBox hard= (CheckBox) findViewById(R.id.new_game_difficulty_hard);


        boolean cf=countrflag.isChecked();
        boolean ctf=countrflag.isChecked();
        boolean ctc=countrflag.isChecked();
        boolean e=countrflag.isChecked();
        boolean m=countrflag.isChecked();
        boolean h=countrflag.isChecked();

        if(gamemode ==true&& diffcultmode==true)
        {

            Toast.makeText(this, "Ramez", Toast.LENGTH_LONG).show();
            Intent in=new Intent(this,activity_challenge_mode.class);
            startActivity(in);

        }



    }

    public void OnGameModeSelectedListener(View view) {


        CheckBox countrflag = (CheckBox) findViewById(R.id.new_challenge_country_to_flag);
        CheckBox capitaltoflag= (CheckBox) findViewById(R.id.new_challenge_capital_to_flag);
        CheckBox countrytocapital= (CheckBox) findViewById(R.id.new_challenge_country_to_capital);
        switch(view.getId())
        {
            case R.id.new_challenge_capital_to_flag :
                if( ( countrflag.isChecked()==true &&countrytocapital.isChecked()==true)||( countrflag.isChecked()==true )||countrytocapital.isChecked()==true )
                {
                    gamemode =false;
                }
                else if(capitaltoflag.isChecked()==true&& countrflag.isChecked()==false&&countrytocapital.isChecked()==false)
                {
                    gamemode =true;

                }
                else
                gamemode =false;

                    break;
            case R.id.new_challenge_country_to_flag:
                if( ( capitaltoflag.isChecked()==true &&countrytocapital.isChecked()==true)||( capitaltoflag.isChecked()==true && countrytocapital.isChecked()==false )||countrytocapital.isChecked()==true && capitaltoflag.isChecked()==false )
                {
                    gamemode =false;
                }

                else if(capitaltoflag.isChecked()==false&& countrflag.isChecked()==true&&countrytocapital.isChecked()==false)
                {
                    gamemode =true;

                }
                else
                gamemode =false;

                break;

            case R.id.new_challenge_country_to_capital:
                if( ( countrflag.isChecked()==true &&capitaltoflag.isChecked()==true)||( countrflag.isChecked()==true &&capitaltoflag.isChecked()==false)||capitaltoflag.isChecked()==true && countrflag.isChecked()==false)
                {
                    gamemode =false;
                }

                else if(capitaltoflag.isChecked()==false&& countrflag.isChecked()==false&&countrytocapital.isChecked()==true)
                {
                    gamemode =true;

                }
                else
                gamemode =false;

                break;






        }



    }

    public void OnGameLevelSelectedListener(View view) {



        CheckBox easy = (CheckBox) findViewById(R.id.new_game_difficulty_easy);
        CheckBox medium= (CheckBox) findViewById(R.id.new_game_difficulty_medium);
        CheckBox hard= (CheckBox) findViewById(R.id.new_game_difficulty_hard);
        switch(view.getId())
        {
            case R.id.new_game_difficulty_medium :
                if( ( easy.isChecked()==true &&hard.isChecked()==true)||( easy.isChecked()==true )||hard.isChecked()==true )
                {
                    diffcultmode =false;
                }
                else if(medium.isChecked()==true&& easy.isChecked()==false&&hard.isChecked()==false)
                {
                    diffcultmode =true;
                    score=2;
                    TextView scoreview= (TextView) findViewById(R.id.new_challenge_score_multiplier);
                    String j=Double.toString(score);
                    scoreview.setText(j);
                }
                else
                    diffcultmode =false;

                break;
            case R.id.new_game_difficulty_easy:
                if( ( medium.isChecked()==true &&hard.isChecked()==true)||( medium.isChecked()==true && hard.isChecked()==false )||hard.isChecked()==true && medium.isChecked()==false )
                {
                    diffcultmode =false;
                }

                else if(medium.isChecked()==false&& easy.isChecked()==true&&hard.isChecked()==false)
                {
                    diffcultmode =true;
                    score=1.5;
                    TextView scoreview= (TextView) findViewById(R.id.new_challenge_score_multiplier);
                    String j=Double.toString(score);
                    scoreview.setText(j);
                }
                else
                    diffcultmode =false;

                break;

            case R.id.new_game_difficulty_hard:
                if( ( easy.isChecked()==true &&medium.isChecked()==true)||( easy.isChecked()==true &&medium.isChecked()==false)||medium.isChecked()==true && easy.isChecked()==false)
                {
                    diffcultmode =false;
                }

                else if(medium.isChecked()==false&& easy.isChecked()==false&&hard.isChecked()==true)
                {
                    diffcultmode =true;
                    score=2.5;
                    TextView scoreview= (TextView) findViewById(R.id.new_challenge_score_multiplier);
                    String j=Double.toString(score);
                    scoreview.setText(j);
                }
                else
                    diffcultmode =false;

                break;






        }
}
}
