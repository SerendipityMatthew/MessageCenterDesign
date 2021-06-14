package com.xuwanjin.messagecenterlib.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xuwanjin.messagecenterlib.api.BaseMessageApi
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import retrofit2.HttpException
import java.io.IOException

class PageBaseMessagePagingSource(
    private val baseMessageApi: BaseMessageApi
) : PagingSource<String, BaseMessage>() {
    override fun getRefreshKey(state: PagingState<String, BaseMessage>): String? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.mMessageTitle
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, BaseMessage> {
        return try {
            val data = baseMessageApi.getMessageList()
            LoadResult.Page(
                data = data,
                prevKey = data.size.toString(),
                nextKey = data.size.toString()
            )

        } catch (ioException: IOException) {
            LoadResult.Error(ioException)
        } catch (httpException: HttpException) {
            LoadResult.Error(httpException)
        }
    }
}