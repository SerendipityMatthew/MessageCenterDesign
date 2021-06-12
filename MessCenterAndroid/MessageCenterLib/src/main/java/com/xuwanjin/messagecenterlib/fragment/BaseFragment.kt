package com.xuwanjin.messagecenterlib.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xuwanjin.messagecenterlib.R

open class BaseFragment : Fragment() {
    protected lateinit var fragmentView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_base_message, container, false)
        return fragmentView
    }
}