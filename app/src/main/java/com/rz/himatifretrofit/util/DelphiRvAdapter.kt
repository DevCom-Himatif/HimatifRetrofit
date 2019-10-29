package com.rz.himatifretrofit.util

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rz.himatifretrofit.R
import com.rz.himatifretrofit.model.AnggotaHimatif

class DelphiRvAdapter(val ctx: Context) : RecyclerView.Adapter<DelphiRvAdapter.RvViewHolder>() {
    private var list: ArrayList<AnggotaHimatif> = arrayListOf()

    fun setList(anggotas : List<AnggotaHimatif>){
        list.addAll(anggotas)
        Log.d("SetList", "Success")
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.delphi_viewholder, parent, false)
        return RvViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.nama.text = list[position].nama
        holder.npm.text = list[position].npm
        holder.email.text = list[position].email
        Glide.with(ctx)
            .load(list[position].url_foto)
            .apply(RequestOptions().override(72,72))
            .into(holder.foto)

        Log.d("Holder", list[position].toString() )
    }

    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama = itemView.findViewById<TextView>(R.id.name)
        val npm= itemView.findViewById<TextView>(R.id.npm)
        val email = itemView.findViewById<TextView>(R.id.email)
        val foto = itemView.findViewById<ImageView>(R.id.circle_image)
    }
}