package com.example.driveelite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.driveelite.databinding.ItemCarroBinding
import com.example.driveelite.model.Car

class CarAdapter(
    private var carros: List<Car>
): RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(val binding: ItemCarroBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarroBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return CarViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val carro = carros[position]
        with(holder.binding) {
            txtNome.text = carro.model
            txtMarca.text= carro.make
            txtAno.text = "Ano: ${carro.year}"
            txtPotencia.text = "Potencia: ${carro.cylinders}"
        }
    }

    override fun getItemCount(): Int = carros.size

    fun updateList(novaLista: List<Car>) {
        carros = novaLista
        notifyDataSetChanged()
    }
}