package com.ebookfrenzy.pinballappmad155

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_pinball_directory.*


import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_pinball_directory.*
import kotlinx.android.synthetic.main.content_pinball_directory.*


class PinballDirectory : AppCompatActivity() {


        private var layoutManager: RecyclerView.LayoutManager?=null
        private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pinball_directory)
            setSupportActionBar(toolbar)

            layoutManager = LinearLayoutManager(this)
            recycler_view.layoutManager = layoutManager
            adapter = RecyclerAdapter()
            recycler_view.adapter = adapter
    }
}