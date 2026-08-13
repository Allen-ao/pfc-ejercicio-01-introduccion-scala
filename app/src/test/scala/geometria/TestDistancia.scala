package geometria

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestDistancia extends AnyFunSuite {

  val obj: Geometria = new Geometria()

  // Los números con decimales no se comparan con ==, porque el resultado
  // de una raíz cuadrada casi nunca es exacto. Se compara la diferencia
  // contra una tolerancia pequeña.
  val epsilon: Double = 1e-6

  test("La distancia de (0,0) a (3,4) es 5") {
    assert(math.abs(obj.distancia(0, 0, 3, 4) - 5.0) < epsilon)
  }

  test("La distancia de un punto a si mismo es 0") {
    assert(math.abs(obj.distancia(1, 1, 1, 1) - 0.0) < epsilon)
  }

  test("La distancia no depende del orden de los puntos") {
    assert(math.abs(obj.distancia(3, 4, 0, 0) - obj.distancia(0, 0, 3, 4)) < epsilon)
  }

  test("La distancia funciona con coordenadas negativas") {
    assert(math.abs(obj.distancia(-2, -3, 1, 1) - 5.0) < epsilon)
  }

  test("La distancia de (0,0) a (1,1) es la raiz de 2") {
    assert(math.abs(obj.distancia(0, 0, 1, 1) - math.sqrt(2)) < epsilon)
  }
}
