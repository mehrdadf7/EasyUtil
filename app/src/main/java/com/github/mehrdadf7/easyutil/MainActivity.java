package com.github.mehrdadf7.easyutil;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mehrdadf7.util.*;

public class MainActivity extends AppCompatActivity implements AlertDialogListener {

    private CustomDialog dialog;
    private AlertDialogObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/samim.ttf");
                object = new AlertDialogObject()
                    .setTitle("لورم ایپسوم")
                    .setMessage("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی ...")
                    .setPositive("تایید")
                    .setNegative("انصراف")
                    .setPositiveShow(true)
                    .setNegativeShow(true)
                    .setGravityMessage(Gravity.RIGHT)
                    .setGravityTitle(Gravity.RIGHT)
                    .setTitleIcon(R.drawable.ic_donut_large_black_24dp)
                    .setPositiveIcon(R.drawable.ic_done_black_24dp)
                    .setNegativeIcon(R.drawable.ic_close_black_24dp)
                    .setTypeface(typeface)
                    .setAlertDialogListener(MainActivity.this);

                dialog = new CustomDialog(MainActivity.this, object);
                dialog.setCancelable(true);
                dialog.show();
            }
        });

    }

    @Override
    public void onPositiveClick() {
        dialog.dismiss();
        Toast.makeText(MainActivity.this, object.getPositive(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeClick() {
        dialog.dismiss();
        Toast.makeText(MainActivity.this, object.getNegative(), Toast.LENGTH_SHORT).show();
    }
}
