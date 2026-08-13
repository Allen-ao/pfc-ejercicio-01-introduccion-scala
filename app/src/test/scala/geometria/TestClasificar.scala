package geometria

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestClasificar extends AnyFunSuite {

  val obj: Geometria = new Geometria()

  test("El triangulo (0,0) (3,0) (0,4) es escaleno") {
    assert(obj.clasificar(0, 0, 3, 0, 0, 4) == "escaleno")
  }

  test("El triangulo (0,0) (4,0) (2,3) es isosceles") {
    assert(obj.clasificar(0, 0, 4, 0, 2, 3) == "isosceles")
  }

  test("El triangulo de lado 1 con altura raiz de 3 sobre 2 es equilatero") {
    val altura = math.sqrt(3) / 2
    assert(obj.clasificar(0, 0, 1, 0, 0.5, altura) == "equilatero")
  }

  test("Un triangulo isosceles sigue siendolo si se rotan los vertices") {
    assert(obj.clasificar(2, 3, 0, 0, 4, 0) == "isosceles")
  }

  test("El triangulo (0,0) (5,0) (0,12) es escaleno") {
    assert(obj.clasificar(0, 0, 5, 0, 0, 12) == "escaleno")
  }
}
