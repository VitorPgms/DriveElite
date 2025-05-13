package com.example.driveelite.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.driveelite.R
import com.example.driveelite.adapter.CarroAdapter
import com.example.driveelite.adapter.CategoriaAdapter
import com.example.driveelite.adapter.MotoAdapter
import com.example.driveelite.databinding.ActivityTelaPrincipalBinding
import com.example.driveelite.model.Carro
import com.example.driveelite.model.Moto

private lateinit var binding: ActivityTelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val recyclerView1 = binding.recyclerView1
        val recyclerView2 = binding.recyclerView2
        val recyclerView3 = binding.recyclerView3

        val categorie = listOf("Todos", "Carros", "Motos", "BMW")

        val adapter = CategoriaAdapter(categorie) { categiaSelecionada ->

            if(categiaSelecionada == "Todos") {
                //Mostrar todos os itens
            } else {
                //Filtrar ou navegar
            }

        }


        val categorieCarro = listOf(
            Carro("Nissan Gtr-R35", R.drawable.gtrr35,"R$550,00/D"),
            Carro("BMW M2", R.drawable.bmwm2,"R$350,00/D"),
            Carro("Toyota Supra", R.drawable.toyota_supra,"R$550,00/D")

        )

        val categorieMoto = listOf(
            Moto("Hornet", R.drawable.gtrr35, "R$200/Dia"),
            Moto("Hornet", R.drawable.gtrr35, "R$200/Dia"),
            Moto("Hornet", R.drawable.gtrr35, "R$200/Dia")
        )

        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = adapter

        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter = CarroAdapter(categorieCarro)

        recyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView3.adapter = MotoAdapter(categorieMoto)


    }
}