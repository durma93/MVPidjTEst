package com.example.durma.sqlitenewbostontutorijal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";

    public static final String TABLE_PROUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_PRODUCTAUTOR = "autor";
    public static final String COLUMN_PRODUCTDUZINA = "duzina";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PROUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT, " +
                COLUMN_PRODUCTAUTOR + " TEXT, " +
                COLUMN_PRODUCTDUZINA + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROUCTS);
        onCreate(sqLiteDatabase);
    }

    //Add a now row to the database
    public void addProduct(Products products){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, products.get_productname());
        values.put(COLUMN_PRODUCTAUTOR, products.get_autor());
        values.put(COLUMN_PRODUCTDUZINA, products.get_duzina());

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_PROUCTS, null, values);
        sqLiteDatabase.close();
    }

    //Delete product from the database
    public void deleteProduct(String productName){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_PROUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";" );

    }

   /* public boolean productPersistence(String productName){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor d = sqLiteDatabase.rawQuery("SELECT " + COLUMN_PRODUCTNAME + " =\" " + productName + " \" " + " FROM " + TABLE_PROUCTS + " ;", null);
        if (d.moveToFirst()){
            sqLiteDatabase.close();
           return true;
        }else
           return false;


    }*/
    //Print out database as a string
    public String databaseToString(){

        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PROUCTS + " ;";

        String[] projections = {
                "_id",
                COLUMN_PRODUCTNAME,
                COLUMN_PRODUCTAUTOR,
                COLUMN_PRODUCTDUZINA
        };

        //Cursor point to a location in your results
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        //Cursor c = sqLiteDatabase.query(TABLE_PROUCTS,null,null,null,null,null,null);

        //Move to the first row in you result
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("productname"))!=null &&
                    c.getString(c.getColumnIndex("autor"))!=null &&
                    c.getInt(c.getColumnIndex("duzina"))!=0) {
                dbString += c.getString(c.getColumnIndex("productname")) +
                            '\n' + c.getString(c.getColumnIndex("autor")) +
                        '\n' + c.getInt(c.getColumnIndex("duzina"));
                dbString +="\n\n";
                c.moveToNext();
            }
        }
        sqLiteDatabase.close();
        return dbString;


    }





}
