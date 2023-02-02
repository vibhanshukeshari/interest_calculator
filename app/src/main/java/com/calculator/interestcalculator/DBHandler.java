package com.calculator.interestcalculator;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "recorddb";

    // below int is our database version
    private static final int DB_VERSION = 3;

    // below variable is for our table name.
    private static final String TABLE_NAME = "myrecord";

    // below variable is for our id column.
    private static final String ID_COL = "id";


    private static final String NAME_COL = "name_col";

    private static final String TYPE_S_OR_C_COL = "type_s_or_c_col";

    private static final String DATE_COL = "date_col";

    private static final String PRINCIPAL_AMOUNT_COL = "principal_amount_col";

    private static final String INTEREST_RATE_COL = "interest_rate_col";

    private static final String INTEREST_FREQUENCY_COL  = "interest_frequency_col";

    private static final String YEAR_COL = "year_col";

    private static final String MONTH_COL = "month_col";

    private static final String DAY_COL = "day_col";

    private static final String COMPOUNDING_FREQUENCY_COL = "compounding_frequency_col";

    private static final String INTEREST_AMOUNT_COL = "interest_amount_col";

    private static final String TOTAL_AMOUNT_COL = "total_amount_col";



    // creating a constructor for our database handler.
    public DBHandler(Context context) {
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
                + COMPOUNDING_FREQUENCY_COL + " TEXT,"
                + INTEREST_AMOUNT_COL + " TEXT,"
                + TOTAL_AMOUNT_COL + " TEXT)";


        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewRecords(String name, String typeSorC, String dateCol, String principalAmount,
                              String interestRate, String interestFrequency, String year, String month,
                              String day, String compoundingFrequency, String interestAmount, String totalAmount) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

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
        values.put(COMPOUNDING_FREQUENCY_COL , compoundingFrequency );
        values.put( INTEREST_AMOUNT_COL,interestAmount );
        values.put(TOTAL_AMOUNT_COL,totalAmount );

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the courses.
    public ArrayList<RecordModal> readData() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorRecords = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<RecordModal> recordModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorRecords.moveToLast()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                recordModalArrayList.add(new RecordModal(cursorRecords.getString(1),
                        cursorRecords.getString(2),
                        cursorRecords.getString(3),
                        cursorRecords.getString(4),
                        cursorRecords.getString(5),
                        cursorRecords.getString(6),
                        cursorRecords.getString(7),
                        cursorRecords.getString(8),
                        cursorRecords.getString(9),
                        cursorRecords.getString(10),
                        cursorRecords.getString(11),
                        cursorRecords.getString(12)

                ));
            } while (cursorRecords.moveToPrevious());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorRecords.close();
        return recordModalArrayList;
    }

//    public void deleteCurrency(String currency2000, String currency500, String currency200, String currency100,
//                               String currency50, String currency20, String currency10, String currency5,
//                               String currency20_coin, String currency10_coin, String currency5_coin, String currency_2_coin,
//                               String currency1_coin, String currency_extra, String result, String payee, String date,
//                               String time, String day, String notes, String coins) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        db.delete(TABLE_NAME, "two_thousand_col=? and five_hundred=? and two_hundred=? and one_hundred=? and fifty=? and twenty=? and ten=?" +
//                " and five=? and twenty_coin=? and ten_coin=? and five_coin=? and two_coin=? and one_coin=? and extra_coin=? and result=? and payee_name=? and date=? and time=? and day=? and notes=? and coins=?",new String[] {currency2000,currency500,currency200,currency100
//                ,currency50,currency20,currency10,currency5,currency20_coin,currency10_coin,currency5_coin,currency_2_coin
//                ,currency1_coin,currency_extra,result,payee,date,time,day,notes,coins});
//
//        db.close();

//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
