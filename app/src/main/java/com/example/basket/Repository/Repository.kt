package com.example.basket.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basket.Dao.PartidoDAO
import com.example.basket.Entitys.Partido

class Repository (private val PartidoDAO : PartidoDAO){

    val allPartidos: LiveData<List<Partido>> = PartidoDAO.getAllPartidos()


    @WorkerThread
    suspend fun insert(partido: Partido) {
        PartidoDAO.insert(partido)
    }
    @WorkerThread
    suspend fun deletePartidos(){
        PartidoDAO.DeletePartidos()
    }

}