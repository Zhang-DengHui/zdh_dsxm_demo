package com.example.zdh_dsxm_demo.apps;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.zdh_dsxm_demo.dao.DaoMaster;
import com.example.zdh_dsxm_demo.db.DaoSession;
import com.example.zdh_dsxm_demo.utils.MyDaoMaster;


public class MyApp extends Application {

    private static String DB_NAME = "1901A";


    public static MyApp myApp;

    private SQLiteDatabase sqLiteDatabase;
    private MyDaoMaster myDaoMaster;
    private DaoMaster daoMaster;
    private com.example.zdh_dsxm_demo.db.DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        initDB();


    }

    private void initDB(){
        myDaoMaster = new MyDaoMaster(this,DB_NAME);
        sqLiteDatabase = myDaoMaster.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }


}
