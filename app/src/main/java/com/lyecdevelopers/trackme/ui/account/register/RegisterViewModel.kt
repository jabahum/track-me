package com.lyecdevelopers.trackme.ui.account.register

import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.trackme.data.remote.login.LoginApi
import com.lyecdevelopers.trackme.ui._base.BaseViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider,
    private val loginApi: LoginApi
) : BaseViewModel()