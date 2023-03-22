package com.AndresUrrea.notifinal.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.AndresUrrea.notifinal.R
import com.AndresUrrea.notifinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = mainBinding.root
        setContentView(view)

        val calcularObserver = Observer<Double>{total->
            mainBinding.textTotal.text=total.toString()
        }
        mainViewModel.total.observe(this,calcularObserver)


        mainBinding.CalcularButton.setOnClickListener {
            mainViewModel.calcular(mainBinding.TextInputLaboratorio.text.toString().toDouble(),mainBinding.TextInputPrimer.text.toString().toDouble(),mainBinding.TextInputSegundo.text.toString().toDouble(),mainBinding.TextInputFinal.text.toString().toDouble())
        }


    }
}