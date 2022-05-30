package com.example.zakatpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WearActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etGram;
    EditText etValue;
    Button wearButton;
    TextView totalweightwear;
    TextView zakatpayable;
    TextView totalzakat;

    SharedPreferences sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wear);

        etGram = (EditText) findViewById(R.id.goldweight);
        etValue = (EditText) findViewById(R.id.goldvalue);
        wearButton = (Button) findViewById(R.id.wearButton);
        totalweightwear = (TextView) findViewById(R.id.totalweightwear);
        zakatpayable = (TextView) findViewById(R.id.zakatpayable);
        totalzakat = (TextView) findViewById(R.id.totalzakat);

        wearButton.setOnClickListener(this);

        //sharedPref = this.getSharedPreferences("weight", Context.MODE_PRIVATE);
        //sharedPref = this.getSharedPreferences("value", Context.MODE_PRIVATE);


        //load data
        //int weight = sharedPref.getInt("weight", 0);
        //int value = sharedPref.getInt("value", 0);


        //etGram.setText(""+weight);
        //etValue.setText(""+value);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.wearButton:

                try{


                    int weight = Integer.parseInt(etGram.getText().toString());
                    int value = Integer.parseInt(etValue.getText().toString());
                    double goldweight = weight - 200;

                    if(goldweight < 0) {
                        double payable = 0 * value;
                        double totzakat = payable * 0.025;


                        totalweightwear.setText("Gold weight - Uruf :" + goldweight + "gram");
                        zakatpayable.setText("You do not need to pay for gold zakat");

                    } else {

                        double payable = goldweight * value;
                        double totzakat = payable * 0.025;


                        totalweightwear.setText("Gold weight - Uruf (200 gram) :" + goldweight + " gram");
                        zakatpayable.setText("Zakat Payable : RM " + payable);
                        totalzakat.setText("Total Zakat : RM " + totzakat);

                    }

                    //saving data
                    //SharedPreferences.Editor editor = sharedPref.edit();
                    //editor.putInt("weight",weight);
                    //editor.putInt("value",value);
                    //editor.apply();

                } catch (java.lang.NumberFormatException nfe){

                    Toast toast = Toast.makeText(this, "Please enter a valid value",Toast.LENGTH_SHORT);
                    toast.show();


                } catch(Exception exp) {

                    Toast toast = Toast.makeText(this, "Unknown Exception" + exp.getMessage(),Toast.LENGTH_SHORT);
                    toast.show();

                    Log.d("Exception",exp.getMessage());

                }
                break;

        }
    }
}