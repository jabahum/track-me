package com.lyecdevelopers.trackme.ui.main.home

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.HomeFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject


class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: HomeFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    override fun getViewModel(): HomeViewModel {
        homeViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.home_fragment
    }

}