package com.muratguzel.foodguide.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.muratguzel.foodguide.model.Food
import com.muratguzel.foodguide.roomdb.FoodDatabase
import com.muratguzel.foodguide.service.FoodAPIService
import com.muratguzel.foodguide.util.PrivateSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.whileSelect
import kotlinx.coroutines.withContext

class FoodListViewModel(application: Application) : AndroidViewModel(application) {

    val foods = MutableLiveData<List<Food>>()
    val foodErrorMessage = MutableLiveData<Boolean>()
    val foodLoading = MutableLiveData<Boolean>()

    private val foodApiService = FoodAPIService()
    private val privatessharedpreferences = PrivateSharedPreferences(getApplication())
    private val updateTime = 10 * 60 * 1000 * 1000 * 1000L

    fun refreshData() {
        val saveTime = privatessharedpreferences.getTime()
        if (saveTime != null && saveTime != 0L && System.nanoTime() - saveTime < updateTime) {
            getDataFromRoom()
        } else {
            getDataFromInternet()
        }
    }

    fun refreshDataFromInternet() {
        getDataFromInternet()
    }

    private fun getDataFromInternet() {
        foodLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val foodList = foodApiService.getData()
                withContext(Dispatchers.Main) {
                    showFoods(foodList)
                    saveToRoom(foodList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    foodErrorMessage.value = true
                    foodLoading.value = false
                }
            }
        }
    }

    private fun getDataFromRoom() {
        foodLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val foodList = FoodDatabase(getApplication()).foodDao().getAllFood()
                withContext(Dispatchers.Main) {
                    showFoods(foodList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    foodErrorMessage.value = true
                    foodLoading.value = false
                }
            }
        }
    }

    private fun showFoods(foodList: List<Food>) {
        foods.value = foodList
        foodErrorMessage.value = false
        foodLoading.value = false
    }

    private fun saveToRoom(foodList: List<Food>) {
        viewModelScope.launch {

            val dao = FoodDatabase(getApplication()).foodDao()
            dao.deleteAllFood()

            val uuidList = dao.insertAll(*foodList.toTypedArray())

            var i = 0
            while (i < foodList.size) {
                foodList[i].uuid = uuidList[i].toInt()
                i = i + 1
            }
            showFoods(foodList)
        }
        privatessharedpreferences.saveTime(System.nanoTime())
    }


}