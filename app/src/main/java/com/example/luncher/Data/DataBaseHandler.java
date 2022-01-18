package com.example.luncher.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.luncher.R;
import com.example.luncher.Util.Util;
import com.example.luncher.model.Content;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {


    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME,null, Util.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTENT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_TOPIC + " TEXT" +")";

        db.execSQL(CREATE_CONTENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE = String.valueOf(R.string.drop_table);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        //crete table again
        onCreate(db);

    }

    public void addcontent(Content content){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, content.getName());
        values.put(Util.KEY_TOPIC, content.getTopic());
        db.insert(Util.TABLE_NAME, null, values);

        db.close();
    }

    public Content getcontent(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_TOPIC},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor!=null){
            cursor.moveToFirst();
        }

        Content content = new Content();
        content.setID(Integer.valueOf(cursor.getString(0)));
        content.setName(String.valueOf(cursor.getString(1)));
        content.setTopic(String.valueOf(cursor.getString(2)));

        return content;
    }

    //get all content
    public List<Content> getAllContenet(){
        List<Content> ContentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        //select all contents
        String selectAll = "SELECT * FROM " +Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        //loop through our data
        if (cursor.moveToFirst()){
            do {
                Content content = new Content();
                content.setID(Integer.parseInt(cursor.getString(0)));
                content.setName(cursor.getString(1));
                content.setTopic(cursor.getString(2));

                //add contact to list
                ContentList.add(content);
            }while (cursor.moveToNext());
        }

        return ContentList;
    }

    //update content
    public int UpdateContent(Content content){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, content.getName());
        values.put(Util.KEY_TOPIC, content.getTopic());

        //update the row
        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[]{String.valueOf(content.getID())});

    }

    //delete content
    public void deleteContent(Content content){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[]{String.valueOf(content.getID())});
        db.close();
    }

    //get contents count
    public int getCount(){
        String CountQuery = "SELECT * FROM " + Util.TABLE_NAME;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(CountQuery, null);
        return cursor.getCount();
    }


}
