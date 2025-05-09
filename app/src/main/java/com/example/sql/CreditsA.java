package com.example.sql;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class CreditsA extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        String num1 = menu.getTitle().toString();
        if (num1.equals("Credits")) {
            Intent si = new Intent(this, CreditsA.class);
            startActivity(si);
        }
        if (num1.equals("Main")) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (num1.equals("WorkerA")) {
            Intent si = new Intent(this,WorkerA.class);
            startActivity(si);
        }
        if (num1.equals("OrderA")) {
            Intent si = new Intent(this, OrderA.class);
            startActivity(si);
        }
        if (num1.equals("ParkFoodA")) {
            Intent si = new Intent(this, ParkFoodA.class);
            startActivity(si);
        }
        if (num1.equals("MealA")) {
            Intent si = new Intent(this, MealA.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(menu);
    }
}