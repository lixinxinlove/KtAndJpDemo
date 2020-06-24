package com.lixinxinlove.ktandjpdemo.ui.home

import android.graphics.drawable.shapes.Shape
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.Composable
import androidx.compose.state
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.lixinxinlove.ktandjpdemo.R
import com.lixinxinlove.ktandjpdemo.dp
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.reflect.Modifier
import java.nio.file.Files.size

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        textView.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("name","lixinxin")
            Navigation.findNavController(it).navigate(R.id.fragment_transaction_activity,bundle)
        }
        return root
    }




}