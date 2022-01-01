package com.lyecdevelopers.trackme.ui.walkthrough

import com.lyecdevelopers.trackme.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.trackme.ui._base.BaseViewModel
import javax.inject.Inject

class WalkThroughViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider
) :
    BaseViewModel()