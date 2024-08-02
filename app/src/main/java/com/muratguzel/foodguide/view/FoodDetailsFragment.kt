package com.muratguzel.foodguide.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.muratguzel.foodguide.databinding.FragmentFoodDetailsBinding
import com.muratguzel.foodguide.util.imageDownload
import com.muratguzel.foodguide.util.placeHolderCreate
import com.muratguzel.foodguide.viewmodel.FoodDetailsViewModel

class FoodDetailsFragment : Fragment() {
    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FoodDetailsViewModel
    var foodId = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FoodDetailsViewModel::class.java]
        arguments?.let {
            foodId = FoodDetailsFragmentArgs.fromBundle(it).foodId
        }
        viewModel.getRoomData(foodId)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.foodliveData.observe(viewLifecycleOwner) { food ->
            binding.foodNameText.text = food.foodName
            binding.foodCalorieText.text = food.foodCalorie
            binding.foodCarbohydrate.text = food.foodCarbohydrate
            binding.foodFat.text = food.foodFat
            binding.foodProtein.text = food.foodProtein
            binding.foodImage.imageDownload(food.foodImage, placeHolderCreate(requireContext()))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}