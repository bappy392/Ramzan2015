package com.ussoftwareltd.ramzan2015;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Bappy on 6/2/2015.
 */
public class SI_DB extends SQLiteOpenHelper {
    private static SI_DB sidb;

    public static String DB_NAME="ramjandb";

    public static String DB_PATH;
    private SQLiteDatabase database;
    private Context context;

    public static final String RAMJAN_TABLE="ramjantb";
    public static final String ID_FIELD="_id";
    public static final String DATE_FIELD="date";
    public static final String DAY_FIELD="day";
    public static final String SHER_FIELD="sher";
    public static final String IFTAR_FIELD="iftar";
    public static final String COUNTRY_FIELD="country";


    public SI_DB(Context context) {
        super(context, DB_NAME, null, 1);
        this.context=context;

        //database path/data/data/pkg-name/databases/
        String packageName=context.getPackageName();
        DB_PATH="/data/data/"+packageName+"/databases/";
        this.database=openDatabase();
    }

    public static SI_DB getInstance(Context context){
        if(sidb==null){
            sidb=new SI_DB(context);
        }
        return sidb;
    }
    public SQLiteDatabase getDatabase(){
        return this.database;
    }

    public SQLiteDatabase openDatabase(){
        String path=DB_PATH+DB_NAME;
        if(database==null){
            createDatabase();
            database=SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }

        return database;
    }
    public void createDatabase(){
        boolean dbExites=checkDB();
        if(!dbExites){
            this.getReadableDatabase();
            Log.e(getClass().getName(),
                    "Database doesn't exist. Copying database from assets...");
            copyDatabase();
        }else {
            Log.e(getClass().getName(), "Database already exists");
        }
    }
    private void copyDatabase(){
        try {
            InputStream dbInputStream=context.getAssets().open(DB_NAME);
            String path=DB_PATH+DB_NAME;
            OutputStream dbOutputStream=new FileOutputStream(path);
            byte[] buffer=new byte[4096];
            int readCount=0;
            while ((readCount=dbInputStream.read(buffer))>0){
                dbOutputStream.write(buffer, 0, readCount);
            }
            dbInputStream.close();
            dbOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkDB(){
        String path=DB_PATH+DB_NAME;
        File file=new File(path);
        if(file.exists()){
            Log.e(getClass().getName(), "Database already exists");
            return true;
        }
        Log.e(getClass().getName(), "Database does not exists");
        return false;
    }
    public synchronized void close(){
        if(this.database!=null){
            this.database.close();
        }
    }

    public ArrayList<SI_Times> getAllTimes(){
        ArrayList<SI_Times> allTimes=new ArrayList<SI_Times>();
        // SELECT * FROM EMPLOYEE;
        Cursor cursor=this.database.query(RAMJAN_TABLE,null,null,null,null,null,null);
       // Cursor cursor = db.rawQuery("SELECT * FROM EMPLOYEE", null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for (int i=0; i<cursor.getCount();i++){
                int id=cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String date= cursor.getString(cursor.getColumnIndex(DATE_FIELD));
                String day= cursor.getString(cursor.getColumnIndex(DAY_FIELD));
                String sher= cursor.getString(cursor.getColumnIndex(SHER_FIELD));
                String iftar= cursor.getString(cursor.getColumnIndex(IFTAR_FIELD));
                String country= cursor.getString(cursor.getColumnIndex(COUNTRY_FIELD));
                SI_Times s=new SI_Times(id,date,day,sher,country,iftar);
                allTimes.add(s);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return allTimes;
    }

//query
public ArrayList<SI_Times> searchRamjanTimes(String countries){
    ArrayList<SI_Times> allTimes=new ArrayList<SI_Times>();
    database=this.getReadableDatabase();
    Cursor cursor = this.database.query(RAMJAN_TABLE, null, COUNTRY_FIELD + " LIKE '%" + countries + "%'", null, null,
            null, null);
    if(cursor!=null && cursor.getCount()>0){
        cursor.moveToFirst();
        for (int i=0;i<cursor.getCount();i++){
            int id=cursor.getInt(cursor.getColumnIndex(ID_FIELD));
            String date= cursor.getString(cursor.getColumnIndex(DATE_FIELD));
            String day= cursor.getString(cursor.getColumnIndex(DAY_FIELD));
            String sher= cursor.getString(cursor.getColumnIndex(SHER_FIELD));
            String iftar= cursor.getString(cursor.getColumnIndex(IFTAR_FIELD));
            String country= cursor.getString(cursor.getColumnIndex(COUNTRY_FIELD));
            SI_Times s=new SI_Times(id,date,day,sher,country,iftar);
            allTimes.add(s);
            cursor.moveToNext();
        }
    }

    cursor.close();
    return allTimes;
}



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
