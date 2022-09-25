package com.terriconvalleyhackathon.wooppaytips.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.terriconvalleyhackathon.wooppaytips.R
import com.terriconvalleyhackathon.wooppaytips.data.model.AuthBody
import com.terriconvalleyhackathon.wooppaytips.data.model.BalanceResponseBody
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentAuthBinding
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AuthFragmentContract
import com.terriconvalleyhackathon.wooppaytips.presentation.presenter.AuthFragmentPresenter

class AuthFragment : Fragment(), AuthFragmentContract.View {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: AuthFragmentContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializePresenter()
        initializeListeners()
    }

    override fun initializePresenter() {
        presenter = AuthFragmentPresenter(requireContext())
        presenter.attach(this)
    }

    override fun onSuccess() {
//        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(binding.root).navigate(R.id.action_authFragment_to_accountFragment)
    }

//    override fun balanceOnSuccess(balance: BalanceResponseBody) {
//        Toast.makeText(context, "Balance Success", Toast.LENGTH_SHORT).show()
////        binding.balanceText.text = "${balance.getAccBase()}; ${balance.getBlocked()}; ${balance.getActive()}; ${balance.getAccCommission()}"
//    }
//
//    override fun balanceOnError() {
//        Toast.makeText(context, "Balance Error", Toast.LENGTH_SHORT).show()
//    }

    override fun onError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun initializeListeners() {
        binding.logInButton.setOnClickListener {
            val login = binding.phoneNumberTextField.editText!!.text.toString()
            val password = binding.passwordTextField.editText!!.text.toString()
            val authBody = AuthBody(login, password)
            presenter.onButtonClickListener(authBody)
        }
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onStop()
        _binding = null
    }
}