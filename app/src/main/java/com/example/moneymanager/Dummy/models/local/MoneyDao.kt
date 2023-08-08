package com.example.moneymanager.Dummy.models.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(monet:Money)

    @Query("select * from money")
    fun getTask():LiveData<List<Money>>

    @Update
    fun updateTask(money: Money)

    @Delete
    fun deleteTask(money: Money)



}