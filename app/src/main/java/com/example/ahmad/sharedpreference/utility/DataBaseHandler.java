package com.example.ahmad.sharedpreference.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ahmad.sharedpreference.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 20/07/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "sqlite";
    private static final String TABLE_USER = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_NO_HP = "no_hp";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "pass";
    private static SQLiteDatabase sqLiteDatabase;
    private static DataBaseHandler dataBaseHandler;
    private final String TAG = DataBaseHandler.class.getSimpleName();

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static void init(Context context) {
        dataBaseHandler = new DataBaseHandler(context);
        sqLiteDatabase = dataBaseHandler.getWritableDatabase();
    }

    public static synchronized DataBaseHandler getInstance() {
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASS + " TEXT,"
                + KEY_NO_HP + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_ADDRESS, user.getAddress());
        values.put(KEY_NO_HP, user.getNoHp());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PASS, user.getPass());

        sqLiteDatabase.insert(TABLE_USER, null, values);
        Log.d(TAG, "insert table user success !");
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String selectAllUser = "SELECT * FROM " + TABLE_USER + " ORDER BY " + KEY_ID + " DESC ";

        Cursor cursor = sqLiteDatabase.rawQuery(selectAllUser, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setAddress(cursor.getString(2));
                user.setNoHp(cursor.getString(3));
                user.setEmail(cursor.getString(4));
                user.setPass(cursor.getString(5));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }
}

