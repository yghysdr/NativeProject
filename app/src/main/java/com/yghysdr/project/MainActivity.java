package com.yghysdr.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yghysdr.cmakelib.HelloCMake;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView viewContentOne = findViewById(R.id.viewContentOne);
        viewContentOne.setText(new HelloCMake().getString());
    }
}
