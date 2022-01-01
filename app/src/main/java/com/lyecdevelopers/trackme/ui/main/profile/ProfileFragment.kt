package com.lyecdevelopers.trackme.ui.main.profile

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.databinding.ProfileFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import javax.inject.Inject


class ProfileFragment : BaseFragment<ProfileFragmentBinding, ProfileViewModel>() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: ProfileFragmentBinding

    lateinit var profileViewModel: ProfileViewModel

    override fun getViewModel(): ProfileViewModel {

        profileViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[ProfileViewModel::class.java]
        return profileViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.profile_fragment
    }
}