package com.github.mehrdadf7.util.dialog;

import android.graphics.Color;
import android.view.Gravity;

import com.github.mehrdadf7.util.R;

public class AlertDialogObject {

    private AlertDialogListener alertDialogListener;

    private String title = "";
    private String message = "";
    private String positive = "بله";
    private String negative = "بیخیال";

    private int color = R.color.colorPrimary;

    private int positiveIcon = R.drawable.ic_done_black_24dp;
    private int negativeIcon = R.drawable.ic_close_black_24dp;

    private int titleIcon = R.drawable.ic_donut_large_black_24dp;

    private int titleBackground = Color.parseColor("#eeeeee");
    private int titleColor    = android.R.color.black;
    private int positiveColor = R.color.green500;
    private int negativeColor = R.color.red500;

    private int gravityTitle = Gravity.RIGHT;
    private int gravityMessage = Gravity.RIGHT;

    public int getTitleBackground() {
        return titleBackground;
    }

    public AlertDialogObject setTitleBackground(int titleBackground) {
        this.titleBackground = titleBackground;
        return this;
    }

    public int getGravityTitle() {
        return gravityTitle;
    }

    public AlertDialogObject setGravityTitle(int gravityTitle) {
        this.gravityTitle = gravityTitle;
        return this;
    }

    public int getGravityMessage() {
        return gravityMessage;
    }

    public AlertDialogObject setGravityMessage(int gravityMessage) {
        this.gravityMessage = gravityMessage;
        return this;
    }

    public int getTitleIcon() {
        return titleIcon;
    }

    public AlertDialogObject setTitleIcon(int titleIcon) {
        this.titleIcon = titleIcon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AlertDialogObject setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AlertDialogObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPositive() {
        return positive;
    }

    public AlertDialogObject setPositive(String positive) {
        this.positive = positive;
        return this;
    }

    public String getNegative() {
        return negative;
    }

    public AlertDialogObject setNegative(String negative) {
        this.negative = negative;
        return this;
    }

    public int getPositiveIcon() {
        return positiveIcon;
    }

    public AlertDialogObject setPositiveIcon(int positiveIcon) {
        this.positiveIcon = positiveIcon;
        return this;
    }

    public int getNegativeIcon() {
        return negativeIcon;
    }

    public AlertDialogObject setNegativeIcon(int negativeIcon) {
        this.negativeIcon = negativeIcon;
        return this;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public AlertDialogObject setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public int getPositiveColor() {
        return positiveColor;
    }

    public AlertDialogObject setPositiveColor(int positiveColor) {
        this.positiveColor = positiveColor;
        return this;
    }

    public int getNegativeColor() {
        return negativeColor;
    }

    public AlertDialogObject setNegativeColor(int negativeColor) {
        this.negativeColor = negativeColor;
        return this;
    }

    public AlertDialogListener getAlertDialogListener() {
        return alertDialogListener;
    }

    public AlertDialogObject setAlertDialogListener(AlertDialogListener alertDialogListener) {
        this.alertDialogListener = alertDialogListener;
        return this;
    }

    public int getColor() {
        return color;
    }

    public AlertDialogObject setColor(int color) {
        this.color = color;
        return this;
    }

}
