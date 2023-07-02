package exchange

import java.io.IOException
import java.lang.ArithmeticException

fun suspiciousFunction(param: Int) {
    try {
        when (param) {
            0 -> throw Exception("Some exceptions?")
            1 -> throw ArithmeticException("Division by zero")
            2 -> throw Exception("An exception occurred here")
            3 -> throw IOException()
        }
    } catch (e: IOException) {
        println("The IOException occurred")
    } catch (e: Exception) {
        println(e.message)

    } finally {
        println("Handling completed successfully!")
    }



}

fun handleException(data: Int) {

    suspiciousFunction(0)

}