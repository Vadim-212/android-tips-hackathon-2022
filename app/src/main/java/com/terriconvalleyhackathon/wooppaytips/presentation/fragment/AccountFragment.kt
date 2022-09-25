package com.terriconvalleyhackathon.wooppaytips.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.terriconvalleyhackathon.wooppaytips.R
import com.terriconvalleyhackathon.wooppaytips.data.model.BalanceResponseBody
import com.terriconvalleyhackathon.wooppaytips.data.utils.AuthorizationInstance
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentAccountBinding
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentAuthBinding
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AccountFragmentContract
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.AuthFragmentContract
import com.terriconvalleyhackathon.wooppaytips.presentation.presenter.AccountFragmentPresenter
import com.terriconvalleyhackathon.wooppaytips.presentation.presenter.AuthFragmentPresenter


class AccountFragment : Fragment(), AccountFragmentContract.View {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: AccountFragmentContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializePresenter()
        initializeViews()
        initializeListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onStop()
        _binding = null
    }

    override fun initializePresenter() {
        presenter = AccountFragmentPresenter(requireContext())
        presenter.attach(this)
    }

    override fun balanceOnSuccess(balance: BalanceResponseBody) {
        binding.donutSum.text = getString(R.string.fragment_account_balance_text, balance.getActive().toString())
    }

    override fun balanceOnError() {
        Toast.makeText(context, "Ошибка получения баланса", Toast.LENGTH_SHORT).show()
    }

    override fun initializeViews() {
        binding.userPhoneNumber.text = "+${AuthorizationInstance.getInstance().getAuthResponseBody()!!.getLogin().substring(2)}"
        binding.donutSum.text = getString(R.string.fragment_account_balance_text, "...")
        presenter.onButtonClickListener()
    }

    override fun initializeListeners() {
        binding.myQrCard.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_accountFragment_to_myQrFragment)
        }

        binding.historyCard.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_accountFragment_to_historyFragment)
        }
    }
}