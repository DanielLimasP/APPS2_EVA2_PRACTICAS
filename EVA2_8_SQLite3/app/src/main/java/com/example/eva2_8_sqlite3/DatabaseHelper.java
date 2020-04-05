package com.example.eva2_8_sqlite3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TestDB.db";
    public static final String TABLE_NAME = "tblAMIGO";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";
    public static final String COL3 = "ITEM2";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM1 TEXT, ITEM2 TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1, String item2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public int updateData(String oldVal, String newVal){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereArgs[] = {oldVal};
        ContentValues cv = new ContentValues();
        cv.put(COL2, newVal);
        int recAffected = db.update(TABLE_NAME, cv, "ITEM1 = ?", whereArgs);
        return recAffected;
    }

    public int deleteData(String item1){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereArgs[] = {item1};
        int affectedRow = db.delete(TABLE_NAME, "ITEM1 = ?", whereArgs);
        return affectedRow;
    }

    public Cursor queryData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"*"};
        String[] conditionArgs = {"Rodrigo"};
        Cursor c = db.query (TABLE_NAME,
                columns,
                "ITEM1 = ?",
                conditionArgs,
                "",
                "",
                ""
        );

        return c;
    }


}