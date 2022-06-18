package com.giangnth.rifiunitedkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giangnth.rifiunitedkotlin.data.model.CampaignModel

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    var listCampaigns:ArrayList<CampaignModel> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    constructor(listCampaigns: ArrayList<CampaignModel>) : super() {
        this.listCampaigns = listCampaigns
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view  = LayoutInflater.from(parent.context).inflate(R.layout.list_campaign,parent, false )
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  listCampaigns.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textviewMatchNo.text = listCampaigns[position].level.toString()
        holder.txtWon.text = listCampaigns[position].win.toString()
        holder.txtLose.text = listCampaigns[position].loss.toString()
        holder.linearActive.visibility = if(listCampaigns[position].status == 1) View.VISIBLE else View.INVISIBLE
        holder.imageviewBackground.setImageResource(if(listCampaigns[position].status == 0) R.drawable.played_campaign_bg else if (listCampaigns[position].status == 1) R.drawable.ic_active else R.drawable.ic_incomming_campaign)
    }

    class ViewHolder: RecyclerView.ViewHolder {
         var textviewMatchNo:TextView
         var txtWon:TextView
         var txtLose:TextView
         var imageviewBackground:ImageView
         var linearActive:LinearLayout
        constructor(itemView: View) : super(itemView){
            textviewMatchNo = itemView.findViewById(R.id.txtMatchNo)
            txtWon = itemView.findViewById(R.id.txtWon)
            txtLose = itemView.findViewById(R.id.txtLose)
            imageviewBackground = itemView.findViewById(R.id.imageViewBgCampaign)
            linearActive = itemView.findViewById(R.id.linearActive)
        }
    }
}