package com.example.moneymanager.Dummy.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.cert.CertPathValidatorException


@Entity(tableName = "money")
class Money(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "reason")
    var reason: String,
    @ColumnInfo(name = "amount")
    var  amount : String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var  id: Int?= null
}