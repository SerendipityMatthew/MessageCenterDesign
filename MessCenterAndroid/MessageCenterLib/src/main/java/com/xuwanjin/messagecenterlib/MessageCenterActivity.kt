package com.xuwanjin.messagecenterlib

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.xuwanjin.messagecenterlib.databinding.ActivityMessageCenterBinding
import com.xuwanjin.messagecenterlib.fragment.BaseFragmentPageAdapter
import com.xuwanjin.messagecenterlib.fragment.DeviceMessageFragment
import com.xuwanjin.messagecenterlib.fragment.PushMessageFragment
import com.xuwanjin.messagecenterlib.fragment.SharingFragment
import com.xuwanjin.messagecenterlib.viewmodel.MessageCenterViewModel

class MessageCenterActivity : AppCompatActivity() {
    private lateinit var mMessageTabLayout: TabLayout
    private lateinit var vpMessageContent: ViewPager2
    private lateinit var mFragmentList: MutableList<Fragment>
    private lateinit var activityMessageCenterBinding: ActivityMessageCenterBinding
    private val model: MessageCenterViewModel by viewModels {
        object : AbstractSavedStateViewModelFactory(this, null) {
            override fun <T : ViewModel?> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                val messageRepo =
                    ServiceLocator.instance(this@MessageCenterActivity).getRepository()
                return MessageCenterViewModel(messageRepo, handle) as T
            }

        }

    }

    companion object {
        const val MAX_FIX_TAB_ITEM = 4
    }

    protected var titleList = mutableListOf<String>().apply {
        add("设备通知")
        add("推送消息")
        add("分享")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMessageCenterBinding = ActivityMessageCenterBinding.inflate(layoutInflater)
        setContentView(activityMessageCenterBinding.root)
        mMessageTabLayout = activityMessageCenterBinding.messageTabLayoutContainer
        vpMessageContent = activityMessageCenterBinding.vpMessageContent
        initFragmentList()
        vpMessageContent.isUserInputEnabled = true
        vpMessageContent.adapter =
            BaseFragmentPageAdapter(supportFragmentManager, lifecycle, mFragmentList)

        attachTabLayoutAndViewPager2()
    }

    private fun initFragmentList() {
        mFragmentList = mutableListOf<Fragment>().apply {
            add(DeviceMessageFragment())
            add(PushMessageFragment())
            add(SharingFragment())
        }
        Log.d("Matthew", "onCreate: fragmentList.size = ${mFragmentList.size}")

        if (mFragmentList.size > MAX_FIX_TAB_ITEM) {
            mMessageTabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        }
    }


    private fun attachTabLayoutAndViewPager2() {
        Log.d("Matthew", "attachTabLayoutAndViewPager2: ")
        TabLayoutMediator(
            mMessageTabLayout,
            vpMessageContent
        ) { tab, position ->
            tab.text = titleList[position]
        }.attach()
    }
}