class Nodo (val pregunta: String, val respuesta: String? = null){
    var izquierdo: Nodo? = null
    var derecho: Nodo? = null
}

class ArbooBinarioRPG{
     var raiz: Nodo

     init {
        val mago = Nodo("", " Eres un Mago")
        val arquero = Nodo("", " Eres un Arquero")
        val guerrero = Nodo("", " Eres un Guerrero")
        val asesino = Nodo("", " Eres un Asesino")

        val magia = Nodo("Prefieres usar magia")
        magia.izquierdo = mago
        magia.derecho = arquero

        val armas = Nodo("Prefieres usar armas?")
        armas.izquierdo = guerrero
        armas.derecho = asesino

        raiz = Nodo("prefieres combate a diastancia")
        raiz.izquierdo = magia
        raiz.derecho = armas
     }
}

fun juego(nodo: Nodo?){
    if(nodo == null) return 

    if (nodo.respuesta != null){
        println(nodo.respuesta)
        return
    }

 println(nodo.pregunta + "(si/no)")
 val respuesta = readLine()?.trim()?.lowercase()

 if(respuesta == "si"){
     juego(nodo.izquierdo)
  } else {
       juego( nodo.derecho)
  }
}

fun main() {
    val jugador = ArbooBinarioRPG()
    println("Bienvenido al test de clases de RPG!")
    juego(jugador.raiz)
}