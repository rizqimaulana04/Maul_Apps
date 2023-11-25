package com.hello;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        findViewById(R.id.btnSetAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk mengatur alarm
                setAlarm();
            }
        });

    }
    public void btnMaps(View view) {
        double latitude = 37.7749;
        double longitude = -122.4194;

        Uri geoLocation = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(Label)");

        showMap(geoLocation);
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
    private void setAlarm() {
        Intent alarm = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
        startActivity(alarm);
    }

    public void btnHelloWorld(View view) {
        Intent helloworld = new Intent(Home.this, MainActivity1.class);
        startActivity(helloworld);
    }
    public void btnCount(View view) {
        Intent count = new Intent(Home.this, CountActivity.class);
        startActivity(count);
    }
    public void btnSianida(View view) {
        Intent sianida = new Intent(Home.this, ScrollingIceCold.class);
        startActivity(sianida);
    }

    public void btnTwoActivity(View view) {
        Intent twoact = new Intent(Home.this, SecondActivity.class);
        startActivity(twoact);
    }

    public void btnFibonacci(View view) {
        Intent fibonacci = new Intent(Home.this, MainActivity.class);
        startActivity(fibonacci);
    }
}