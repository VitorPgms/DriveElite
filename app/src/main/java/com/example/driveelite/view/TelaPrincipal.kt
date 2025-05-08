package com.example.driveelite.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.driveelite.R
import com.example.driveelite.adapter.CarAdapter
import com.example.driveelite.adapter.CategoryAdapter
import com.example.driveelite.api.Api
import com.example.driveelite.api.ApiClient
import com.example.driveelite.api.ApiClient.carApiService
import com.example.driveelite.databinding.ActivityTelaPrincipalBinding
import com.example.driveelite.model.Car
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private lateinit var carAdapter: CarAdapter
    private lateinit var carApiService: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        carApiService = ApiClient.retrofit.create(Api::class.java)

        val todasCategorias = listOf("Todos", "Nissan", "BMW", "Toyota", "Subaru", "Fiat")
        var categoriaSelecionada = ""

        binding.rvCategoria.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        carAdapter = CarAdapter(emptyList())
        binding.rvCarros.layoutManager = LinearLayoutManager(this)
        binding.rvCarros.adapter = carAdapter
        
        
        val categoryAdapter = CategoryAdapter(
            categories = todasCategorias,
            selectedCategory = categoriaSelecionada
        ) { novaCategoria ->
            categoriaSelecionada = novaCategoria

            if (novaCategoria == "Todos") {
                carAdapter.updateList(emptyList())
            } else {
                carApiService.getCars(novaCategoria).enqueue(object : Callback<List<Car>> {
                    override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                        if(response.isSuccessful) {
                            val carrosDaApi = response.body() ?: emptyList()
                            carAdapter.updateList(carrosDaApi)
                        } else {
                            Toast.makeText(this@TelaPrincipal, "Erro: ${response.body()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                        Toast.makeText(this@TelaPrincipal, "Falhou ao conectar: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })

            }

        }

        binding.rvCategoria.adapter = categoryAdapter

    }

}