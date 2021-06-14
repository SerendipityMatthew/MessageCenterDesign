package com.xuwanjin.messagecenterlib.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xuwanjin.messagecenterlib.entity.BaseMessage

@Database(
    entities = [BaseMessage::class],
    version = 1,
    exportSchema = false
)
abstract class MessageDB : RoomDatabase() {
    companion object {
        fun create(context: Context, userMemory: Boolean): MessageDB {
            val databaseBuilder = if (userMemory) {
                Room.inMemoryDatabaseBuilder(context, MessageDB::class.java)
            } else {
                Room.databaseBuilder(context, MessageDB::class.java, "message.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration().
                build()
        }
    }

    abstract fun post()
    abstract fun remoteKeys():MessageDao
}