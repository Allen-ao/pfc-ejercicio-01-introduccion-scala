package geometria

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

/**
 * Esta prueba pasa desde el primer momento, sin escribir nada.
 * Si está en verde, el entorno quedó bien instalado.
 */
@RunWith(classOf[JUnitRunner])
class AppSuite extends AnyFunSuite {
  test("El proyecto esta bien configurado") {
    assert(App.saludo().nonEmpty)
  }
}
