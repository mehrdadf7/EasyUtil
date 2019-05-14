# Custom Dialog

<img width="300" height="550" src="https://github.com/mehrdadf7/EasyUtil/blob/master/screen_shot.png">

```java
implementation 'github.mehrdadf7:util:1.0.5'

object = new AlertDialogObject()
                    .setTitle("Title")
                    .setMessage("body")
                    .setPositive("positive")
                    .setNegative("negative")
                    .setPositiveShow(true)
                    .setNegativeShow(true)
                    .setGravityMessage(Gravity.RIGHT)
                    .setGravityTitle(Gravity.RIGHT)
                    .setTitleIcon(R.drawable.ic_title)
                    .setPositiveIcon(R.drawable.ic_done)
                    .setNegativeIcon(R.drawable.ic_close)
                    .setTypeface(typeface)
                    .setAlertDialogListener(this); //implements AlertDialogListener

                dialog = new CustomDialog(context, object);
                dialog.setCancelable(true);
                dialog.show();


```
