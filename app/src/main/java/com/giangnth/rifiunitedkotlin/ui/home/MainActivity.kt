package com.giangnth.rifiunitedkotlin.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giangnth.rifiunitedkotlin.BottomBarAdapter
import com.giangnth.rifiunitedkotlin.CustomAdapter
import com.giangnth.rifiunitedkotlin.R
import com.giangnth.rifiunitedkotlin.data.model.SettingModel
import com.giangnth.rifiunitedkotlin.ui.league.LeagueActivity
import com.giangnth.rifiunitedkotlin.ui.match.MatchActivity
import com.giangnth.rifiunitedkotlin.ui.ranking.RankingActivity
import com.giangnth.rifiunitedkotlin.ui.redeem.RedeemActivity
import com.giangnth.rifiunitedkotlin.ui.setting.SettingActivity
import com.giangnth.rifiunitedkotlin.ui.squad.SquadActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CustomAdapter
    lateinit var buttonAdapter:BottomBarAdapter
    lateinit var viewModel:HomeViewModel
    var settingData:SettingModel? = null
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
        buttonAdapter= BottomBarAdapter(arrayListOf()){
            when(it)
            {
                0->{
                    val intent = Intent(this, RankingActivity::class.java)
                    intent.putExtra("name", "đây là tên")
                    val bundel = Bundle()
                    bundel.putFloat("float", 0.1F)
                    bundel.putInt("int", 0)
                    intent.putExtra("bundle",bundel)
                    intent.putExtra("model", viewModel.listButton.value!![it])
                    startActivityForResult(intent, 0)
                }
                1->{
                    val intent = Intent(this, RedeemActivity::class.java)
                    intent.putExtra("name", "đây là tên")
                    val bundel = Bundle()
                    bundel.putFloat("float", 0.1F)
                    bundel.putInt("int", 0)
                    intent.putExtra("bundle",bundel)
                    intent.putExtra("model", viewModel.listButton.value!![it])
                    startActivityForResult(intent, 0)
                }
                2->{
                    val intent = Intent(this, SquadActivity::class.java)
                    intent.putExtra("name", "đây là tên")
                    val bundel = Bundle()
                    bundel.putFloat("float", 0.1F)
                    bundel.putInt("int", 0)
                    intent.putExtra("bundle",bundel)
                    intent.putExtra("model", viewModel.listButton.value!![it])
                    startActivityForResult(intent, 0)
                }
                3->{
                    val intent = Intent(this, MatchActivity::class.java)
                    intent.putExtra("name", "đây là tên")
                    val bundel = Bundle()
                    bundel.putFloat("float", 0.1F)
                    bundel.putInt("int", 0)
                    intent.putExtra("bundle",bundel)
                    intent.putExtra("model", viewModel.listButton.value!![it])
                    startActivityForResult(intent, 0)
                }
                4->{
                    val intent = Intent(this, LeagueActivity::class.java)
                    intent.putExtra("name", "đây là tên")
                    val bundel = Bundle()
                    bundel.putFloat("float", 0.1F)
                    bundel.putInt("int", 0)
                    intent.putExtra("bundle",bundel)
                    intent.putExtra("model", viewModel.listButton.value!![it])
                    startActivityForResult(intent, 0)
                }
            }

        }

        val buttonManager=LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        listBottomButton.layoutManager=buttonManager
        listBottomButton.adapter = buttonAdapter
        //load image avartar
        Picasso.with(this).load("https://api-dev.rifiunited.io/uploads/user_clubs/61af14b438530cc39946f293/GiangTest hihi.jpeg").into(profile_image);
        initData()
    }

    private fun initData() {
        viewModel.initData()
    }

    private fun initEventViewModel() {
        viewModel.listCampaigns.observe(this, Observer {
            adapter.listCampaigns = it
        })
        viewModel.listButton.observe(this, Observer {
            buttonAdapter.listButon=it
        })
        viewModel.settingData.observe(this, Observer {
          this.settingData=it
            userName.text=settingData?.clubName
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0){
            Log.e("MainActivity", "result Data")
            Log.e("MainActivity", "${data?.getStringExtra("result")}")
        }
    }

    fun clickSetting(view: View) {
        val intentSetting = Intent(this, SettingActivity::class.java)
        val bundel = Bundle()
        bundel.putString("name", settingData?.clubName)
        bundel.putString("avatar", settingData?.clubIcon)
        intentSetting.putExtra("bundle",bundel)
        startActivityForResult(intentSetting, 0)
    }
}
