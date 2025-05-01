import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper {

    /** Database file name. */
    private static final String DATABASE_NAME = "dbexam.db";

    /** Current database version. */
    private static final int DATABASE_VERSION =9;

    /** String for creating tables. */
    String strCreate;

    /** String for deleting tables. */
    String strDelete;

    /**
     * Constructor.
     *
     * @param context The application context.
     */
    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creates the database tables.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate = "CREATE TABLE " + Worker.TABLE_WORKER +
                " (" + Worker.KEY_ID + " INTEGER PRIMARY KEY," +
                " " + Worker.FIRST_NAME + " TEXT," +
                " " + Worker.COMPANY + " TEXT," +
                " " + Worker.LAST_NAME + " TEXT," +
                " " + Worker.PHONE_NUMBER + " INTEGER," +
                " " + Worker.ID + " INTEGER," +
                " " + Worker.CARD + " INTEGER" +
                ");";
        db.execSQL(strCreate);

        strCreate = "CREATE TABLE " + ParkFood.TABLE_PARKFOOD +
                " (" + ParkFood.KEY_ID + " INTEGER PRIMARY KEY," +
                " " + ParkFood.COMPANY_NAME + " TEXT," +
                " " + ParkFood.COMPANY_ID + " INTEGER," +
                " " + ParkFood.MAIN_PHONE + " INTEGER," +
                " " + ParkFood.SECONDARY_PHONE + " INTEGER" +
                ");";
        db.execSQL(strCreate);

        strCreate = "CREATE TABLE " + Meal.TABLE_MEAL +
                " (" + Meal.KEY_ID + " INTEGER PRIMARY KEY," +
                " " + Meal.FIRST_MEAL + " TEXT," +
                " " + Meal.MAIN_MEAL + " TEXT," +
                " " + Meal.SIDE_MEAL + " TEXT," +
                " " + Meal.DESSERT + " TEXT" +
                ");";
        db.execSQL(strCreate);

        strCreate = "CREATE TABLE " + Order.TABLE_ORDER +
                " (" + Order.KEY_ID + " INTEGER PRIMARY KEY," +
                " " + Order.MEAL + " TEXT," +
                " " + Order.EMPLOYEE + " TEXT," +
                " " + Order.COMPANY + " TEXT," +
                " " + Order.DATE + " TEXT," +
                " " + Order.TIME + " INTEGER" +
                ");";
        db.execSQL(strCreate);
    }

    /**
     * Upgrades the database by dropping and recreating tables.
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete = "DROP TABLE IF EXISTS " + Worker.TABLE_WORKER;
        db.execSQL(strDelete);

        strDelete = "DROP TABLE IF EXISTS " + Meal.TABLE_MEAL;
        db.execSQL(strDelete);

        strDelete = "DROP TABLE IF EXISTS " + ParkFood.TABLE_PARKFOOD;
        db.execSQL(strDelete);

        strDelete = "DROP TABLE IF EXISTS " + Order.TABLE_ORDER;
        db.execSQL(strDelete);

        onCreate(db);
    }
}