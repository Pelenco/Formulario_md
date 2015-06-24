package com.example.usuario.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Date;


public class MainActivity extends Activity {


    EditText txt_nom;
    CalendarView fec;
    RadioButton  sex;

    public Integer ye;
    public Integer mo;
    public Integer da;

    public void onClic(View view){

        txt_nom =(EditText) findViewById(R.id.txt_nom);

        sex = (RadioButton) findViewById(R.id.Mas);
        sex=(RadioButton) findViewById(R.id.Fem);

        String n = txt_nom.getText().toString();

       Intent i=new Intent(this,Datos.class);

        i.putExtra("nombre",n);
        i.putExtra("dia",da);
        i.putExtra("mes",mo);
        i.putExtra("ano",ye);

startActivity(i);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fec = (CalendarView) findViewById(R.id.fec);

        fec.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                ye = year;
                mo=month;
                da=dayOfMonth;



            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
