package com.example.basket.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basket.Dao.PartidoDAO
import com.example.basket.Repository.Repository


@Database(entities = [Repository::class], version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase() {

    abstract fun PartidoDAO(): PartidoDAO
    companion object{
        @Volatile
        private var INSTANCE:RoomDB?=null

        fun getInstance(
            context: Context
        ):RoomDB{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance= Room
                    .databaseBuilder(context, RoomDB::class.java, "partido_DB")
                    .build()
                INSTANCE=instance
                return instance
            }

        }

    }
}