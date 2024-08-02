package com.muratguzel.foodguide.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.muratguzel.foodguide.model.Food

@Dao
interface FoodDao {

    @Insert
    suspend fun insertAll(vararg food: Food): List<Long>

    //It returns the id of the added foods as long.
    @Query("SELECT * FROM food")
    suspend fun getAllFood(): List<Food>

    @Query("SELECT * FROM food WHERE uuid=:foodId")
    suspend fun getFood(foodId: Int): Food

    @Query("DELETE FROM food")
    suspend fun deleteAllFood()
}