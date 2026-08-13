package geometria

/**
 * Programa de arranque. Se ejecuta con:  ./gradlew run
 *
 * Sirve para comprobar que el proyecto compila y corre antes de escribir
 * nada. La evaluación del ejercicio se hace con las pruebas.
 */
object App {

  def saludo(): String = "El proyecto compila y corre. Ahora ejecute ./gradlew test"

  def main(args: Array[String]): Unit = {
    println(saludo())
  }
}
