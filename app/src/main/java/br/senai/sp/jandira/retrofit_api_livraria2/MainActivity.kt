package br.senai.sp.jandira.retrofit_api_livraria2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.senai.sp.jandira.retrofit_api_livraria2.R.id.txtTitulo
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declarando e recuperando os objetos de view
        val txtTitulo = findViewById<EditText>(txtTitulo)
        val txtPreco = findViewById<EditText>(R.id.txtPreco)
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        val txtDescricao = findViewById<EditText>(R.id.txtLivroDescricao)
        val bntCadastrar = findViewById<Button>(R.id.btnCadastrarLivro)

        bntCadastrar.setOnClickListener {

//            Entrada dos dados de livro
            val titulo = txtTitulo.text.toString()
            val preco = txtPreco.text.toString()
            val categoria = txtCategoria.text.toString()
            val descricao = txtDescricao.text.toString()

//            Montagem do corpo json dos dados de livro
            val body = JsonObject().apply {
                addProperty("titulo", titulo)
                addProperty("preco", preco)
                addProperty("categoria", categoria)
                addProperty("descricao", descricao)

            }

//            Log.e("BODY-JSON", body.toString())

            val intent = Intent(
                this,CadastroLivroImagem::class.java
            ).apply{
                putExtra("bodyJSON",body.toString())
            }

            startActivity(intent)
        }
    }
}