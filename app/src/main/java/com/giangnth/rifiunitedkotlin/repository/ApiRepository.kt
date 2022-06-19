package com.giangnth.rifiunitedkotlin.repository

import com.giangnth.rifiunitedkotlin.data.model.CampaignModel
import com.giangnth.rifiunitedkotlin.data.model.SettingModel
import com.giangnth.rifiunitedkotlin.data.network.Api
import com.giangnth.rifiunitedkotlin.data.network.ApiImpl

class ApiRepository : Api {
    val api:Api = ApiImpl()
    override fun getCampaigns(callBack: (ArrayList<CampaignModel>) -> Unit) {
        api.getCampaigns(callBack)
    }

    override fun getSetting(callBack: (SettingModel) -> Unit, account: String) {
        api.getSetting(callBack, account)
    }

}