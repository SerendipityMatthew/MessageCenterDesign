package com.xuwanjin.messagecenterlib.repository

import androidx.paging.PagingData
import com.xuwanjin.messagecenterlib.api.BaseMessageApi
import com.xuwanjin.messagecenterlib.db.MessageDB
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import kotlinx.coroutines.flow.Flow

interface BaseMessageRepository{
    fun fetchAllMessage(pageSize: Int): Flow<PagingData<BaseMessage>>
}

enum class Type {
    IN_MEMORY_BY_ITEM,
    IN_MEMORY_BY_PAGE,
    DB
}