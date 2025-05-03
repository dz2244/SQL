package com.example.sql;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db ;
    HelperDB hlp ;
    Button tableBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableBtn = findViewById(R.id.tableBtn);
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
    }

    public void ClickedTableBtn(View view)
    {
        Intent si = new Intent(this, Display.class);
        startActivity(si);

    }

    /**
     * Inflates the options menu.
     *
     * @param menu the options menu.
     * @return true if the menu is successfully created.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles selection of menu items.
     *
     * @param item the selected menu item.
     * @return true if the item is successfully handled.
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Credits) {
            Intent si = new Intent(this, CreditsA.class);
            startActivity(si);
        }
        if (id == R.id.Main) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (id == R.id.WorkerA) {
            Intent si = new Intent(this, WorkerA.class);
            startActivity(si);
        }
        if (id == R.id.OrderA) {
            Intent si = new Intent(this, OrderA.class);
            startActivity(si);
        }
        if (id == R.id.MealA) {
            Intent si = new Intent(this, MealA.class);
            startActivity(si);
        }
        if (id == R.id.ParkFoodA) {
            Intent si = new Intent(this, ParkFoodA.class);
            startActivity(si);
        }

        return true;
    }

}