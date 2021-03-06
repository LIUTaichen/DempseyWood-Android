package com.dempseywood.operatordatacollector.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dempseywood.operatordatacollector.service.RequestService;

/**
 * Created by musing on 05/09/2017.
 */

public class DB {
    private static AppDatabase instance;
    private Context context;
    public static AppDatabase getInstance(){
        if(instance == null){
            throw new IllegalStateException("init() must be called before calling getInstance()");
        }
        return instance;
    }

    public static AppDatabase getInstance(Context context){
        if(instance == null) {
            synchronized(AppDatabase.class) {
                if(instance == null) {
                    init(context);
                }
            }
        }
        return instance;
    }

    public static void init(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "dw-database").fallbackToDestructiveMigration().build();
        }
    }




}
