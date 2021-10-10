package com.example.cardchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cardchecker.customFunctions.HomeScreenFunctions;

public class HomeScreen extends AppCompatActivity {

    HomeScreenFunctions homeScreenFunctions = new HomeScreenFunctions();

    //Buttons and textview
    private TextView txtViewInputCardNo;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapping the elements to the xml, and setting up their onCreate functions.
        txtViewInputCardNo = (TextView) findViewById(R.id.txtViewInputCardNo);
        txtViewInputCardNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Some code to check if what the user typed is more equal to sixteen or otherwise?
            }
        });

        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeScreenFunctions.ValidateNumber(txtViewInputCardNo.getText().toString())) {
                    //If true change the view to success.
                    System.out.println("Valid card");
                }
                else {
                    //Otherwise change the view to failed.
                    System.out.println("Not a valid card.");
                }
            }
        });

    }
}



/*How to change a view in android java
 buttonChangeView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
        }*/