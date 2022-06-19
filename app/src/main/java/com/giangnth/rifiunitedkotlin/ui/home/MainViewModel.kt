package com.giangnth.rifiunitedkotlin.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.giangnth.rifiunitedkotlin.data.model.CampaignModel
import com.giangnth.rifiunitedkotlin.data.model.ListButtonModel
import com.giangnth.rifiunitedkotlin.data.model.SettingModel
import com.giangnth.rifiunitedkotlin.repository.ApiRepository
import kotlinx.coroutines.awaitAll


class HomeViewModel : ViewModel() {
    val apiRepository:ApiRepository = ApiRepository()
    val listButton: MutableLiveData<ArrayList<ListButtonModel>> = MutableLiveData()
    val settingData: MutableLiveData<SettingModel> = MutableLiveData()
    val listCampaigns: MutableLiveData<ArrayList<CampaignModel>> = MutableLiveData()
    fun initData() {
        val listTitle:ArrayList<String> = arrayListOf("LEADERBOARD","REDEEM", "SQUAD","MATCH","LEAGUE")
        val lstButton:ArrayList<ListButtonModel> = arrayListOf()
        for(i in 0..listTitle.size-1)
        {
            lstButton.add(
                ListButtonModel(
                    index = i,
                    title = listTitle[i]
                )
            )
        }
       this.listButton.postValue(lstButton)
        val lstCampaigns:ArrayList<CampaignModel> = arrayListOf()
        for (i in 0..29){
            lstCampaigns.add(
                CampaignModel(
                    "$i",
                    account = "0x37e0675c16955fb1a241089e2aaeedc6f928cbc9",
                    level = i+1,
                    win = 0,
                    draw = 0,
                    loss = 0,
                    season = 0,
                    status = 2
                )
            )
        }
         apiRepository.getCampaigns {
            var list  = it
            for(i in 0..(list.count()-1)){
                lstCampaigns.removeAt(0)

            }
            for(i in 0..(it.size-1)){
                list.get(i).status  = 0

            }
            lstCampaigns.addAll(0, list)
            list[list.count()-1].status = 1
            this.listCampaigns.postValue(lstCampaigns)
        }
        apiRepository.getSetting({
            this.settingData.postValue(it)
        },"0x37e0675c16955fb1a241089e2aaeedc6f928cbc9")
    }


}