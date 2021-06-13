package com.xuwanjin.messagecenterlib.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.xuwanjin.messagecenterlib.R
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import com.xuwanjin.messagecenterlib.ui.MessageViewHolder

class MessageAdapter(
    private val mContext:Context,
    private val mMessageList:MutableList<BaseMessage>
) : PagingDataAdapter<BaseMessage, MessageViewHolder>(message_comparator) {
    companion object {
        val message_comparator = object : DiffUtil.ItemCallback<BaseMessage>() {
            override fun areItemsTheSame(oldItem: BaseMessage, newItem: BaseMessage): Boolean =
                false

            override fun areContentsTheSame(oldItem: BaseMessage, newItem: BaseMessage): Boolean =
                false

        }
    }

    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        Log.d("Matthew", "onBindViewHolder: mMessageList[position] = " + mMessageList[position])
        holder.bind(mMessageList[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return MessageViewHolder(mContext,view)
    }
}
