package com.example.basket.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basket.Entitys.Partido

@Dao
interface PartidoDAO {


    @Query(" DELETE FROM Partido")
    suspend fun DeletePartidos()

    @Query("SELECT * FROM Partido order by NombrePartido ASC")
    fun getAllPartidos() : LiveData<List<Partido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido : Partido)
}