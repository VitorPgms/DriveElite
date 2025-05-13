package com.example.driveelite.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.driveelite.R

class CategoriaAdapter(
    private val categorias: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    private var selectedPosition = 0

    inner class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCategoria: TextView = itemView.findViewById(R.id.tvCategoria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.tvCategoria.text = categoria

        // Atualiza o background com base na seleção
        if (selectedPosition == position) {
            holder.itemView.setBackgroundResource(R.drawable.bg_categoria_selected)
            holder.tvCategoria.setTextColor(Color.WHITE)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.bg_categoria_unselected)
            holder.tvCategoria.setTextColor(Color.BLACK)
        }

        holder.itemView.setOnClickListener {
            val previous = selectedPosition
            selectedPosition = position
            notifyItemChanged(previous)
            notifyItemChanged(position)
            onItemClick(categoria)
        }
    }

    override fun getItemCount() = categorias.size
}


