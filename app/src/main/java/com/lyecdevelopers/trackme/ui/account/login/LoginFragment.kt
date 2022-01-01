package com.lyecdevelopers.trackme.ui.account.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import com.lyecdevelopers.trackme.ui.main.MainActivity
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.LoginFragmentBinding
import javax.inject.Inject


class LoginFragment : BaseFragment<LoginFragmentBinding, LoginViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: LoginFragmentBinding

    lateinit var loginViewModel: LoginViewModel

    override fun getViewModel(): LoginViewModel {
        loginViewModel =
            ViewModelProvider(getBaseActivity(), providerFactory)[LoginViewModel::class.java]
        return loginViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.login_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {
        binding.apply {
            btnLogin.setOnClickListener {
                newActivity(MainActivity::class.java)
            }
            txtDontHaveAccount.setOnClickListener {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }

    }
}