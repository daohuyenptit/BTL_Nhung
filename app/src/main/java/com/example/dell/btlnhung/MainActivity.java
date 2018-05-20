package com.example.dell.btlnhung;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChartGestureListener,
        OnChartValueSelectedListener {
    private LineChart lcTem,lcHumid;
    ArrayList<Data> datas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        addControls();
        setData();



    }

    private void addControls() {
        lcTem=findViewById(R.id.lcTem);
        lcTem.setDragEnabled(true);
        lcTem.setScaleEnabled(true);

        lcHumid=findViewById(R.id.lcHumid);
        lcTem.setDragEnabled(true);
        lcTem.setScaleEnabled(true);
        Data data1 =new Data();
        data1.setTemperature(25);
        data1.setHumidity(86);
        data1.setCreatedDate(19);

        Data data2 =new Data();
        data2.setTemperature(27);
        data2.setHumidity(89);
        data2.setCreatedDate(20);
        Data data3 =new Data();
        data3.setTemperature(29);
        data3.setHumidity(82);
        data3.setCreatedDate(21);
        Data data4 =new Data();
        data4.setTemperature(36);
        data4.setHumidity(90);
        data4.setCreatedDate(24);
        Data data5 =new Data();
        data5.setTemperature(30);
        data5.setHumidity(84);
        data5.setCreatedDate(22);
        Data data6 =new Data();
        data6.setTemperature(25);
        data6.setHumidity(80);
        data6.setCreatedDate(23);
        Data data7 =new Data();
        data7.setTemperature(32);
        data7.setHumidity(86);
        data7.setCreatedDate(19);
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);
        datas.add(data6);
        datas.add(data7);


    }


    private ArrayList<Entry> setYTemValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i <datas.size() ; i++) {
            yVals.add(new Entry(i, Float.valueOf(datas.get(i).getTemperature())));

        }

        return yVals;
    }
    private ArrayList<Entry> setYHumidValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i <datas.size() ; i++) {
            yVals.add(new Entry(i,Float.valueOf(datas.get(i).getHumidity())));

        }

        return yVals;
    }
    private LineData design(ArrayList<Entry> yVals){
        LineDataSet set1;
        LineDataSet set2;
        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "DataSet 1");
        set1.setFillAlpha(110);
        set1.setColor(Color.BLACK);

        set1.setFillAlpha(110);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        set1.setFillAlpha(110);
        set1.setColor(Color.BLACK);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets
        LineData data=new LineData(dataSets);
        return  data;

    }

    private void setData() {
        ArrayList<Entry> yVals = setYTemValues();
        ArrayList<Entry> yVals1 = setYHumidValues();
        lcTem.setData(design(yVals));
        lcHumid.setData(design(yVals1));

    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        if(lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
            // or highlightTouch(null) for callback to onNothingSelected(...)
            lcTem.highlightValues(null);
             lcHumid.highlightValues(null);

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
