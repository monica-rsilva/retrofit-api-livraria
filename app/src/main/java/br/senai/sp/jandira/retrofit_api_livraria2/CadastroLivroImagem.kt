package br.senai.sp.jandira.retrofit_api_livraria2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CadastroLivroImagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro_imagem)

//        Teste de recebimento do json

        val bodyJSON = intent.getStringExtra("bodyJSON")
        Log.e("TESTE-JSON",bodyJSON.toString())
    }
}