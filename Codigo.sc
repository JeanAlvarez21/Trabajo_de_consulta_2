import akka.actor.{Actor, ActorSystem, Props}

// Definición de mensajes
case class Saludo(nombre: String)

// Definición de un actor
class SaludoActor extends Actor {
  def receive: Receive = {
    case Saludo(nombre) =>
      println(s"Hola, $nombre!")
  }
}

object ProgramaReactivo {
  def main(args: Array[String]): Unit = {
    // Creación del sistema de actores
    val system = ActorSystem("SistemaSaludo")

    // Creación de un actor
    val saludoActor = system.actorOf(Props(classOf[SaludoActor]), "SaludoActor")

    // Envío de un mensaje al actor
    print(saludoActor ! Saludo("Juan"))

    // Cierre del sistema de actores
    system.terminate()
  }
}
