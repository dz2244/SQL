package com.example.sql;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity for managing Order data.
 * Allows inserting new order records into the database.
 */
public class OrderA extends AppCompatActivity {

    EditText etdate, ettime, etemployee, etprovcomp;
    Button btnInsert, back_btn;
    SQLiteDatabase db;
    HelperDB hlp;

    /**
     * Initializes the activity, sets up UI elements, and prepares the database helper.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        hlp = new HelperDB(this);

        etdate = findViewById(R.id.etdate);
        ettime = findViewById(R.id.ettime);
        etemployee = findViewById(R.id.etemployee);
        etprovcomp = findViewById(R.id.etprovcomp);

        btnInsert = findViewById(R.id.btnInsert);
        back_btn = findViewById(R.id.back_btn);
    }

    /**
     * Inserts a new order record into the database.
     * Retrieves data from the input fields, validates it, and then inserts it into the database.
     *
     * @param v The View that triggered this method (the insert button).
     */
    public void onClick(View v) {
        db = hlp.getWritableDatabase();
        if (etdate.getText().toString().isEmpty() || etdate.equals("-") || etdate.equals("-.") || etdate.equals("+") ||
                etdate.equals("+.") || ettime.getText().toString().isEmpty() || ettime.equals("-") || ettime.equals("-.") ||
                ettime.equals("+") || ettime.equals("+.") ||  etemployee.getText().toString().isEmpty() || etemployee.equals("-") || etemployee.equals("-.") || etemployee.equals("+") || etemployee.equals("+.") ||
                etprovcomp.getText().toString().isEmpty() || etprovcomp.equals("-") || etprovcomp.equals("-.") || etprovcomp.equals("+") || etprovcomp.equals("+.")) {
            Toast.makeText(this, "invald input", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues values = new ContentValues();
            values.put(Order.DATE, etdate.getText().toString());
            values.put(Order.TIME, ettime.getText().toString());
            values.put(Order.EMPLOYEE, etemployee.getText().toString());
            values.put(Order.MEAL, Meal.KEY_ID);
            values.put(Order.COMPANY, etprovcomp.getText().toString());
            db.insert(Order.TABLE_ORDER, null, values);
            db.close();

            etdate.setText("");
            ettime.setText("");
            etemployee.setText("");
            etprovcomp.setText("");
            Toast.makeText(this, "The data has been saved", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Finishes the current activity and returns to the previous one.
     *
     * @param view The View that triggered this method (the back button).
     */
    public void back(View view) {
        finish();
    }

    /**
     * Creates the options menu.
     *
     * @param menu The options menu.
     * @return True to display the menu.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Handles item selections in the options menu.
     *
     * @param menu The selected menu item.
     * @return True if the item was handled, false otherwise.
     */
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