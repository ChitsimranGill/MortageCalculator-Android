package com.example.mortgagecalcul;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements android.view.View.OnClickListener {

    EditText text;
    SeekBar seekBar;
    TextView progressTextView;
    TextView finalResult;
    Float progressChangedValue;
    Float years;
    android.widget.Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        progressTextView = (TextView) findViewById(R.id.textView2);
        finalResult = (TextView) findViewById(R.id.textView);
        button = (Button) this.findViewById(R.id.button);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        progressChangedValue = (float) 5;
        progressTextView.setText("Current interest is 10");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = (float) progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                String p = ("Current interest is " +seekBar.getProgress());
                progressTextView.setText(p);
            }
        });

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
                CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);

                if (text.getText().length() == 0)
                {
                    Toast.makeText(this,"Please enter amount",Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if(rb1.isChecked())
                {
                    years = (float) 15;
                }
                if(rb2.isChecked())
                {
                    years = (float) 20;
                }
                if(rb3.isChecked())
                {
                    years = (float) 30;
                }

                if (text.getText().length() != 0)
                {
                    if (c1.isChecked())
                    {
                        finalResult.setText(String.valueOf(MortgageUtil.mortgageCalculator(inputValue, progressChangedValue, years, (float) (0.001 * inputValue))));
                    }

                    if(!c1.isChecked())
                    {
                        finalResult.setText(String.valueOf(MortgageUtil.mortgageCalculator(inputValue, progressChangedValue, years, 0)));
                    }

                }

        }
    }
}
