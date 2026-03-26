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
import java.time.format.TextStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtUsuario = findViewById<EditText>(R.id.edt_usuario)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)
        val btnLogin = findViewById<Button>(R.id.btn_entrar)

        btnLogin.setOnClickListener {
            val usuario = edtUsuario.text.toString()
            val senha = edtSenha.text.toString()

            if (usuario == "admin" && senha == "1234"){
                val intent = Intent(this, CadastroDestinoActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Dados Incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}