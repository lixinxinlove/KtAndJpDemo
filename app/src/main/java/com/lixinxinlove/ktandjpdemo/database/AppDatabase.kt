package com.lixinxinlove.ktandjpdemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lixinxinlove.ktandjpdemo.dao.UserDao
import com.lixinxinlove.ktandjpdemo.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
