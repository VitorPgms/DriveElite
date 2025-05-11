package com.example.driveelite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.driveelite.R

import com.example.driveelite.model.Moto

class MotoAdapter(private val motos: List<Moto>): RecyclerView.Adapter<MotoAdapter.MotoViewHolder>() {

    class MotoViewHolder(itemMoto: View): RecyclerView.ViewHolder(itemMoto) {
        val nome: TextView = itemMoto.findViewById(R.id.txtNome)
        val imagem: ImageView = itemMoto.findViewById(R.id.imgCarro)
        val preco: TextView = itemMoto.findViewById(R.id.txtPreco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carro,parent,false)
        return MotoViewHolder(view)
    }

    override fun getItemCount(): Int = motos.size

    override fun onBindViewHolder(holder: MotoViewHolder, position: Int) {
        val motos = motos[position]
        holder.nome.text = motos.nome
        holder.imagem.setImageResource(motos.imagemId)
        holder.preco.text = motos.preco
    }

}