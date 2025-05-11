package com.example.driveelite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.driveelite.R
import com.example.driveelite.databinding.ItemCarroBinding
import com.example.driveelite.model.Carro

class CarroAdapter (private val carros: List<Carro>): RecyclerView.Adapter<CarroAdapter.CarroViewHolder>(){


    class CarroViewHolder(itemCarroBinding: View): RecyclerView.ViewHolder(itemCarroBinding) {
        val nome: TextView = itemCarroBinding.findViewById(R.id.txtNome)
        val imagem: ImageView = itemCarroBinding.findViewById(R.id.imgCarro)
        val preco: TextView = itemCarroBinding.findViewById(R.id.txtPreco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carro,parent,false)
        return CarroViewHolder(view)
    }

    override fun getItemCount(): Int = carros.size

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = carros[position]
        holder.nome.text = carro.nome
        holder.imagem.setImageResource(carro.imagemResId)
        holder.preco.text = carro.preco
    }

}