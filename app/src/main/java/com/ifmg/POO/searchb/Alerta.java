package com.ifmg.POO.searchb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;


import com.ifmg.POO.searchb.modelos.AlertaData;

public class Alerta extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int horas;
    private int minutos;
    private AlertaData dataAlerta = new AlertaData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta);
        createNotificationChannel();
        //Criando o Spinner para horas
        Spinner horas = (Spinner) findViewById(R.id.hour_spinner);
        ArrayAdapter<CharSequence> adapterHor = ArrayAdapter.createFromResource(this,R.array.hour_spinner, android.R.layout.simple_spinner_item);
        adapterHor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horas.setAdapter(adapterHor);
        horas.setOnItemSelectedListener(this);

        //Criando o Spinner para os minutos
        Spinner min = (Spinner) findViewById(R.id.min_spinner);
        ArrayAdapter<CharSequence> adapterMin = ArrayAdapter.createFromResource(this,R.array.minutes_spineer, android.R.layout.simple_spinner_item);
        adapterMin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        min.setAdapter(adapterMin);
        min.setOnItemSelectedListener(this);

        Button alerta = (Button) findViewById(R.id.alerta_button);

        alerta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = dataAlerta.getDataAlerta();
                calendar.set(Calendar.SECOND,0);
                if (calendar.getTime().compareTo(new Date()) < 0){
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }

                Intent intent = new Intent(Alerta.this,NotificaitonReminder.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(Alerta.this,0,intent,0);

                AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);


                if (alarmManager != null) {
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                    Toast.makeText (Alerta.this,"Seu alarme foi marcado para  "+calendar.getTime().toString(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                CharSequence name = "Alerta";
                String description = " Canal para alertas ";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("alerta",name, importance);
                channel.setDescription(description);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if(adapterView.getId() == R.id.hour_spinner){

            horas = Integer.parseInt(adapterView.getItemAtPosition(position).toString());
            Calendar calendar = dataAlerta.getDataAlerta();

            calendar.set(Calendar.HOUR_OF_DAY, horas);

            dataAlerta.setDataAlerta(calendar);

        }else if(adapterView.getId() == R.id.min_spinner){

            minutos = Integer.parseInt(adapterView.getItemAtPosition(position).toString());

            Calendar calendar = dataAlerta.getDataAlerta();

            calendar.set(Calendar.MINUTE, minutos);

            dataAlerta.setDataAlerta(calendar);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}