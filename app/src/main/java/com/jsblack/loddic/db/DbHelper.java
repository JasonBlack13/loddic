package com.jsblack.loddic.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jsblack.loddic.item.Item;
import com.jsblack.loddic.item.ItemAcquire;
import com.jsblack.loddic.item.ItemObject;
import com.jsblack.loddic.item.ItemUsage;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.name;

/**
 * Created by jspark on 2017. 6. 15..
 */

public class DbHelper extends SQLiteOpenHelper {

    private final String LOG_TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "onCreate()");

        // Item.
        db.execSQL("CREATE TABLE IF NOT EXISTS ITEM ( "
                +"id INTEGER PRIMARY KEY,"
                +"name TEXT NOT NULL,"
                +"grade INTEGER NOT NULL,"
                +"type INTEGER NOT NULL,"
                +"subtype INTEGER NOT NULL,"
                +"isauction INTEGER DEFAULT 0,"
                +"option TEXT,"
                +"usage TEXT,"
                +"acquire TEXT"
                +");");

        // hero

        // monster

        // dungeon

        //
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addItem(ItemObject item){
        Log.i(LOG_TAG, "addItem() : "+item.toString());

        SQLiteDatabase db = getWritableDatabase();

        // id는 자동으로 증가함. 근데 id로 썸네일 이미지 가져올거기 때문에 순서대로 들어가는게 매우 중요함.

        String query = "INSERT INTO ITEM ( id, name, grade, type, subtype, isauction, option, usage, acquire ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? );";

        int id = item.getId();
        String name = item.getName();
        int grade = item.getGrade();
        Item.Type type = item.getType();
        int subtype = item.getSubType();
        boolean isauction = item.isAuction();
        String option = item.getOption();
        String usage = item.getUsage().toString();
        String acquire = item.getAcquire().toString();

        db.execSQL(query, new Object[]{id, name, grade, type, subtype, isauction?1:0, option, usage, acquire});

    }


    public ItemObject getItem(int id){
        Log.i(LOG_TAG, "getItem id="+id);

        SQLiteDatabase db = getReadableDatabase();

//        Cursor cursor = db.rawQuery("SELECT * FROM ITEM WHERE _id = "+id+";");

        return null;

    }

    public ArrayList<ItemObject> getAllItems(){
        Log.i(LOG_TAG, "getAllItems()");

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM ITEM", null);

        ArrayList<ItemObject> list = new ArrayList<>();

        while (cursor.moveToNext()){
            ItemObject obj = new ItemObject();
            obj.setId(cursor.getInt(0));
            obj.setName(cursor.getString(1));
            obj.setGrade(cursor.getInt(2));
            obj.setType(cursor.getInt(3));
            obj.setSubType(cursor.getInt(4));
            obj.setAuction(cursor.getInt(5)==0 ? false : true);
            obj.setOption(cursor.getString(6));
            obj.setUsage(new ItemUsage(cursor.getString(7)));
            obj.setAcquire(new ItemAcquire(cursor.getString(8)));
        }

        if(list.size() == 0){
            return null;
        }else{
            return list;
        }
    };
}
