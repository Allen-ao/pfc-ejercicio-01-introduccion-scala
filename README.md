# Ejercicio 1 — Primer contacto con Scala, Gradle y las pruebas

Fundamentos de Programación Funcional y Concurrente
Escuela de Ingeniería de Sistemas y Computación, Universidad del Valle
Carlos Andrés Delgado Saavedra

El objetivo de esta sesión no es la geometría. Es que salga de la clase con
el entorno funcionando, entendiendo cómo está organizado un proyecto de
Gradle y cómo las pruebas le dicen si su código sirve.

## Cómo está organizado el proyecto

```
app/src/main/scala/geometria/    el código que usted escribe
    App.scala                    programa de arranque
    Geometria.scala              aquí van los cuatro puntos

app/src/test/scala/geometria/    las pruebas, que no se modifican
    AppSuite.scala               comprueba que el entorno quedó bien
    TestDistancia.scala          punto 1
    TestPerimetro.scala          punto 2
    TestArea.scala               punto 3
    TestClasificar.scala         punto 4
```

La separación entre `main` y `test` es la convención de Gradle y la va a
encontrar igual en todos los ejercicios del semestre. Su código va en
`main`; las pruebas viven aparte y usted no las toca.

## Cómo se ejecuta

```bash
./gradlew run     # corre el programa
./gradlew test    # corre las pruebas
```

La primera vez se demora: Gradle descarga el compilador de Scala y, si hace
falta, la versión de Java que necesita el proyecto. No hay que instalar nada
a mano.

Al terminar, `./gradlew test` deja un informe navegable en
`app/build/reports/tests/test/index.html`. Ábralo en el navegador cuando
quiera ver con detalle qué falló y por qué.

## El punto de partida

Al clonar, de las 20 pruebas hay 19 en rojo y una en verde. La verde es
`AppSuite`, y estar en verde significa que el entorno quedó bien instalado.
Las otras 19 están en rojo porque las cuatro funciones dicen `???`, que en
Scala significa justamente eso: sin implementar. Su trabajo es reemplazar
cada `???` y ver las pruebas ponerse en verde.

## Los cuatro puntos

Todo se resuelve dentro de `Geometria.scala`. Un triángulo se describe con
las coordenadas de sus tres vértices.

### Punto 1: distancia entre dos puntos

```scala
def distancia(x1: Double, y1: Double, x2: Double, y2: Double): Double
```

La distancia es la raíz cuadrada de `(x2-x1)² + (y2-y1)²`. En Scala la raíz
cuadrada se escribe `math.sqrt(...)`.

| Entrada | Salida |
|---|---|
| `distancia(0, 0, 3, 4)` | `5.0` |
| `distancia(1, 1, 1, 1)` | `0.0` |
| `distancia(-2, -3, 1, 1)` | `5.0` |

### Punto 2: perímetro del triángulo

```scala
def perimetro(ax: Double, ay: Double,
              bx: Double, by: Double,
              cx: Double, cy: Double): Double
```

Es la suma de los tres lados. No vuelva a escribir la fórmula de la
distancia: llame a la función del punto 1. Esa es la idea que se practica
aquí, que una función se apoye en otra en vez de repetir el cálculo.

| Entrada | Salida |
|---|---|
| `perimetro(0, 0, 3, 0, 0, 4)` | `12.0` |

### Punto 3: área por la fórmula de Herón

```scala
def area(ax: Double, ay: Double,
         bx: Double, by: Double,
         cx: Double, cy: Double): Double
```

Con `s` el semiperímetro, es decir la mitad del perímetro, y `ab`, `bc` y
`ca` los tres lados:

```
area = raíz cuadrada de  s (s - ab) (s - bc) (s - ca)
```

| Entrada | Salida |
|---|---|
| `area(0, 0, 3, 0, 0, 4)` | `6.0` |
| `area(0, 0, 4, 0, 2, 3)` | `6.0` |
| `area(0, 0, 1, 0, 2, 0)` | lanza `IllegalArgumentException` |

Tres puntos sobre una misma recta no forman un triángulo. En ese caso el
producto de adentro de la raíz da cero y la función debe fallar en vez de
retornar un número. Para eso está `require(condicion, "mensaje")`, que lanza
`IllegalArgumentException` cuando la condición es falsa.

### Punto 4: clasificación del triángulo

```scala
def clasificar(ax: Double, ay: Double,
               bx: Double, by: Double,
               cx: Double, cy: Double): String
```

Retorna exactamente una de estas tres palabras: `"equilatero"` si los tres
lados miden lo mismo, `"isosceles"` si exactamente dos miden lo mismo, y
`"escaleno"` si los tres son distintos.

| Entrada | Salida |
|---|---|
| `clasificar(0, 0, 3, 0, 0, 4)` | `"escaleno"` |
| `clasificar(0, 0, 4, 0, 2, 3)` | `"isosceles"` |

Hay una trampa aquí, y está puesta a propósito. Dos lados calculados con
raíces cuadradas casi nunca dan exactamente iguales, así que comparar con
`==` falla incluso cuando el triángulo sí es equilátero. Compare la
diferencia contra una tolerancia pequeña. Las pruebas hacen lo mismo, y por
eso comparan con `math.abs(a - b) < epsilon` en vez de con `==`.

## Reglas del curso

En este curso no se usa `var`, ni `while`, ni `return`, ni ningún estado que
cambie. Todo se resuelve con `val`, que liga un nombre a un valor que ya no
se modifica, y con llamados a funciones.

## Cómo se entrega

1. Presione **Fork** en este repositorio.
2. En su fork, entre a la pestaña **Actions** y confirme que las habilita.
   GitHub las deja apagadas en los forks hasta que el dueño lo autoriza, y
   sin eso no ve el resultado de las pruebas.
3. Clone su fork, resuelva, y haga commit y push a `main`.
4. Copie la URL de su fork y el hash del último commit.
5. Péguelos en la tarea de la sesión en el campus virtual, antes de que
   termine la clase.

La calificación se hace sobre el commit que usted reporte, no sobre lo que
esté en el fork después.

## Cómo se califica

| Nota | Criterio |
|---|---|
| 5.0 | Las 20 pruebas pasan y el código respeta las reglas del curso |
| 4.0 | Compila y pasa la mayoría; falla algún caso borde o queda un punto sin terminar |
| 3.0 | Compila y hay avance verificable: al menos un punto resuelto |
| 0.0 | No entrega, o el fork está intacto, o no compila |

El uso de `var`, `while`, `return` o estado mutable deja la nota en 3.0 como
máximo, aunque todas las pruebas pasen.
