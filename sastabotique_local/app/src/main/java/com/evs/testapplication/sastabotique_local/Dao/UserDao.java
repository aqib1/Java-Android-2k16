package com.evs.testapplication.sastabotique_local.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.evs.testapplication.sastabotique_local.entities.UserEntity;

import java.util.List;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

@Dao
public interface UserDao{

    @Query("SELECT * FROM UserDetails")
    List<UserEntity> getAllUser();

    @Query("SELECT * FROM UserDetails WHERE USER_NAME LIKE :userName")
    List<UserEntity> getByUserName(String userName);

    @Insert
    void insertAll(UserEntity ...userEntity);
}
