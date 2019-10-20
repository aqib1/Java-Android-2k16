package com.evs.testapplication.sastabotique_local.Dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.evs.testapplication.sastabotique_local.entities.EmployeeEntity;

import java.util.List;

/**
 * Created by AQIB JAVED on 11/17/2018.
 */

public interface EmployeeDao {
    @Query("SELECT * FROM Employees")
    List<EmployeeEntity> getAllEmployees();

    @Query("SELECT * FROM Employees WHERE EMPLOYEE_NAME LIKE :userName")
    List<EmployeeEntity> getByUsername(String userName);

    @Insert
    void insertAll(EmployeeEntity ...employeeEntities);
}
