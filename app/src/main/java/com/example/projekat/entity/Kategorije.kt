package com.example.projekat.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kategorije")
class Kategorije (

    @PrimaryKey(autoGenerate = true) val id : Int = 0,

    @ColumnInfo(name = "naziv") val naziv : String,

    //1=vremenske;
    //2=inkrementalne;
    //3=kolicinske
    @ColumnInfo(name = "tip") val tip : Int,

    @ColumnInfo(name = "osobina") val osobina : Boolean

)
