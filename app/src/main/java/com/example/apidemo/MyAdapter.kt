package com.example.apidemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(var con : Context,var userlist : List<MyDataItems>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.raw_list_data,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userlist.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.title.text = userlist[position].name
//        holder.subTitle.text = userlist[position].subTitle
//
//        Glide.with(con).load(userlist[position].image).into(holder.image)
       // holder.image.setImageResource(userlist[position].image.toInt())

    }


    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var image = v.findViewById<ImageView>(R.id.imgLogo)
        var title = v.findViewById<TextView>(R.id.txtTitle)
        var subTitle = v.findViewById<TextView>(R.id.txtSubTitle)
    }
}