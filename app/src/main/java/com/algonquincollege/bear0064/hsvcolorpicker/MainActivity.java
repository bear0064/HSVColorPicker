package com.algonquincollege.bear0064.hsvcolorpicker;

/**
 *  A Beautiful Color Picker Application designed and developed for Gerry.
 *  @author bear0064@algonquinlive.com
 */


import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;





public class MainActivity extends AppCompatActivity {


    // CLASS VARIABLES (by convention, class vars in upper-case)
    private static final String ABOUT_DIALOG_TAG;

    //TODO pro-tip: class vars (i.e. static vars) can be initialized within a static block initializer.
    static {
        ABOUT_DIALOG_TAG = "About Dialog";
    }

    float[] hsv = new float[3];
    float hue = hsv[0];
    float sat = hsv[1];
    float val = hsv[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView swatchColor = (TextView) findViewById(R.id.colorSwatch);

        swatchColor.setBackgroundColor(Color.HSVToColor(hsv));


        final SeekBar hueSB = (SeekBar) findViewById(R.id.hueSB);
        final SeekBar saturationSB = (SeekBar) findViewById(R.id.saturationSB);
        final SeekBar valueSB = (SeekBar) findViewById(R.id.valueSB);

        final TextView hueNotifier = (TextView) findViewById(R.id.hueNotifier);
        final TextView satNotifier = (TextView) findViewById(R.id.saturationNotifier);
        final TextView valNotifier = (TextView) findViewById(R.id.valueNotifier);

        final Button blackButton = (Button) findViewById(R.id.blackButton);
        final Button redButton = (Button) findViewById(R.id.redButton);
        final Button limeButton = (Button) findViewById(R.id.limeButton);
        final Button blueButton = (Button) findViewById(R.id.blueButton);
        final Button yellowButton = (Button) findViewById(R.id.yellowButton);
        final Button cyanButton = (Button) findViewById(R.id.cyanButton);
        final Button magentaButton = (Button) findViewById(R.id.magentaButton);
        final Button silverButton = (Button) findViewById(R.id.silverButton);
        final Button grayButton = (Button) findViewById(R.id.grayButton);
        final Button maroonButton = (Button) findViewById(R.id.maroonButton);
        final Button oliveButton = (Button) findViewById(R.id.oliveButton);
        final Button greenButton = (Button) findViewById(R.id.greenButton);
        final Button purpleButton = (Button) findViewById(R.id.purpleButton);
        final Button tealButton = (Button) findViewById(R.id.tealButton);
        final Button navyButton = (Button) findViewById(R.id.navyButton);



        hueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                float[] hsvColor = {hue, sat, val};

                hue = progress;

                hsv[0] =  (float)progress * 360f / 360f ;

                swatchColor.setBackgroundColor(Color.HSVToColor(hsv));
                hueNotifier.setText("HUE: " + ((int) hue) + " \u00B0");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hueNotifier.setText("Hue");


            }
        });



        saturationSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                float[] hsvColor = {hue, sat, val};


                sat = progress;
                hsv[1] = (float)progress / 100f;

                swatchColor.setBackgroundColor(Color.HSVToColor(hsv));
                satNotifier.setText("SATURATION: " + ((int)sat) + " \u0025");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                satNotifier.setText("Saturation");
            }
        });


        valueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//                float[] hsvColor = {hue, sat, val};

                val = progress;

                hsv[2] = (float) progress / 100f;

                swatchColor.setBackgroundColor(Color.HSVToColor(hsv));
                valNotifier.setText("VALUE / LIGHTNESS: " + ((int) val) + " \u0025");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valNotifier.setText("Value / Lightness");
            }
        });


        swatchColor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(getApplicationContext(), "H:" + ((int) hue) + "\u00B0 " + "S:" + ((int) sat) + "\u0025 " + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();
                return true;
            }
        });










        //Black
        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v){

                ColorDrawable blackBack = (ColorDrawable) blackButton.getBackground();
                int blackColor= blackBack.getColor();
                swatchColor.setBackgroundColor(blackColor);
                Color.colorToHSV(blackColor, hsv);


                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int) hsv1[1]);
                valueSB.setProgress((int) hsv1[2]);

                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //red
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ColorDrawable redBack = (ColorDrawable) redButton.getBackground();
                int redColor= redBack.getColor();
                swatchColor.setBackgroundColor(redColor);
                Color.colorToHSV (redColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Lime
        limeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable limeBack = (ColorDrawable) limeButton.getBackground();
                int limeColor= limeBack.getColor();
                swatchColor.setBackgroundColor(limeColor);
                Color.colorToHSV (limeColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Blue
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable blueBack = (ColorDrawable) blueButton.getBackground();
                int blueColor= blueBack.getColor();
                swatchColor.setBackgroundColor(blueColor);
                Color.colorToHSV (blueColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Yellow
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable yellowBack = (ColorDrawable) yellowButton.getBackground();
                int yellowColor= yellowBack.getColor();
                swatchColor.setBackgroundColor(yellowColor);
                Color.colorToHSV (yellowColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Cyan
        cyanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable cyanBack = (ColorDrawable) cyanButton.getBackground();
                int cyanColor= cyanBack.getColor();
                swatchColor.setBackgroundColor(cyanColor);
                Color.colorToHSV (cyanColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Magenta
        magentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable magentaBack = (ColorDrawable) magentaButton.getBackground();
                int magentaColor= magentaBack.getColor();
                swatchColor.setBackgroundColor(magentaColor);
                Color.colorToHSV(magentaColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");


                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Silver
        silverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable silverBack = (ColorDrawable) silverButton.getBackground();
                int silverColor= silverBack.getColor();
                swatchColor.setBackgroundColor(silverColor);
                Color.colorToHSV(silverColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Gray
        grayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable grayBack = (ColorDrawable) grayButton.getBackground();
                int grayColor= grayBack.getColor();
                swatchColor.setBackgroundColor(grayColor);
                Color.colorToHSV(grayColor, hsv);


                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Maroon
        maroonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable maroonBack = (ColorDrawable) maroonButton.getBackground();
                int maroonColor= maroonBack.getColor();
                swatchColor.setBackgroundColor(maroonColor);
                Color.colorToHSV(maroonColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");
                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Olive
        oliveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable oliveBack = (ColorDrawable) oliveButton.getBackground();
                int oliveColor= oliveBack.getColor();
                swatchColor.setBackgroundColor(oliveColor);

                Color.colorToHSV(oliveColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int) hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Green
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable greenBack = (ColorDrawable) greenButton.getBackground();
                int greenColor= greenBack.getColor();
                swatchColor.setBackgroundColor(greenColor);

                Color.colorToHSV(greenColor, hsv);

                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");
                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Purple
        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable purpleBack = (ColorDrawable) purpleButton.getBackground();
                int purpleColor= purpleBack.getColor();
                swatchColor.setBackgroundColor(purpleColor);

                Color.colorToHSV(purpleColor, hsv);
                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");
                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

        //Teal
        tealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ColorDrawable tealBack = (ColorDrawable) tealButton.getBackground();
                int tealColor= tealBack.getColor();
                swatchColor.setBackgroundColor(tealColor);

                Color.colorToHSV (tealColor, hsv);
                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();

            }
        });

        //Navy
        navyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ColorDrawable navyBack = (ColorDrawable) navyButton.getBackground();
                int navyColor = navyBack.getColor();

                Color.colorToHSV (navyColor, hsv);

                swatchColor.setBackgroundColor(navyColor);


                float[] hsv1 = new float[3];

                hsv1[0] = hsv[0];
                hsv1[1] = hsv[1] * 100;
                hsv1[2] = hsv[2] * 100;
                hueSB.setProgress((int) hsv1[0]);
                saturationSB.setProgress((int)hsv1[1]);
                valueSB.setProgress((int)hsv1[2]);
                valNotifier.setText("Value / Lightness");
                satNotifier.setText("Saturation");
                hueNotifier.setText("Hue");

                Toast.makeText(getApplicationContext(), "H:" + ((int)hue)  + "\u00B0 " + "S:" + ((int)sat) + "\u0025 "  + "V:" + ((int)val) + " \u0025", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

