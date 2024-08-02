package com.muratguzel.foodguide.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratguzel.foodguide.adapter.FoodAdapter
import com.muratguzel.foodguide.databinding.FragmentFoodListBinding
import com.muratguzel.foodguide.viewmodel.FoodListViewModel

class FoodListFragment : Fragment() {
    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FoodListViewModel
    private var foodAdapter = FoodAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]
        viewModel.refreshData()

        binding.foodRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.foodRecyclerView.adapter = foodAdapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.foodRecyclerView.visibility = View.GONE
            binding.foodErrorMessage.visibility = View.GONE
            binding.foodLoading.visibility = View.VISIBLE
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.refreshDataFromInternet()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.foods.observe(viewLifecycleOwner) { foodsList ->

            foodAdapter.updateFoodList(foodsList)
            binding.foodRecyclerView.visibility = View.VISIBLE

        }
        viewModel.foodErrorMessage.observe(viewLifecycleOwner) { error ->
            if (error) {
                binding.foodErrorMessage.visibility = View.VISIBLE
                binding.foodRecyclerView.visibility = View.GONE
            } else {
                binding.foodErrorMessage.visibility = View.GONE
            }
        }
        viewModel.foodLoading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.foodErrorMessage.visibility = View.GONE
                binding.foodRecyclerView.visibility = View.GONE
                binding.foodLoading.visibility = View.VISIBLE
            } else {
                binding.foodLoading.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}