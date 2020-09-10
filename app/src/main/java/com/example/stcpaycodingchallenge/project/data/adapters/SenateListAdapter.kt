package com.example.stcpaycodingchallenge.project.data.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.project.activities.DetailsActivity
import com.example.stcpaycodingchallenge.project.data.entities.Senator
import com.example.stcpaycodingchallenge.project.mvp.view.MainView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.controller_list_item.view.*

class SenateListAdapter(var itemList: List<Senator>,var view :MainView) :
    RecyclerView.Adapter<SenateListAdapter.SenateViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenateViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return SenateViewHolder(
            layoutInflater.inflate(
                R.layout.controller_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SenateViewHolder, position: Int) {

        holder.itemView?.txtvName?.text = "${itemList[position]?.person?.firstname}  ${itemList[position]?.person?.lastname}"
        holder.itemView?.txtvPosition?.text = itemList[position]?.party?:""
        holder.itemView?.txtvDescription?.text = itemList[position]?.description?:""
        holder.itemView?.imgvLogo?.setImageResource(if (itemList[position].party == "Republican") R.drawable.republican_logo else R.drawable.democrat_logo)

        val b = Bundle()
        b.putString("item", Gson().toJson(itemList[position]))
        holder.itemView?.setOnClickListener { view?.ac?.navigateToTarget(DetailsActivity::class.java,b) }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class SenateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pos: Int = 0

    }
}
