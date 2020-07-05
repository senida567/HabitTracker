package com.example.projekat.entity

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "vremenske",
    foreignKeys = arrayOf(
        ForeignKey(entity = Kategorije::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id_kategorije"),
            onDelete = ForeignKey.CASCADE
        )
    ))
class Vremenske (

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "naziv") val naziv : String,

            //mozda neki drugi tip?
    @ColumnInfo(name = "pocetak") val pocetak : String,

    @Nullable
    @ColumnInfo(name = "kraj") val kraj : String,

    @ColumnInfo(name = "id_kategorije", index = true) val id_kategorije : Int
)