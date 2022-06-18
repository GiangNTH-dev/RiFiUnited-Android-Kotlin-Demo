package com.giangnth.rifiunitedkotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giangnth.rifiunitedkotlin.CustomAdapter
import com.giangnth.rifiunitedkotlin.R
import com.giangnth.rifiunitedkotlin.data.model.CampaignModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CustomAdapter
    lateinit var viewModel:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =  ViewModelProvider(this).get(HomeViewModel::class.java)
        
        setContentView(R.layout.activity_main)
        initEventViewModel()
        imageView.setImageResource(R.drawable.background_home)
        adapter = CustomAdapter(arrayListOf())
        listviewCampaigns.adapter = adapter
        val manager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        listviewCampaigns.layoutManager = manager
        initData()
    }

    private fun initData() {
        viewModel.initData()
    }

    private fun initEventViewModel() {
        viewModel.listCampaigns.observe(this, Observer {
            adapter.listCampaigns = it
        })
    }

}
