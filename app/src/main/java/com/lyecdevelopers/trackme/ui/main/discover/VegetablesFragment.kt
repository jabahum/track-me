package com.lyecdevelopers.trackme.ui.main.discover

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.VegetablesFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject


class VegetablesFragment : BaseFragment<VegetablesFragmentBinding, VegetablesViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: VegetablesFragmentBinding

    lateinit var vegetablesViewModel: VegetablesViewModel

    override fun getLayoutId(): Int {
        return R.layout.vegetables_fragment
    }

    override fun getViewModel(): VegetablesViewModel {
        vegetablesViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[VegetablesViewModel::class.java]
        return vegetablesViewModel
    }
}