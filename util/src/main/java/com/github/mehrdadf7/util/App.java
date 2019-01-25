package com.github.mehrdadf7.util;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class App {

    private static int WIDTH = -1;
    private static final String TAG = "log";
    private static final long SECOND = 2000;

    public static void l(String message) {
        Log.e(TAG, message);
    }

    public static void t(String message, Typeface typeface, int colorPrimary, int colorPrimaryDark) {
        LinearLayout layout = new LinearLayout(Application.getContext());
        layout.setBackgroundColor(ContextCompat.getColor(Application.getContext(), R.color.colorAccent));
        TextView textView = new TextView(Application.getContext());
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setTextSize(13F);
        textView.setGravity(16);
        textView.setText(message);
        textView.setGravity(17);
        textView.setMaxWidth(screenWidth() - 110);
        textView.setTextColor(Color.WHITE);
        textView.setTypeface(typeface);
        layout.addView(textView);
        layout.setPadding(20, 10, 20, 10);
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        colorPrimary,
                        colorPrimaryDark
                }
        );
        gradientDrawable.setCornerRadius(16F);
        if (Build.VERSION.SDK_INT >= 17) {
            layout.setBackground(gradientDrawable);
        } else {
            layout.setBackgroundDrawable(gradientDrawable);
        }
        Toast toast = new Toast(Application.getContext());
        toast.setView(layout);
        toast.setGravity(80, 0, 100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static boolean checkPhoneNumber(Typeface typeface, int colorPrimary, int colorPrimaryDark, AppCompatEditText editText) {
        if (editText.getText() != null) {
            if (editText.getText().toString().trim().isEmpty()) {
                App.t(Application.getContext().getString(R.string.empty_phoneNumber), typeface, colorPrimary, colorPrimaryDark);
                return false;
            } else if (!editText.getText().toString().trim().startsWith("09")) {
                App.t(Application.getContext().getString(R.string.length_not_equal_11), typeface, colorPrimary, colorPrimaryDark);
                return false;
            } else if (editText.getText().toString().trim().length() != 11) {
                App.t(Application.getContext().getString(R.string.start_with_09), typeface, colorPrimary, colorPrimaryDark);
                return false;
            }
        }
        return true;
    }

    public static boolean checkPhoneNumber(Typeface typeface, int colorPrimary, int colorPrimaryDark, EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            App.t(Application.getContext().getString(R.string.empty_phoneNumber), typeface, colorPrimary, colorPrimaryDark);
            return false;
        } else if (!editText.getText().toString().trim().startsWith("09")) {
            App.t(Application.getContext().getString(R.string.length_not_equal_11), typeface, colorPrimary, colorPrimaryDark);
            return false;
        } else if (editText.getText().toString().trim().length() != 11) {
            App.t(Application.getContext().getString(R.string.start_with_09), typeface, colorPrimary, colorPrimaryDark);
            return false;
        }
        return true;
    }

    public static void gone(View view) {
        view.setVisibility(View.GONE);
    }

    public static void visible(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static void invisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public static void landingAnimation(final View view) {
        YoYo.with(Techniques.Landing)
                .duration(SECOND)
                .repeat(0)
                .playOn(view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                YoYo.with(Techniques.Flash)
                        .duration(SECOND)
                        .repeat(2)
                        .playOn(view);
            }
        }, SECOND);
    }

    public static void flashAnimation(View view) {
        YoYo.with(Techniques.Flash)
                .duration(700)
                .repeat(5)
                .playOn(view);
    }

    private static int screenWidth() {
        if (WIDTH == -1) {
            WIDTH = Application.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return WIDTH;
    }

}
