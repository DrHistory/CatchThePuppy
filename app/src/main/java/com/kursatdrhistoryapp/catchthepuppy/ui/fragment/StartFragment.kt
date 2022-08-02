package com.kursatdrhistoryapp.catchthepuppy.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kursatdrhistoryapp.catchthepuppy.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.easymodeBtn.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToEasyModeFragment()
            Navigation.findNavController(it).navigate(action)
        }
        binding.hardmodeBtn.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToHardModeFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}