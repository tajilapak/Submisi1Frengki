package com.example.frengki.submisi1frengki

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class KlubAdapter(val list : MutableList<KlubBola>, var listener : (KlubBola) -> Unit) : RecyclerView.Adapter<KlubAdapter.KlubBolaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KlubBolaViewHolder{
        return KlubBolaViewHolder(KlubBolaUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: KlubAdapter.KlubBolaViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class KlubBolaViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView
        var textView : TextView

        init{
            imageView = itemView.findViewById(KlubBolaUI.logoId)
            textView = itemView.findViewById(KlubBolaUI.namaId)
        }
        fun bindItem(items : KlubBola, listener: (KlubBola) -> Unit){
            textView.text = items.nama
            Glide.with(itemView.context).load(items.logo).into(imageView)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}