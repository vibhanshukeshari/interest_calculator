package com.calculator.interestcalculator;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class DBHandlerSimple extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "recorddbsimple";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "myrecordsimple";

    // below variable is for our id column.
    private static final String ID_COL = "idsimple";


    private static final String NAME_COL = "name_col";

    private static final String TYPE_S_OR_C_COL = "type_s_or_c_col";

    private static final String DATE_COL = "date_col";

    private static final String PRINCIPAL_AMOUNT_COL = "principal_amount_col";

    private static final String INTEREST_RATE_COL = "interest_rate_col";

    private static final String INTEREST_FREQUENCY_COL  = "interest_frequency_col";

    private static final String YEAR_COL = "year_col";

    private static final String MONTH_COL = "month_col";

    private static final String DAY_COL = "day_col";

    private static final String INTEREST_AMOUNT_COL = "interest_amount_col";

    private static final String TOTAL_AMOUNT_COL = "total_amount_col";

    private static final String TIME_AS_UNIQUE_ID_COL = "time_as_unique_id_col";



    // creating a constructor for our database handler.
    public DBHandlerSimple(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + TYPE_S_OR_C_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + PRINCIPAL_AMOUNT_COL + " TEXT,"
                + INTEREST_RATE_COL + " TEXT,"
                + INTEREST_FREQUENCY_COL + " TEXT,"
                + YEAR_COL + " TEXT,"
                + MONTH_COL + " TEXT,"
                + DAY_COL + " TEXT,"
                + INTEREST_AMOUNT_COL + " TEXT,"
                + TOTAL_AMOUNT_COL + " TEXT," +
                TIME_AS_UNIQUE_ID_COL + " TEXT)";


        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewRecords(String name, String typeSorC, String dateCol, String principalAmount,
                              String interestRate, String interestFrequency, String year, String month,
                              String day, String interestAmount, String totalAmount, String timeAsUniqueId) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase dbSimple = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(TYPE_S_OR_C_COL, typeSorC);
        values.put(DATE_COL, dateCol);
        values.put(PRINCIPAL_AMOUNT_COL,principalAmount );
        values.put(INTEREST_RATE_COL,interestRate );
        values.put(INTEREST_FREQUENCY_COL,interestFrequency );
        values.put(YEAR_COL, year );
        values.put(MONTH_COL,month);
        values.put( DAY_COL,day );
        values.put( INTEREST_AMOUNT_COL,interestAmount );
        values.put(TOTAL_AMOUNT_COL,totalAmount );
        values.put( TIME_AS_UNIQUE_ID_COL,timeAsUniqueId );

        // after adding all values we are passing
        // content values to our table.
        dbSimple.insert(TABLE_NAME, null, values);
//        System.out.println("i was called");

        // at last we are closing our
        // database after adding database.
        dbSimple.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<RecordModalSimple> readData() {




        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase dbSimple = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorRecordsSimple = dbSimple.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<RecordModalSimple> recordModalArrayListSimple = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorRecordsSimple.moveToLast()) {
            do {


                // on below line we are adding the data from cursor to our array list.
                recordModalArrayListSimple.add(new RecordModalSimple(cursorRecordsSimple.getString(1),


                        cursorRecordsSimple.getString(2),
                        cursorRecordsSimple.getString(3),
                        cursorRecordsSimple.getString(4),
                        cursorRecordsSimple.getString(5),
                        cursorRecordsSimple.getString(6),
                        cursorRecordsSimple.getString(7),
                        cursorRecordsSimple.getString(8),
                        cursorRecordsSimple.getString(9),
                        cursorRecordsSimple.getString(10),
                        cursorRecordsSimple.getString(11),
                        cursorRecordsSimple.getString(12)




                ));
            } while (cursorRecordsSimple.moveToPrevious());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorRecordsSimple.close();
        return recordModalArrayListSimple;
    }

    public void deleteRecordSimple(String id) {

        SQLiteDatabase dbSimple = this.getWritableDatabase();

        // have to do same thing in total paisa app also please remember to do in future if you see this vibhu.
//        remember time textView is used as id and it is hidden in record_rv_item_simple
        dbSimple.delete(TABLE_NAME, "time_as_unique_id_col=?", new String[]{id});
        dbSimple.close();



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
