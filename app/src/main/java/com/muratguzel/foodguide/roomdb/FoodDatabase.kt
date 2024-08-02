package com.muratguzel.foodguide.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muratguzel.foodguide.model.Food


@Database(entities = [Food::class], version = 1)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var instance: FoodDatabase? = null

        private val lock = Any()

        operator fun invoke(contex: Context) = instance ?: synchronized(lock) {
            instance ?: databaseCreate(contex).also {
                instance = it
            }
        }

        private fun databaseCreate(contex: Context) = Room.databaseBuilder(
            contex.applicationContext,
            FoodDatabase::class.java,
            "FoodDatabase"
        ).build()
    }

}

