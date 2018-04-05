package com.example.durma.dager2_retrofit_rx_databasemvp.mvp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by durma on 19.3.18..
 */

public class Storage extends SQLiteOpenHelper {

    private static final String TAG= Storage.class.getSimpleName();

    public Storage(Context context) {
        super(context, "cakes", null, 1);
    }

    @Inject

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (SQLException e){
            Log.d(TAG, e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addCake(Cake cake){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE, cake.getTitle());
        values.put(PREVIEW_DESCRIPTION, cake.getPreviewDescription());
        values.put(DETAIL_DESCRIPTION, cake.getDetailDescription());
        values.put(IMAGE_URL, cake.getImageURLl());

        try{
            db.insert(TABLE_NAME, null, values);
        }catch (SQLException e){
            Log.d(TAG, e.getMessage());
        }
        db.close();
    }

    public List<Cake> getSavedCakes(){
        List<Cake> cakeList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do{
                        Cake cake = new Cake();
                        cake.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                        cake.setImageURLl(cursor.getString(cursor.getColumnIndex(IMAGE_URL)));
                        cake.setPreviewDescription(cursor.getString(cursor.getColumnIndex(PREVIEW_DESCRIPTION)));
                        cake.setDetailDescription(cursor.getString(cursor.getColumnIndex(DETAIL_DESCRIPTION)));

                    }
                    while (cursor.moveToNext());
                }
            }
        }

        return cakeList;

    }

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String PREVIEW_DESCRIPTION = "previewDescription";
    private static final String DETAIL_DESCRIPTION = "detailDescription";
    private static final String IMAGE_URL = "imageURL";
    private static final String TABLE_NAME = "cakes";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS";

    private static final String SELECT_QUERY ="SELECT * FROM" ;



    private static final String CREATE_TABLE = "create table" + TABLE_NAME + "" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            TITLE + " TEXT NOT NULL, " +
            PREVIEW_DESCRIPTION + " TEXT NOT NULL, " +
            DETAIL_DESCRIPTION + " TEXT NOT NULL, " +
            IMAGE_URL + " TEXT NOT NULL";
}
