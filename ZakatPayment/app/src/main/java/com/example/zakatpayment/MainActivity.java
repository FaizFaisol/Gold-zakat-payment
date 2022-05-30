package com.example.zakatpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zakatpayment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about :

                Intent about = new Intent(this,AboutActivity.class );
                startActivity(about);
                break;

            case R.id.keep :

                Intent keep = new Intent(this,KeepActivity.class );
                startActivity(keep);

                break;

            case R.id.wear :

                Intent wear = new Intent(this,WearActivity.class );
                startActivity(wear);
                break;


        }


        return super.onOptionsItemSelected(item);
    }

}