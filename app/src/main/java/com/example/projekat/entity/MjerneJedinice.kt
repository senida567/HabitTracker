package com.example.projekat.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mjerne_jedinice")
class MjerneJedinice (

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "naziv") val naziv : String
)