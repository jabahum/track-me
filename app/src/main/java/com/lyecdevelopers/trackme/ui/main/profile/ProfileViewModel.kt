package com.lyecdevelopers.trackme.ui.main.profile

import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.trackme.data.remote.endpoints.main.MainApi
import com.lyecdevelopers.trackme.ui._base.BaseViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val mainApi: MainApi,
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()