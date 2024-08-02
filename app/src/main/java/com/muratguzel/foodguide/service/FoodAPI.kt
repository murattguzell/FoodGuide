package com.muratguzel.foodguide.service

import com.muratguzel.foodguide.model.Food
import retrofit2.http.GET

interface FoodAPI {
    //GET, POST

//https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

// BASE_URL -> https://raw.githubusercontent.com/
//ENDPOINT -> atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    suspend fun getFood(): List<Food>
}