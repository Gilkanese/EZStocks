package org.maac.ezstocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.*;
import android.support.*;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit  = (EditText)findViewById(R.id.stockInput);
        Button mButton = (Button)findViewById(R.id.doneButton);

    }
    public void buttonOnClick(View view) {
        Log.i("button", "In button");
        String msg = mEdit.getText().toString();
        Log.i("button", "In button show content");
       // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("STOCK", msg);
        startActivity(intent);
    }

}
