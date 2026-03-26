package br.edu.fatecpg.catalogoturistico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroDestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_destino)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvLista = findViewById<TextView>(R.id.txv_lista)

        txvLista.setOnClickListener {
            val intent = Intent(this, ListaDestinoActivity::class.java)
            startActivity(intent)
        }

        val edtNomeDestino = findViewById<EditText>(R.id.edt_nome_destino)
        val edtRegiao = findViewById<EditText>(R.id.edt_regiao)
        val edtReferencia = findViewById<EditText>(R.id.edt_referencia)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)

        btnSalvar.setOnClickListener {
            val destino = Destino(
                nome = edtNomeDestino.text.toString(),
                regiao = edtRegiao.text.toString(),
                referencia = edtReferencia.text.toString()
            )
            DestinosRepository.addDestino(destino)
            Toast.makeText(this, "Destino salvo!", Toast.LENGTH_SHORT).show()
        }
    }
}