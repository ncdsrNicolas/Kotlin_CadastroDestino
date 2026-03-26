package br.edu.fatecpg.catalogoturistico

object DestinosRepository {
    private val destinos = mutableListOf<Destino>()

    fun addDestino(destino: Destino){
        destinos.add(destino)
    }

    fun getDestinos(): List<Destino> = destinos

    fun removeDestino(destino: Destino){
        destinos.remove(destino)
    }

    fun clear(){
        destinos.clear()
    }
}