package com.github.mehrdadf7.easyutil;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

import com.github.mehrdadf7.util.App;
import com.github.mehrdadf7.util.dialog.AlertDialogListener;
import com.github.mehrdadf7.util.dialog.AlertDialogObject;
import com.github.mehrdadf7.util.dialog.CustomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/samim.ttf");
        final AlertDialogObject object = new AlertDialogObject()
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
                .setTypeface(typeface);

        final CustomDialog dialog = new CustomDialog(this, object);
        object.setAlertDialogListener(new AlertDialogListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                //Gradient Toast for this Library
                Toast.makeText(MainActivity.this, object.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegativeClick() {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.show();

    }
}
