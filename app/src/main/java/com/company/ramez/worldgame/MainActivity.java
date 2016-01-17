package com.company.ramez.worldgame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        View decorView = getWindow().getDecorView();
        super.onCreate(savedInstanceState);
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.



        setContentView(R.layout.activity_main);

    }


    public void OnMainMenuBtnClicked(View view) {
        Intent intent=new Intent(this,activity_new_challenge_game.class);
        startActivity(intent);
    }

    public void OnCountryMenuBtnClicked(View view) {
        Intent intent=new Intent(this,CountryList2Activity.class);
        startActivity(intent);
    }
}
