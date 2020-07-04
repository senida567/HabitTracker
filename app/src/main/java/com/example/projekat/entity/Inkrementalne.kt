package com.example.projekat.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "inkrementalne",
        foreignKeys = arrayOf(
            ForeignKey(entity = MjerneJedinice::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("id_mjerna_jedinica"),
                onDelete = ForeignKey.CASCADE
            ),
            ForeignKey(entity = Kategorije::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("id_kategorije"),
                onDelete = ForeignKey.CASCADE
            )
        ))
class Inkrementalne (

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "broj") val broj : Int,

    @ColumnInfo(name = "id_mjerna_jedinica") val id_mjerna_jedinica : Int,

    @ColumnInfo(name = "id_kategorije") val id_kategorije : Int,

    //za koliko se povacaje
    @ColumnInfo(name = "inkrement") val inkrement : Int

)