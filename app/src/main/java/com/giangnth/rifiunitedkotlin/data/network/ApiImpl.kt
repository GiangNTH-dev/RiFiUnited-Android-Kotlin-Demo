package com.giangnth.rifiunitedkotlin.data.network

import android.util.Log
import com.giangnth.rifiunitedkotlin.data.model.CampaignModel
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import okhttp3.OkHttpClient
import com.androidnetworking.error.ANError
import org.json.JSONArray
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.giangnth.rifiunitedkotlin.data.model.SettingModel
import com.google.gson.Gson
import org.json.JSONObject


class ApiImpl:Api{
    override fun getSetting(callBack: (SettingModel) -> Unit,  account:String) {
        AndroidNetworking.get("https://api-dev.rifiunited.io/api/v1/users/settings?account=${account}")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object:JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    var settingData : SettingModel
                    settingData=Gson().fromJson(response.toString(),SettingModel::class.java)
                    callBack(settingData)
                }

                override fun onError(anError: ANError?) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }

    override fun getCampaigns(callBack: (ArrayList<CampaignModel>) -> Unit) {
        AndroidNetworking.get("https://api-dev.rifiunited.io/api/v1/campaigns?account=0x37e0675c16955fb1a241089e2aaeedc6f928cbc9")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    var campaigns:ArrayList<CampaignModel> = arrayListOf()
                    for(index in response.length()-1 downTo  0){
                       val model =  Gson().fromJson<CampaignModel>(response.getJSONObject(index).toString(), CampaignModel::class.java)
                        campaigns.add(model)
                    }
                    callBack(campaigns)
                }

                override fun onError(error: ANError) {
                    Log.e("err", error.toString())
                    // handle error
                }
            })
    }

}