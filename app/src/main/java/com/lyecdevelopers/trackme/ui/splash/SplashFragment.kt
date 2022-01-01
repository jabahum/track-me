package com.lyecdevelopers.trackme.ui.splash

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.trackme.BuildConfig
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.ViewModelProviderFactory
import com.lyecdevelopers.trackme.data.local.pref.PreferenceManager
import com.lyecdevelopers.trackme.databinding.SplashFragmentBinding
import com.lyecdevelopers.trackme.ui._base.BaseFragment
import com.lyecdevelopers.trackme.ui.account.AccountActivity
import com.lyecdevelopers.trackme.ui.main.MainActivity
import javax.inject.Inject


class SplashFragment : BaseFragment<SplashFragmentBinding, SplashViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var preferenceManager: PreferenceManager

    lateinit var binding: SplashFragmentBinding

    lateinit var splashViewModel: SplashViewModel

    private var handler: Handler = Handler()

    override fun getViewModel(): SplashViewModel {
        splashViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[SplashViewModel::class.java]
        return splashViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.splash_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {

        // set version name
        binding.versionName = "v" + BuildConfig.VERSION_NAME

        if (!preferenceManager.signedIn) {
            // handle loading
            handler.postDelayed({ newActivity(AccountActivity::class.java) }, 2000)
        } else {
            if (!TextUtils.isEmpty(preferenceManager.accessToken)) {
                newActivity(MainActivity::class.java)
            } else {
                newActivity(AccountActivity::class.java)
            }
        }

    }
}