package com.example.ecommerce.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.databinding.HomeFragmentBinding
import com.example.ecommerce.presentation.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        val adapter = ProductAdapter(requireContext())
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rv.adapter = adapter
        viewModel.list.observe(viewLifecycleOwner) {

            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }
    }
}


