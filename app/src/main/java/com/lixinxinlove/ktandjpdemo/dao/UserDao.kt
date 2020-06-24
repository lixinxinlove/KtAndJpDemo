package com.lixinxinlove.ktandjpdemo.dao

import androidx.room.*
import com.lixinxinlove.ktandjpdemo.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): User

    @Query("SELECT * FROM user WHERE uid =(:uid)")
    suspend fun findById(uid: Int): User?

    @Insert
    suspend fun insertAll(vararg users: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun updateUser(user: User)
}
