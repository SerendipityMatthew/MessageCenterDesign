package com.xuwanjin.messagecenterlib.entity

import androidx.room.Entity

@Entity(tableName = "message")
data class BaseMessage(
    var mMessageTitle: String,
    var mMessageContent: String,
    var mMessageTime:String
    ) {

}