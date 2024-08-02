package com.muratguzel.foodguide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muratguzel.foodguide.databinding.FoodRowBinding
import com.muratguzel.foodguide.model.Food
import com.muratguzel.foodguide.util.imageDownload
import com.muratguzel.foodguide.util.placeHolderCreate
import com.muratguzel.foodguide.view.FoodListFragmentDirections

class FoodAdapter(val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodWH>() {
    class FoodWH(val binding: FoodRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodWH {
        val recyclerRowBinding =
            FoodRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodWH(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateFoodList(newFoodList: List<Food>) {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FoodWH, position: Int) {
        holder.binding.foodName.text = foodList[position].foodName
        holder.binding.calorie.text = foodList[position].foodCalorie
        holder.itemView.setOnClickListener {
            val action =
                FoodListFragmentDirections.actionFoodListFragmentToFoodDetailsFragment(foodList[position].uuid)
            Navigation.findNavController(it).navigate(action)

        }
        holder.binding.foodImageView.imageDownload(
            foodList[position].foodImage,
            placeHolderCreate(holder.itemView.context)
        )
    }
}