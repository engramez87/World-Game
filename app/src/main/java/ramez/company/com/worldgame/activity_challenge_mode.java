package ramez.company.com.worldgame;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.ramez.worldgame.ChallengeModeSummaryScreenActivity;
import com.company.ramez.worldgame.R;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class activity_challenge_mode extends Activity {
    int h = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        View decorView = getWindow().getDecorView();
        super.onCreate(savedInstanceState);
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_activity_challenge_mode);
        ImageView im1= (ImageView) findViewById(R.id.challenge_mode_timmer_bar);
        Animation m= AnimationUtils.loadAnimation(this, R.anim.timer_animation);
        LinearLayout ll= (LinearLayout) findViewById(R.id.chekeplace);
        Animation lla=AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_out_to_left);
        ll.startAnimation(lla);
        im1.startAnimation(m);


        m.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getBaseContext(),"jhkjhjk", LENGTH_SHORT).show();
                Intent n=new Intent(getBaseContext(), ChallengeModeSummaryScreenActivity.class);
             startActivity(n);



            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        });
        runTimer();
    }

    private void runTimer() {

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int[] i = {R.drawable.countdown_one, R.drawable.countdown_two, R.drawable.countdown_three};
                int[] t = new int[3];
                ImageView im = (ImageView) findViewById(R.id.challenge_mode_countdown);


                if (h <= 2) {

                    t[h] = i[h];
                    im.setImageResource(t[h]);
                    h += 1;
                } else if (h > 2) {
                    im.setVisibility(View.GONE);
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.challenge_mode_timmer_holder);
                    rl.setVisibility(View.VISIBLE);
                    LinearLayout lr = (LinearLayout) findViewById(R.id.challenge_mode_footer);
                    lr.setVisibility(View.VISIBLE);
                    LinearLayout lrm = (LinearLayout) findViewById(R.id.chekeplace);
                    lrm.setVisibility(View.VISIBLE);


                }

                handler.postDelayed(this, 1000);

            }

        });


}

    public void iwant(View view) {
        ImageButton mmm= (ImageButton) findViewById(R.id.iwa);
        mmm.setBackgroundColor(Color.RED);
    }
}
