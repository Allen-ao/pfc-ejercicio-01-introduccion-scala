package geometria

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestArea extends AnyFunSuite {

  val obj: Geometria = new Geometria()
  val epsilon: Double = 1e-6

  test("El area del triangulo rectangulo (0,0) (3,0) (0,4) es 6") {
    assert(math.abs(obj.area(0, 0, 3, 0, 0, 4) - 6.0) < epsilon)
  }

  test("El area del triangulo (0,0) (4,0) (2,3) es 6") {
    assert(math.abs(obj.area(0, 0, 4, 0, 2, 3) - 6.0) < epsilon)
  }

  test("El area de un triangulo equilatero de lado 1 es la raiz de 3 sobre 4") {
    val altura = math.sqrt(3) / 2
    val esperado = math.sqrt(3) / 4
    assert(math.abs(obj.area(0, 0, 1, 0, 0.5, altura) - esperado) < epsilon)
  }

  test("Tres puntos sobre una misma recta no forman triangulo") {
    assertThrows[IllegalArgumentException] {
      obj.area(0, 0, 1, 0, 2, 0)
    }
  }

  test("Tres puntos iguales no forman triangulo") {
    assertThrows[IllegalArgumentException] {
      obj.area(2, 2, 2, 2, 2, 2)
    }
  }
}
