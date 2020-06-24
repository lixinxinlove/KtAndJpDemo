package com.lixinxinlove.ktandjpdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.lixinxinlove.ktandjpdemo.R
import com.lixinxinlove.ktandjpdemo.dao.UserDao
import com.lixinxinlove.ktandjpdemo.database.AppDatabase
import com.lixinxinlove.ktandjpdemo.entity.User
import kotlinx.android.synthetic.main.activity_room_demo.*
import kotlinx.coroutines.*

class RoomDemoActivity : AppCompatActivity() {

    //防止内存泄漏
    val scope = MainScope()

    lateinit var userDao: UserDao

    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_demo)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name")
            .build()
        userDao = db.userDao()


    }


    fun onInsent(view: View) {
        scope.launch(Dispatchers.Main) {
            userDao.insertAll(User(0, "李", "鑫鑫", "17090408824"))
        }
    }

    fun onSelect(view: View) {
        scope.launch(Dispatchers.Main) {
            user = userDao.findById(0)
            if (user != null) {
                tv.text = user.toString()
            } else {
                tv.text = "没有数据"
            }
        }
    }

    fun onDelete(view: View) {
        scope.launch(Dispatchers.Main) {
            userDao.delete(user!!)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        //防止协程泄露
        scope.cancel()
    }
}