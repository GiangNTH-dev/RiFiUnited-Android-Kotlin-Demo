package com.giangnth.rifiunitedkotlin.data.network

import com.giangnth.rifiunitedkotlin.data.model.CampaignModel
import com.giangnth.rifiunitedkotlin.data.model.SettingModel

interface  Api{
    fun getCampaigns(callBack:(ArrayList<CampaignModel>)->Unit)
    fun getSetting(callBack: (SettingModel) -> Unit,  account:String)
}