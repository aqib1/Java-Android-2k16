package com.evs.testapplication.sastabotique_local.AbstractRoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.evs.testapplication.sastabotique_local.Dao.EmployeeDao;
import com.evs.testapplication.sastabotique_local.Dao.LoginEntity;
import com.evs.testapplication.sastabotique_local.Dao.UserDao;
import com.evs.testapplication.sastabotique_local.Dao.UserEntityTable;
import com.evs.testapplication.sastabotique_local.entities.EmployeeEntity;
import com.evs.testapplication.sastabotique_local.entities.UserEntity;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

@Database(entities = {UserEntity.class, EmployeeEntity.class,
        UserEntityTable.class, LoginEntity.class},version = 1)
public abstract class AbstractDB extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract EmployeeDao employeeDao();

    private static AbstractDB abstractDB = null;

    public static AbstractDB getAbstractDB(Context context){
        if(abstractDB == null){
            synchronized (AbstractDB.class){
                if (abstractDB == null){
                    abstractDB = Room.databaseBuilder(context,AbstractDB.class,"STUDENTS.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return abstractDB;
    }
    public static void destroyInstance() {
        abstractDB = null;
    }
}
