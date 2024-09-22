package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import androidx.lifecycle.ViewModel
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel: ViewModel(){
    //Estados de la pantalla
    //Eventos
    //Estados Componentes

    fun singIn(email: String, password: String){
        GlobalScope.launch(Dispatchers.Main) {

             val response = withContext(Dispatchers.IO) {
                 Api.build().singIn(
                     LoginRequest(
                         email = "geovanny0401@gmail.com",
                         password = "123"
                     )
                 )
             }

             if (response.isSuccessful) {
                 val data = response.body()
                 data?.let {
                     println(it.data.email)
                 }
             }
         }
    }
}