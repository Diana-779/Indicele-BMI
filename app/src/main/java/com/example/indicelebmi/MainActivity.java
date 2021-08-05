package com.example.indicelebmi;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv5 = (TextView) findViewById(R.id.tv5);
        findViewById((R.id.ib1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                if (TextUtils.isEmpty(str1)) {
                    e1.setError("introduce greutatea");
                    e1.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    e2.setError("introdu greutatea");
                    e2.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2) / 100;
                float bmiValue = calculateBMI(weight, height);
                String bmiInterpretation = interpretBMI(bmiValue);
                tv5.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });
    }

    private float calculateBMI(float weight, float height) {
        return (float) (weight / (height * height));
    }

    private String interpretBMI(float bmiValue) {
        if (bmiValue < 16) {
            return "Greutate scazuta severa";
        } else if (bmiValue < 18.5) {
            return "Greutate scazuta";
        } else if (bmiValue < 25) {
            return "Greutate normala";
        } else if (bmiValue < 30) {
            return "Greutate ridicata";
        } else {
            return "Obezitate";
        }
    }
}




