package com.xuwanjin.messagecenterlib.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.xuwanjin.messagecenterlib.db.MessageDB
import com.xuwanjin.messagecenterlib.db.MessageDao
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class PageKeyedRemoteMediator(
    private val db: MessageDB,
) : RemoteMediator<Int, BaseMessage>() {
    private val remoteKeyDao: MessageDao = db.remoteKeys()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BaseMessage>
    ): MediatorResult {
        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = db.withTransaction {
                        remoteKeyDao.fetchMessage()
                    }
                }
            }
            return  MediatorResult.Success(endOfPaginationReached = true)
        } catch (e: IOException) {
            return  MediatorResult.Error(e)
        } catch (e: HttpException) {
            return  MediatorResult.Error(e)
        }
    }
}