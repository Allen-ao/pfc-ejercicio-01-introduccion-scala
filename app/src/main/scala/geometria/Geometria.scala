package geometria

/**
 * Operaciones sobre triángulos en el plano.
 *
 * Un triángulo se describe con las coordenadas de sus tres vértices:
 * (ax, ay), (bx, by) y (cx, cy).
 */
class Geometria {

  def distancia(x1: Double, y1: Double, x2: Double, y2: Double): Double = {
    math.sqrt(
      (x2 - x1) * (x2 - x1) +
      (y2 - y1) * (y2 - y1)
    )
  }

  def perimetro(ax: Double, ay: Double,
                bx: Double, by: Double,
                cx: Double, cy: Double): Double = {
    distancia(ax, ay, bx, by) +
    distancia(bx, by, cx, cy) +
    distancia(cx, cy, ax, ay)
  }

  def area(ax: Double, ay: Double,
           bx: Double, by: Double,
           cx: Double, cy: Double): Double = {

    val ab = distancia(ax, ay, bx, by)
    val bc = distancia(bx, by, cx, cy)
    val ca = distancia(cx, cy, ax, ay)

    val s = (ab + bc + ca) / 2

    require(
      s > 0 && s - ab > 0 && s - bc > 0 && s - ca > 0,
      "Los puntos no forman un triangulo"
    )

    math.sqrt(s * (s - ab) * (s - bc) * (s - ca))
  }

  def clasificar(ax: Double, ay: Double,
                 bx: Double, by: Double,
                 cx: Double, cy: Double): String = {

    val ab = distancia(ax, ay, bx, by)
    val bc = distancia(bx, by, cx, cy)
    val ca = distancia(cx, cy, ax, ay)

    val epsilon = 1e-9

    if (math.abs(ab - bc) < epsilon &&
        math.abs(bc - ca) < epsilon)
      "equilatero"
    else if (math.abs(ab - bc) < epsilon ||
             math.abs(bc - ca) < epsilon ||
             math.abs(ab - ca) < epsilon)
      "isosceles"
    else
      "escaleno"
  }
}
