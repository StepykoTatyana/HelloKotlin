import java.lang.Math.pow
import java.util.Scanner
import kotlin.math.pow

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    println(square(a))
}

fun square(a: Int): Int {
    return a.toDouble().pow(2.0).toInt()
}