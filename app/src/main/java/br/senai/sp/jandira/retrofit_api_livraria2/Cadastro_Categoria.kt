package br.senai.sp.jandira.retrofit_api_livraria2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class Cadastro_Categoria : AppCompatActivity() {

    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)


//        Conecta apiservice Com a API rest através da classe RetrofitHelper
//        e seu método getInstance
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

//        Recupera o componente gráfico de edittext
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)

//        trata a ação de clique ou toque no botao cadastrar
        findViewById<Button>(R.id.btnCadastrarCategoria).setOnClickListener {

//            Recuperar o dado digitado pelo usuario
              val nomeCategoria = txtCategoria.text
//            Enviar a requisição de cadastro para a api
              createCategory(nomeCategoria.toString())
        }
    } // fim do metodo onCreate

//    implementação do metodo creteCategory
        private fun createCategory(nome_categoria: String){
            lifecycleScope.launch {
//                montagem do corpo de dados em json
                val body = JsonObject().apply {
                    addProperty("nome_categoria", nome_categoria)
                }

//                envio da requisição de cadastro de categoria
                val result = apiService.createCategory(body)

//                verificando a resposta da requisição
                if (result.isSuccessful){
                    val msg = result.body()?.get("mensagemStatus")
                    Log.e("CREATE-CATEGORY", "STATUS: ${msg}")
                } else {
                    Log.e("CREATE-CATEGORY", "ERROR: ${result.message()}")
                }

            }
        }
} // fim da classe