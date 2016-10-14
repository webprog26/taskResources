package com.example.webprog26.taskresources;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TaskResourcesMain";

    private Button mBtnControl;
    private CheckBox mChbControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnControl = (Button) findViewById(R.id.btnControl);
        mChbControl = (CheckBox) findViewById(R.id.chbControl);

        mBtnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               changeViewEnabledState(mChbControl);

                if(!mChbControl.isEnabled())
                {
                    mBtnControl.setText(getResources().getString(R.string.en_checkbox));
                } else {
                    mBtnControl.setText(getResources().getString(R.string.dis_checkbox));
                }
            }
        });

        mChbControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeViewEnabledState(mBtnControl);

                if(!mBtnControl.isEnabled())
                {
                    mChbControl.setText(getResources().getString(R.string.en_button));
                } else {
                    mChbControl.setText(getResources().getString(R.string.dis_button));
                }
            }
        });
    }

    private void changeViewEnabledState(View v)
    {
        v.setEnabled(!v.isEnabled());
    }
}
