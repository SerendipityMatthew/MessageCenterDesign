package com.xuwanjin.messagecenterlib

import android.os.Bundle

class PushMessageFragment:BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentBaseMessageBinding.fragmentText.text = "Push Message"
    }
}