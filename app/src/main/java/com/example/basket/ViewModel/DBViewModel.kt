package com.example.basket.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basket.Entitys.Partido
import com.example.basket.Repository.Repository
import com.example.basket.Room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DBViewModel(app: Application): AndroidViewModel(app){

    private val repository: Repository
    val allPartidos : LiveData<List<Partido>>


    //primer codigo que se ejecute cuando se llame
    init{
        val repoDao = RoomDB.getInstance(app).PartidoDAO()
        repository= Repository(repoDao)
        allPartidos = repository.allPartidos
    }


    fun insertPartido(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)

    }
    fun deletePartidos() = viewModelScope.launch(Dispatchers.IO){
        repository.deletePartidos()
    }

}