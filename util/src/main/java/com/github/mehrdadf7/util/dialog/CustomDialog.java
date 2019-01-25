package com.github.mehrdadf7.util.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mehrdadf7.util.R;

public class CustomDialog extends AlertDialog implements View.OnClickListener {

    private Typeface typeface;
    private AlertDialogObject object;
    private TextView title, message, positive, negative;
    private LinearLayout positiveParent, negativeParent;
    private AppCompatImageView titleIcon, positiveIcon, negativeIcon;

    public CustomDialog(@NonNull Context context, AlertDialogObject object) {
        super(context);
        this.object   = object;
    }
    public CustomDialog(@NonNull Context context, AlertDialogObject object, Typeface typeface) {
        super(context);
        this.object   = object;
        this.typeface = typeface;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_alert_dialog);
        initViews();
        init();
    }

    private void initViews() {
        title          = findViewById(R.id.title);
        titleIcon      = findViewById(R.id.titleIcon);
        message        = findViewById(R.id.message);
        positive       = findViewById(R.id.positive);
        negative       = findViewById(R.id.negative);
        positiveParent = findViewById(R.id.positiveParent);
        negativeParent = findViewById(R.id.negativeParent);
        positiveIcon   = findViewById(R.id.positiveIcon);
        negativeIcon   = findViewById(R.id.negativeIcon);
    }

    private void init() {

        titleIcon.setImageResource(object.getTitleIcon());

        title   .setTypeface(typeface);
        message .setTypeface(typeface);
        positive.setTypeface(typeface);
        negative.setTypeface(typeface);

        title    .setBackgroundColor(object.getTitleBackground());
        titleIcon.setBackgroundColor(object.getTitleBackground());

        title  .setText(object.getTitle());
        message.setText(object.getMessage());

        title  .setGravity(object.getGravityTitle());
        message.setGravity(object.getGravityMessage());

        positive.setText(object.getPositive());
        negative.setText(object.getNegative());

        positiveIcon.setImageResource(object.getNegativeIcon());
        negativeIcon.setImageResource(object.getPositiveIcon());

        positiveParent.setOnClickListener(this);
        negativeParent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == positiveParent) {
            if (object.getAlertDialogListener() != null) {
                object.getAlertDialogListener().onPositiveClick();
            }
        } else if (v == negativeParent) {
            if (object.getAlertDialogListener() != null) {
                object.getAlertDialogListener().onNegativeClick();
            }
        }
    }
}
