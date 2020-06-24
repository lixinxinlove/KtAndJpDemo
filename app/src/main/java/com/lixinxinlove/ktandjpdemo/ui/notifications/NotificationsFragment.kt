package com.lixinxinlove.ktandjpdemo.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lixinxinlove.ktandjpdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        _onCreateView()

        return root
    }

    private fun _onCreateView() {

        GlobalScope.launch(Dispatchers.Main) {
            ioFun1()
            uiFun1()
            ioFun2()
            uiFun2()
            ioFun3()
            uiFun3()
        }
    }


    private suspend fun ioFun1() {
        withContext(Dispatchers.IO) {
            Log.e("ioFun1", Thread.currentThread().name)
        }
    }

    private suspend fun ioFun2() {
        withContext(Dispatchers.IO) {
            Log.e("ioFun2", Thread.currentThread().name)
        }
    }

    private suspend fun ioFun3() {
        withContext(Dispatchers.IO) {
            Log.e("ioFun3", Thread.currentThread().name)
        }
    }


    fun uiFun1() {
        Log.e("uiFun1", Thread.currentThread().name)
    }

    fun uiFun2() {
        Log.e("uiFun2", Thread.currentThread().name)
    }

    fun uiFun3() {
        Log.e("uiFun3", Thread.currentThread().name)
    }


}