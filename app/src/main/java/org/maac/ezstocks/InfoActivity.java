package org.maac.ezstocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.IOException;

public class InfoActivity extends AppCompatActivity {
    private String stockInput;
    private TextView mText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mText = (TextView)findViewById(R.id.infoView);
        Intent intent = getIntent();
        String data = intent.getStringExtra("STOCK");

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 138.68),
                new DataPoint(1, 139),
                new DataPoint(2, 139.52),
                new DataPoint(3, 139.34),
                new DataPoint(4, 139.78),
                new DataPoint(5, 138.96),
                new DataPoint(6, 139.79),
                new DataPoint(7, 136.99)
        });
        graph.addSeries(series);

        mText.setText("In the last 7 days, the highest closing price was 139.78\nIn the last 7 days, the" +
                "closing low was 138.68.\nThe stock has dropped in price a bit, watch with caution. ");
        //Toast.makeText(this, "next "+data, Toast.LENGTH_LONG).show();

       // mText.setText(data);
        /*try{
            Stock stock = new Stock(data);
            System.out.println(stock.toString());
            mText.setText(stock.toString());
        }catch(IOException ex){
System.out.println("Broken");
        }*/




        }




}

