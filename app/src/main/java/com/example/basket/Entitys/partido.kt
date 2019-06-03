package com.example.basket.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Partido")
class  Partido (
    @ColumnInfo(name= "NombrePartido")
    val NombrePartido: String,
    @ColumnInfo(name= "Jugador1")
    val Jugador1: String,
    @ColumnInfo(name = "Puntaje1")
    val Puntaje1: Int,
    @ColumnInfo(name = "Jugador2")
    val Jugador2: String,
    @ColumnInfo(name = "Puntaje2")
    val Puntaje2: Int,
    @ColumnInfo(name = "Ganador")
    val Ganador: String
){
    @PrimaryKey(autoGenerate = true)
    var id_Partido:Long=0
}