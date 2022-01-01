package com.lyecdevelopers.trackme.ui.main

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.MainFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject


class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: MainFragmentBinding

    lateinit var mainViewModel: MainViewModel

    override fun getViewModel(): MainViewModel {
        mainViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[MainViewModel::class.java]
        return mainViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.main_fragment
    }
}