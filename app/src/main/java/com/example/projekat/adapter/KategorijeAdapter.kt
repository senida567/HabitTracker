package com.example.projekat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekat.R
import com.example.projekat.entity.Kategorije


class KategorijeAdapter(kategorijeLista: List<Kategorije>) : RecyclerView.Adapter<KategorijeAdapter.KategorijeViewHolder>() {

    private var kategorijeLista: List<Kategorije>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KategorijeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.kategorije_element, parent, false)
        return KategorijeViewHolder(view)
    }

    override fun onBindViewHolder(holder: KategorijeViewHolder, position: Int) {
        val kategorije : Kategorije = kategorijeLista.get(position)
        holder.naziv.setText(kategorije.naziv)
        holder.osobina.setText(kategorije.osobina.toString()) //zasad je osobina boolean
        //i sve što korisnik treba vidjeti iz tebele kategorije
    }

    override fun getItemCount(): Int {
        return kategorijeLista.size
    }

    inner class KategorijeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var naziv : TextView
        var osobina: TextView

        init {
            naziv = itemView.findViewById(R.id.naziv)
            osobina = itemView.findViewById(R.id.osobina)
        }
    }

    init {
        this.kategorijeLista = kategorijeLista
    }

}

