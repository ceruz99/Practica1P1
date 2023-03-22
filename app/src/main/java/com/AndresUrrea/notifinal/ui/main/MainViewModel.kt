package com.AndresUrrea.notifinal.ui.main

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val total : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    fun calcular(primer:Double,segundo:Double,laboratorio:Double,final:Double){
        if (!(laboratorio.toString().isNullOrEmpty()||laboratorio.toString()==".") && !(primer.toString().isNullOrEmpty()||primer.toString()==".") && !(segundo.toString().isNullOrEmpty()||segundo.toString()==".") && !(final.toString().isNullOrEmpty()||final.toString()==".")
        ) {
            if ((laboratorio <= 5 ) && (primer <= 5) && (segundo <= 5) && (final <= 5 )) {
                total.value =
                    (laboratorio * 0.6) + (primer * 0.07) + (segundo * 0.08) + (final * 0.25)
            }
        }
    }
}
