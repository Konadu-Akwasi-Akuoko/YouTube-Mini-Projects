package com.example.cardchecker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cardchecker.customFunctions.HomeScreenFunctions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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
                //Handling edge case, when the user does not input any value, it sends 0
                // because nothing has been typed. So it needs to stop,otherwise the
                // success page would be called, because 0%0 is 0.
                // We can check if the textField has some input or not before calling he ValidateNumber function
                if (!txtViewInputCardNo.getText().toString().equals("")) {
                    if (homeScreenFunctions.ValidateNumber(txtViewInputCardNo.getText().toString())) {
                        //If true change the view to success.
                        System.out.println("Valid card");
                        Intent intent = new Intent(HomeScreen.this, SuccessScreen.class);
                        startActivity(intent);
                    } else {
                        //Otherwise change the view to failed.
                        System.out.println("Not a valid card.");
                        Intent intent = new Intent(HomeScreen.this, FailActivity.class);
                        startActivity(intent);
                    }
                } else {
                    //If the user types nothing create an alert and put it inside an AlertDialog.
                    AlertDialog.Builder alert_TypeAText = new AlertDialog.Builder(HomeScreen.this);
                    alert_TypeAText.setMessage(R.string.message_home_alert);
                    alert_TypeAText.setCancelable(true);
                    alert_TypeAText.setPositiveButton(R.string.alert_positive_button, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alert_TypeAText.create();
                    alertDialog.show();
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