package com.lyecdevelopers.trackme.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.lyecdevelopers.trackme.R
import com.lyecdevelopers.trackme.databinding.ProgressBarBinding

/**
 * created by jaba
 */
class CustomLoader(private var message: String) : DialogFragment() {
    var binding: ProgressBarBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.progress_bar, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.message = message
    }

    fun setMessage(message: String) {
        this.message = message
        binding?.message = message
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }
}