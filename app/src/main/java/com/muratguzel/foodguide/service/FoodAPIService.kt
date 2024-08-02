package com.muratguzel.foodguide.service

import com.muratguzel.foodguide.model.Food
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodAPIService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FoodAPI::class.java)


    suspend fun getData(): List<Food> {
        return retrofit.getFood()
    }
}