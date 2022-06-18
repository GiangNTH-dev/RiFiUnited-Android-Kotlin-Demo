package com.giangnth.rifiunitedkotlin.data.model

data class CampaignModel(var _id:String, var account:String, var level:Int,var win:Int, var draw:Int, var loss:Int, var season:Int, var status: Int? = 0) {

}
//status: 0 đã chơi, 1 selected, 2 chưa chơi