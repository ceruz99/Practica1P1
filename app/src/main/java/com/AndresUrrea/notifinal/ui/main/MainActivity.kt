package com.AndresUrrea.notifinal.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.AndresUrrea.notifinal.R
import com.AndresUrrea.notifinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var total : Double = 0.0
    private var primer : Double = 0.0
    private var segundo : Double = 0.0
    private var laboratorio : Double = 0.0
    private var final : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.CalcularButton.setOnClickListener {
            if (!(mainBinding.TextInputLaboratorio.text

                    .isNullOrEmpty()||mainBinding.TextInputLaboratorio.text.toString() == ".") && !(mainBinding.TextInputPrimer.text
                    .isNullOrEmpty()||mainBinding.TextInputPrimer.text.toString() == ".") && !(mainBinding.TextInputSegundo.text
                    .isNullOrEmpty()||mainBinding.TextInputSegundo.text.toString() == ".") && !(mainBinding.TextInputFinal.text
                    .isNullOrEmpty()||mainBinding.TextInputFinal.text.toString() == ".")
            ) {
                laboratorio = mainBinding.TextInputLaboratorio.text.toString().toDouble()
                primer = mainBinding.TextInputPrimer.text.toString().toDouble()
                segundo = mainBinding.TextInputSegundo.text.toString().toDouble()
                final = mainBinding.TextInputFinal.text.toString().toDouble()


                if ((laboratorio <= 5 ) && (primer <= 5) && (segundo <= 5) && (final <= 5 )) {
                    total =
                        (laboratorio * 0.6) + (primer * 0.07) + (segundo * 0.08) + (final * 0.25)
                    mainBinding.textTotal.text =  total.toString().plus(" ES SU NOTA FINAL")
                }
                else{
                    Toast.makeText(applicationContext, "Ingrese un valor entre 0-5",Toast.LENGTH_LONG).show()
                }
            }
            else{
                
                if(mainBinding.TextInputLaboratorio.text
                        .isNullOrEmpty()||mainBinding.TextInputLaboratorio.text.toString() == "."){
                    mainBinding.TextInputLaboratorio.error ="ingrese un valor valido"
                }
                if(mainBinding.TextInputPrimer.text
                        .isNullOrEmpty()||mainBinding.TextInputPrimer.text.toString() == "."){mainBinding.TextInputPrimer.error ="ingrese un valor valido"
                }
                if(mainBinding.TextInputSegundo.text
                        .isNullOrEmpty()||mainBinding.TextInputSegundo.text.toString() == "."){mainBinding.TextInputSegundo.error ="ingrese un valor valido"
                }
                if(mainBinding.TextInputFinal.text
                        .isNullOrEmpty()||mainBinding.TextInputFinal.text.toString() == "."){mainBinding.TextInputFinal.error ="ingrese un valor valido"
                }
            }
        }

        val view = mainBinding.root

        setContentView(view)
    }
}