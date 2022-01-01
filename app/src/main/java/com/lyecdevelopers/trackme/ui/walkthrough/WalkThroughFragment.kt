package com.lyecdevelopers.trackme.ui.walkthrough

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.WalkthroughFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject

class WalkThroughFragment : BaseFragment<WalkthroughFragmentBinding, WalkThroughViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: WalkthroughFragmentBinding

    lateinit var walkThroughViewModel: WalkThroughViewModel

    override fun getViewModel(): WalkThroughViewModel {
        walkThroughViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[WalkThroughViewModel::class.java]
        return walkThroughViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.walkthrough_fragment
    }
}