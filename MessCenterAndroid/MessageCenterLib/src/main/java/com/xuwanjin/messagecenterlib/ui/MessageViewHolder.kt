package com.xuwanjin.messagecenterlib.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.xuwanjin.messagecenterlib.R
import com.xuwanjin.messagecenterlib.entity.BaseMessage

class MessageViewHolder(private val mContext: Context, view: View) : RecyclerView.ViewHolder(view) {
    private val mMessageTitleTv: TextView = view.findViewById(R.id.message_title)
    private val mMessageContentTv: TextView = view.findViewById(R.id.message_content)
    private val mMessageImageIV: ImageView = view.findViewById(R.id.message_image)

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(baseMessage: BaseMessage) {
        with(baseMessage) {
            mMessageTitleTv.text = mMessageTitle
            mMessageContentTv.text = mMessageContent
            mMessageImageIV.setImageDrawable(mContext.getDrawable(R.drawable.ic_launcher_round))
            Log.d("Matthew", "bind: ")
        }

    }
}