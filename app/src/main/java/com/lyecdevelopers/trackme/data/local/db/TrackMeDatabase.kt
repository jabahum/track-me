package com.lyecdevelopers.trackme.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lyecdevelopers.trackme.data.local.db.user.User
import com.lyecdevelopers.trackme.data.local.db.user.UserDao

/**
 * created by jaba
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class TrackMeDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {
        fun getInstance(context: Context): TrackMeDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TrackMeDatabase::class.java, "TrackMeDatabase.db"
            )
                .build()
        }
    }
}