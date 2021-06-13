package com.xuwanjin.messagecenterlib.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xuwanjin.messagecenterlib.databinding.FragmentBaseMessageBinding
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import com.xuwanjin.messagecenterlib.ui.adapter.MessageAdapter

open class BaseFragment : Fragment() {
    protected lateinit var fragmentBaseMessageBinding: FragmentBaseMessageBinding
    protected lateinit var mMessageAdapter: MessageAdapter
    protected lateinit var mMessageList: MutableList<BaseMessage>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBaseMessageBinding = FragmentBaseMessageBinding.inflate(layoutInflater)
        mMessageList = initMessageList()

        mMessageAdapter = MessageAdapter(requireContext(), mMessageList)
        Log.d("Matthew", "onCreateView: ")
        fragmentBaseMessageBinding.messageRecyclerview.adapter = mMessageAdapter
        fragmentBaseMessageBinding.messageRecyclerview.layoutManager =
            LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }

        return fragmentBaseMessageBinding.root
    }

    private fun initMessageList(): MutableList<BaseMessage> {
        return mutableListOf<BaseMessage>().apply {
            add(BaseMessage("",  "MatthewA", "MatthewA Content", "Sun Jun 13 11:57:03 CST 2021"))
            add(BaseMessage("", "MatthewB", "MatthewB Content", "Sun Jun 13 11:57:03 CST 2021"))
            add(BaseMessage("", "MatthewC", "MatthewC Content", "Sun Jun 13 11:57:03 CST 2021"))
            add(BaseMessage("", "MatthewD", "MatthewD Content", "Sun Jun 13 11:57:03 CST 2021"))
            add(BaseMessage("", "MatthewE", "MatthewE Content", "Sun Jun 13 11:57:03 CST 2021"))
        }
    }
}