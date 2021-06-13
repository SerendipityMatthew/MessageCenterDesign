package com.xuwanjin.messagecenterlib.ui

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xuwanjin.messagecenterlib.R
import com.xuwanjin.messagecenterlib.entity.BaseMessage

class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mMessageTitleTv: TextView = view.findViewById(R.id.message_title)
    private val mMessageContentTv: TextView = view.findViewById(R.id.message_content)

    fun bind(baseMessage: BaseMessage) {
        with(baseMessage) {
            mMessageTitleTv.text = mMessageTitle
            mMessageContentTv.text = mMessageContent
            Log.d("Matthew", "bind: ")
        }

    }
}