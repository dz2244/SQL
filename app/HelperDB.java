import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;

    public HelperDB (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        strCreate = "CREATE TABLE " + Worker.TABLE_WORKER;
        strCreate+=" ("+Worker.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+Worker.FIRST_NAME+" TEXT,";
        strCreate+=" "+Worker.COMPANY+" TEXT,";
        strCreate+=" "+Worker.LAST_NAME+" TEXT,";
        strCreate+=" "+Worker.PHONE_NUMBER+" INTEGER";
        strCreate+=" "+Worker.ID+" INTEGER";
        strCreate+=" "+Worker.CARD+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);


        strCreate="CREATE TABLE "+ParkFood.TABLE_PARKFOOD;
        strCreate+=" ("+ParkFood.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+ParkFood.NAME_COMPANY+" TEXT,";
        strCreate+=" "+ParkFood.COMPANY_ID+" INTEGER";
        strCreate+=" "+ParkFood.MAIN_PHONE+" INTEGER";
        strCreate+=" "+ParkFood.SECONDARY_PHONE+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+Meal.TABLE_MEAL;
        strCreate +=" ("+Meal.KEY_ID +" INTEGER PRIMARY KEY,";
        strCreate +=" "+Meal.STARTER+" TEXT,";
        strCreate +=" "+Meal.MAIN_MEAL+" TEXT ";
        strCreate +=" "+Meal.SIDE_MEAL+" TEXT,";
        strCreate +=" "+Meal.DESSERT+" TEXT";
        strCreate += ");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}