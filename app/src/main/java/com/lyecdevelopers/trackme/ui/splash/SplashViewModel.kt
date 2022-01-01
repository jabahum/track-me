package com.lyecdevelopers.trackme.ui.splash

import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.trackme.ui._base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()