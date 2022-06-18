package com.giangnth.rifiunitedkotlin.data.network

import com.giangnth.rifiunitedkotlin.data.model.CampaignModel

interface  Api{
    fun getCampaigns(callBack:(ArrayList<CampaignModel>)->Unit)
}