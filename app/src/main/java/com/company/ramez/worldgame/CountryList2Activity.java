package com.company.ramez.worldgame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CountryList2Activity extends Activity {
    ListView list;
    String[] titles;
    int[] images = {R.drawable.afghanistan, R.drawable.albania,
            R.drawable.algeria, R.drawable.angola, R.drawable.andorra,
            R.drawable.antiguaandbarbuda, R.drawable.antiguaandbarbuda,
            R.drawable.australia, R.drawable.austria, R.drawable.zambia,
            R.drawable.austria, R.drawable.azerbaijan, R.drawable.bahamas, R.drawable.bahrain,R.drawable.bangladesh,
            R.drawable.barbados,R.drawable.belarus,R.drawable.belgium,R.drawable.benin,R.drawable.belize,
            R.drawable.bhutan,R.drawable.bolivia, R.drawable.botswana, R.drawable.bosniaandherzegovina,
            R.drawable.brazil,R.drawable.brunei,R.drawable.bulgaria,R.drawable.burkinafaso,
            R.drawable.burundi,R.drawable.cambodia};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();
        super.onCreate(savedInstanceState);
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_countr_list);
        Resources res = getResources();
        titles = res.getStringArray(R.array.title);
        list = (ListView) findViewById(R.id.listview);
        Ramezadapter ra = new Ramezadapter(this, titles, images);

        list.setAdapter(ra);

    }


}

class Ramezadapter extends ArrayAdapter<String> {
    Context context;
    int[] images1;
    String[] titlearray;

    Ramezadapter(Context c, String[] titles, int img[]) {
        super(c, R.layout.activity_country__list__item, R.id.i_country_name, titles);
        this.context = c;
        this.images1 = img;
        this.titlearray = titles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater infleter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = infleter.inflate(R.layout.activity_country__list__item, parent, false);
        }
        ImageView myimage = (ImageView) row.findViewById(R.id.c_logo);
        TextView mytext = (TextView) row.findViewById(R.id.i_country_name);
        myimage.setImageResource(images1[position]);
        mytext.setText(titlearray[position]);

        return row;
    }
}
