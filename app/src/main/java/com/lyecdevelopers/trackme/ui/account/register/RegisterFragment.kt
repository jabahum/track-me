package com.lyecdevelopers.trackme.ui.account.register

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.RegisterFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject


class RegisterFragment : BaseFragment<RegisterFragmentBinding, RegisterViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: RegisterFragmentBinding

    lateinit var registerViewModel: RegisterViewModel

    override fun getViewModel(): RegisterViewModel {
        registerViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[RegisterViewModel::class.java]
        return registerViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.register_fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }
    private fun  init(){
        binding.btnSignUp.setOnClickListener {

        }

        binding.txtHaveAccount.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}