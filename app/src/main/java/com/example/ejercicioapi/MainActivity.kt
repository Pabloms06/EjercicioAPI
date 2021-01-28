package com.example.ejercicioapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.cbellmont.ejemplodescargainternet.data
import com.example.ejercicioapi.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

interface MainActivityInterface {
    suspend fun onFilmsReceived(dataPopulation: List<data>)
}

class MainActivity : AppCompatActivity(), MainActivityInterface {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.IO).launch{
            GetAllFilms.send(this@MainActivity)
        }
    }

    override suspend fun onFilmsReceived(dataPopulation: List<data>) {
        withContext(Dispatchers.Main){
            binding.data.text = ""
            dataPopulation.forEach {
                data.append(it.toString())
            }
        }

    }
}