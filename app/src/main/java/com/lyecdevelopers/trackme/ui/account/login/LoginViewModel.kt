package com.lyecdevelopers.trackme.ui.account.login

import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.trackme.data.remote.login.LoginApi
import com.lyecdevelopers.trackme.ui._base.BaseViewModel
import javax.inject.Inject


class LoginViewModel @Inject constructor(
    private val loginApi: LoginApi,
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()