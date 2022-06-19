package com.giangnth.rifiunitedkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giangnth.rifiunitedkotlin.data.model.ListButtonModel

class BottomBarAdapter : RecyclerView.Adapter<BottomBarAdapter.ViewHolder>{
//    var onClick:
    var onClick:(Int)->Unit
    var listButon:ArrayList<ListButtonModel> = arrayListOf()
    set(value) {
        field=value
        notifyDataSetChanged()
    }
    constructor(listButton:ArrayList<ListButtonModel>, onClick:(Int)->Unit) : super() {
       this.listButon=listButon
        this.onClick = onClick
    }

    class ViewHolder: RecyclerView.ViewHolder {
        var txtTitle:TextView
        var linearActive:RelativeLayout
        constructor(itemView: View) : super(itemView){
            txtTitle = itemView.findViewById(R.id.titleButton)
            linearActive = itemView.findViewById(R.id.bottomButton)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view  = LayoutInflater.from(parent.context).inflate(R.layout.item_button_bar,parent, false )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listButon.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = listButon[position].title
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }
}