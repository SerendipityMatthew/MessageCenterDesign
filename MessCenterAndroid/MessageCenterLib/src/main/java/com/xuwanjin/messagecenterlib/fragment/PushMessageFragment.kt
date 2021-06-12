package com.xuwanjin.messagecenterlib.fragment

import android.os.Bundle
import com.xuwanjin.messagecenterlib.fragment.BaseFragment

class PushMessageFragment: BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentBaseMessageBinding.fragmentText.text = "Push Message"
    }
}