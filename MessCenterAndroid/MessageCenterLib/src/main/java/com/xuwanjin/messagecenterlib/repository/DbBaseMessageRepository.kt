package com.xuwanjin.messagecenterlib.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.xuwanjin.messagecenterlib.api.BaseMessageApi
import com.xuwanjin.messagecenterlib.db.MessageDB


class DbBaseMessageRepository(
    private val messageDB: MessageDB,
    private val messageApi: BaseMessageApi
) : BaseMessageRepository {
    @ExperimentalPagingApi
    override fun fetchAllMessage(pageSize: Int) =
        Pager(PagingConfig(pageSize)) {
            PageBaseMessagePagingSource(
                baseMessageApi = messageApi
            )
        }.flow

}