package com.diet.simplecaloriecounter.simplecaloriecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter {

    private static final String databaseName = "simplecaloriecounter";
    private static final int databaseVersion = 58;

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);

    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, databaseName, null, databaseVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL("CREATE TABLE IF NOT EXISTS goal (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "goal_id INT," +
                        "goal_current_weight INT," +
                        "goal_target_weight INT," +
                        "goal_weekly_goal VARCHAR," +
                        "goal_i_want_to VARCHAR," +
                        "goal_activity_level INT," +
                        "goal_energy_BMR INT," + // Energy BMR
                        "goal_proteins_BMR INT," +
                        "goal_carbs_BMR INT," +
                        "goal_fat_BMR INT," +
                        "goal_energy_with_activity INT," + // Energy with Activity
                        "goal_proteins_with_activity INT," +
                        "goal_carbs_with_activity INT," +
                        "goal_fat_with_activity INT," +
                        "goal_energy_with_diet INT," + // Energy with Diet
                        "goal_proteins_with_diet INT," +
                        "goal_carbs_with_diet INT," +
                        "goal_fat_with_diet INT," +
                        "goal_energy_with_activity_and_diet INT," + // Energy with Activity and Diet
                        "goal_proteins_with_activity_and_diet INT," +
                        "goal_carbs_with_activity_and_diet INT," +
                        "goal_fat_with_activity_and_diet INT," +
                        "goal_date DATE);");

                db.execSQL("CREATE TABLE IF NOT EXISTS users (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "user_id INT," +
                        "user_email VARCHAR," +
                        "user_password VARCHAR," +
                        "user_dob DATE," +
                        "user_gender INT," +
                        "user_height DOUBLE," +
                        "user_activity_level INT," +
                        "user_mesurment VARCHAR);");


                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_cal_eaten (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "fdce_id INTEGER, " +
                        "fdce_date DATE, " +
                        "fdce_meal_no INT, " +
                        "fdce_eaten_energy INT, " +
                        "fdce_eaten_proteins INT, " +
                        "fdce_eaten_carbs INT, " +
                        "fdce_eaten_fat INT);");



                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "fd_id INT," +
                        "fd_date DATE," +
                        "fd_meal_number INT," +
                        "fd_food_id INT," +
                        "fd_serving_size_gram DOUBLE," +
                        "fd_serving_size_gram_measurement VARCHAR," +
                        "fd_serving_size_pcs DOUBLE," +
                        "fd_serving_size_pcs_measurement VARCHAR," +
                        "fd_energy_calculated DOUBLE," +
                        "fd_proteins_calculated DOUBLE," +
                        "fd_carbohydrates_calculated DOUBLE," +
                        "fd_fats_calculated DOUBLE," +
                        "fd_fat_meal_id INT);");



                db.execSQL("CREATE TABLE IF NOT EXISTS food (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "food_id INT," +
                        "food_name VARCHAR," +
                        "food_description VARCHAR," +
                        "food_manufactor_name VARCHAR," +
                        "food_serving_size DOUBLE," +
                        "food_serving_measurement VARCHAR," +
                        "food_serving_name_number DOUBLE," +
                        "food_serving_name_word VARCHAR," +
                        "food_energy DOUBLE," +
                        "food_proteins DOUBLE," +
                        "food_carbohydrates DOUBLE," +
                        "food_fats DOUBLE," +
                        "food_energy_calculated DOUBLE," +
                        "food_proteins_calculated DOUBLE," +
                        "food_carbohydrates_calculated DOUBLE," +
                        "food_fats_calculated DOUBLE);");

                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_sum (" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "food_diary_sum_id INTEGER, " +
                        "food_diary_sum_date DATE, " +
                        "food_diary_sum_energy INT, " +
                        "food_diary_sum_proteins INT, " +
                        "food_diary_sum_carbs INT, " +
                        "food_diary_sum_fat INT);");

            } catch (SQLException e) {
                e.printStackTrace();


            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS goal");
            db.execSQL("DROP TABLE IF EXISTS users");
            db.execSQL("DROP TABLE IF EXISTS food_diary_cal_eaten");
            db.execSQL("DROP TABLE IF EXISTS food_diary");
            db.execSQL("DROP TABLE IF EXISTS food_diary_sum");
            db.execSQL("DROP TABLE IF EXISTS categories");
            db.execSQL("DROP TABLE IF EXISTS food");
            onCreate(db);

            String TAG = "Tag";
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");

        }

    }

    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        DBHelper.close();
    }

    public String quoteSmart(String value){
        boolean isNumeric = false;
        try {
            double myDouble = Double.parseDouble(value);
            isNumeric = true;
        }
        catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
        if(isNumeric == false){
            if (value != null && value.length() > 0) {
                value = value.replace("\\", "\\\\");
                value = value.replace("'", "\\'");
                value = value.replace("\0", "\\0");
                value = value.replace("\n", "\\n");
                value = value.replace("\r", "\\r");
                value = value.replace("\"", "\\\"");
                value = value.replace("\\x1a", "\\Z");
            }
        }

        value = "'" + value + "'";


        return value;
    }
    public double quoteSmart(double value) {
        return value;
    }


    public int quoteSmart(int value) {
        return value;
    }


    public long quoteSmart(long value) {
        return value;
    }

    public void insert(String table, String fields, String values) {

        try{
            db.execSQL("INSERT INTO " + table + "(" + fields + ") VALUES (" + values + ")");
        }catch (SQLiteException e){
            System.out.println("Insert Error" +e.toString());
        }
    }
    public void insert(String table, String fields, double values) {

        try{
            String v=String.valueOf(values);
            db.execSQL("INSERT INTO " + table + "(" + fields + ") VALUES (" + v + ")");
        }catch (SQLiteException e){
            System.out.println("Insert Error" +e.toString());
        }
    }

    public int count(String table)
    {
        try{
            Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM " + table + "",null);
            mCount.moveToFirst();
            int count = mCount.getInt(0);
            mCount.close();
            return count;
        }catch (SQLiteException e){
            return -1;
        }

    }


    public Cursor select(String table, String[] fields) throws SQLException
    {
        Cursor mCursor = db.query(table, fields, null, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor select(String table, String[] fields, String[] whereClause, String[] whereCondition, String[] whereAndOr) throws SQLException
    {
        String where = "";
        int arraySize = whereClause.length;
        for(int x=0;x<arraySize;x++) {
            if(where.equals("")) {
                where = whereClause[x] + "=" + whereCondition[x];
            }
            else{
                where = where + " " + whereAndOr[x-1] + " " + whereClause[x] + "=" + whereCondition[x];
            }
        }


        Cursor mCursor = db.query(table, fields, where, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor select(String table, String[] fields, String whereClause, String whereCondition, String orderBy, String OrderMethod) throws SQLException
    {
        Cursor mCursor;
        if(whereClause.equals("")) {
            mCursor = db.query(table, fields, null, null, null, null, orderBy + " " + OrderMethod, null);
        }
        else {
            mCursor = db.query(table, fields, whereClause + "=" + whereCondition, null, null, null, orderBy + " " + OrderMethod, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor select(String table, String[] fields, String whereClause, String whereCondition) throws SQLException
    {
        Cursor mCursor = db.query(table, fields, whereClause + "=" + whereCondition, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor selectPrimaryKey(String table, String primaryKey, long rowId, String [] field) throws SQLException
    {
        Cursor mCursor = db.query(table, field,primaryKey + "=" + rowId, null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public boolean update(String table, String primaryKey, long rowId, String field, String value) throws SQLException{
          value = value.substring(1, value.length() - 1);//removes ' after running quoteSmart
          ContentValues args = new ContentValues();
          args.put(field, value);
          return db.update(table, args, primaryKey +"="+ rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowId, String field, double value) throws SQLException{
        ContentValues args = new ContentValues();
        args.put(field, value);
        return db.update(table, args, primaryKey +"="+ rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowId, String field, int value) throws SQLException{
        ContentValues args = new ContentValues();
        args.put(field, value);
        return db.update(table, args, primaryKey +"="+ rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowID, String[] fields, String[] values) {


        ContentValues args = new ContentValues();
        int arraySize = fields.length;
        for (int x = 0; x < arraySize; x++) {

            values[x] = values[x].substring(1, values[x].length() - 1);
            args.put(fields[x], values[x]);
        }

        return db.update(table, args, primaryKey + "=" + rowID, null) > 0;
    }

        public int delete(String table, String primaryKey, long rowID) throws SQLException {
           return db.delete(table, primaryKey + "=" + rowID, null);
        }
}
