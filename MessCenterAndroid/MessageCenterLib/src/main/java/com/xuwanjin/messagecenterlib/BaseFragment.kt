package com.xuwanjin.messagecenterlib

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xuwanjin.messagecenterlib.databinding.FragmentBaseMessageBinding

open class BaseFragment : Fragment() {
    protected lateinit var mFragmentBaseMessageBinding: FragmentBaseMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_base_message, container, false)
    }
}