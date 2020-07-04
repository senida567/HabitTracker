package com.example.projekat.entity

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
            //mozda neki drugi tip?
    @ColumnInfo(name = "pocetak") val pocetak : Time,

    @ColumnInfo(name = "kraj") val kraj : Time,

    @ColumnInfo(name = "id_kategorije") val id_kategorije : Int
)