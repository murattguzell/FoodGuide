package com.muratguzel.foodguide.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.muratguzel.foodguide.model.Food
import com.muratguzel.foodguide.roomdb.FoodDatabase
import kotlinx.coroutines.launch

class FoodDetailsViewModel(application: Application) : AndroidViewModel(application) {
    val foodliveData = MutableLiveData<Food>()

    fun getRoomData(uuid: Int) {
        viewModelScope.launch {
            val dao = FoodDatabase(getApplication()).foodDao()
            val food = dao.getFood(uuid)
            foodliveData.value = food
        }
    }
}