package com.terriconvalleyhackathon.wooppaytips.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.terriconvalleyhackathon.wooppaytips.R
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentPasswordSettingBinding
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentRegistrationCodeConfirmationBinding

class RegistrationCodeConfirmationFragment : Fragment() {
    private var _binding: FragmentRegistrationCodeConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationCodeConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}