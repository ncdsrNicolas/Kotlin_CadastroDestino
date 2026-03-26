package br.edu.fatecpg.catalogoturistico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinosAdapter(
    private val destinos: MutableList<Destino>,
    private val onExplorar: (Destino) -> Unit,
    private val onExcluir: (Destino, Int) -> Unit
) : RecyclerView.Adapter<DestinosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvNome: TextView = view.findViewById(R.id.txv_nome_destino)
        val txvRegiao: TextView = view.findViewById(R.id.txv_regiao)
        val btnExplorar: Button = view.findViewById(R.id.btn_explorar)
        val btnExcluir: Button = view.findViewById(R.id.btn_excluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destino, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = destinos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destino = destinos[position]
        holder.txvNome.text = destino.nome
        holder.txvRegiao.text = destino.regiao

        holder.btnExplorar.setOnClickListener { onExplorar(destino) }
        holder.btnExcluir.setOnClickListener {
            onExcluir(destino, position)
        }
    }

    fun removeAt(pos: Int) {
        destinos.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun updateList(newList: List<Destino>) {
        destinos.clear()
        destinos.addAll(newList)
        notifyDataSetChanged()
    }
}
