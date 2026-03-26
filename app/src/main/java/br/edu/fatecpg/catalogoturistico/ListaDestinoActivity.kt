package br.edu.fatecpg.catalogoturistico

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaDestinoActivity : AppCompatActivity() {
    private lateinit var adapter: DestinosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_destino)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvDestinos = findViewById<RecyclerView>(R.id.rvDestinos)
        rvDestinos.layoutManager = LinearLayoutManager(this)

        adapter = DestinosAdapter(
            DestinosRepository.getDestinos().toMutableList(),
            onExplorar = { destino ->
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("referencia", destino.referencia)
                startActivity(intent)
            },
            onExcluir = { destino, pos ->
                DestinosRepository.removeDestino(destino)
                adapter.removeAt(pos)
            }
        )

        rvDestinos.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(DestinosRepository.getDestinos())
    }
}