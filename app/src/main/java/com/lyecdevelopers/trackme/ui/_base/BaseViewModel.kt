package com.lyecdevelopers.trackme.ui._base

import androidx.lifecycle.ViewModel

/**
 * created by jaba
 */
abstract class BaseViewModel : ViewModel() {
    private val TAG = "BaseViewModel"

    open fun BaseViewModel() {}
}