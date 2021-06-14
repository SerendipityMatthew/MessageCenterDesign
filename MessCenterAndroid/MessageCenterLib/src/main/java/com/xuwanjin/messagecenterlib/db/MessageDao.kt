package com.xuwanjin.messagecenterlib.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xuwanjin.messagecenterlib.entity.BaseMessage

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(messageList: List<BaseMessage>)

    suspend fun updateMessageById(message: BaseMessage)

    @Query("SELECT * FROM message")
    suspend fun fetchMessage()
}