package com.xuwanjin.messagecenterlib

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseFragmentPageAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle,
    private val mFragmentList: MutableList<Fragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        Log.d("Matthew", "getItemCount: ")
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getItemId(position: Int): Long {
        return mFragmentList[position].hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return PagerAdapter.POSITION_NONE
    }
}