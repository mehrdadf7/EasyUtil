package com.github.mehrdadf7.util;

import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.widget.EditText;

public class Check {

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

}
