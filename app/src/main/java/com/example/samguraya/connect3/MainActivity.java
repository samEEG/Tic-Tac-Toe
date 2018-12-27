package com.example.samguraya.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        counter.animate().alpha(0);
        counter.setImageResource(R.drawable.ooo);
        counter.animate().alpha(1).setDuration(300);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
