package br.senai.sp.jandira.retrofit_api_livraria2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
        }
    }
}