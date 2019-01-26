# EasyUtil
Useful Library

![screen_shot](https://github.com/mehrdadf7/EasyUtil/blob/master/screen_shot.png)

## Setup
```xml
implementation 'github.mehrdadf7:util:1.0.3'
```

## options
### App class includes static methods: 
    .Check PhoneNumber
    .EasyLog by TAG "log"
    .Gradient Toast
    .EasyVisibility
    .EasyAnimation by YoYo
    
### And:
    .Custom AlertDialog
    .Pagination(Load More for RecyclerView)

### example dialog
```java
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
```
