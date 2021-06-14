package com.xuwanjin.messagecenterlib

import android.app.Application
import android.content.Context
import com.xuwanjin.messagecenterlib.api.BaseMessageApi
import com.xuwanjin.messagecenterlib.db.MessageDB
import com.xuwanjin.messagecenterlib.entity.BaseMessage
import com.xuwanjin.messagecenterlib.repository.BaseMessageRepository
import com.xuwanjin.messagecenterlib.repository.DbBaseMessageRepository

interface ServiceLocator {
    companion object {
        private val LOCK = Any()
        private var instance: ServiceLocator? = null
        fun instance(context: Context): ServiceLocator {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = DefaultServiceLocator(
                        app = context.applicationContext as Application,
                        userInMemoryDB = false
                    )
                }
                return instance!!
            }
        }

        fun swap(locator: ServiceLocator) {
            instance = locator
        }
    }

    fun getRepository():BaseMessageRepository
//    fun  getMessageApi():
}

open class DefaultServiceLocator(
    val app: Application,
    val userInMemoryDB: Boolean
) : ServiceLocator {
    private val db by lazy {
        MessageDB.create(app, userInMemoryDB)
    }
    private val api by lazy {
        BaseMessageApi.create()
    }

    override fun getRepository(): BaseMessageRepository {
        return DbBaseMessageRepository(db, api)
    }
}