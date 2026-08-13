package geometria

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestPerimetro extends AnyFunSuite {

  val obj: Geometria = new Geometria()
  val epsilon: Double = 1e-6

  test("El perimetro del triangulo (0,0) (3,0) (0,4) es 12") {
    assert(math.abs(obj.perimetro(0, 0, 3, 0, 0, 4) - 12.0) < epsilon)
  }

  test("El perimetro de un triangulo equilatero de lado 1 es 3") {
    val altura = math.sqrt(3) / 2
    assert(math.abs(obj.perimetro(0, 0, 1, 0, 0.5, altura) - 3.0) < epsilon)
  }

  test("El perimetro del triangulo (0,0) (4,0) (2,3) es 4 mas dos veces la raiz de 13") {
    val esperado = 4 + 2 * math.sqrt(13)
    assert(math.abs(obj.perimetro(0, 0, 4, 0, 2, 3) - esperado) < epsilon)
  }

  test("El perimetro no cambia si se rotan los vertices") {
    val uno = obj.perimetro(0, 0, 3, 0, 0, 4)
    val dos = obj.perimetro(3, 0, 0, 4, 0, 0)
    assert(math.abs(uno - dos) < epsilon)
  }
}
