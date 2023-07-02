package exchange

fun main() {


    println(Runtime.getRuntime().totalMemory())
    println(Runtime.getRuntime().freeMemory())

    val argument = readLine()!!
    var a = 4
    var b = 12
    var c = a + b
    b = c
    println(check(argument)?.length ?: 0)
    println(reverse(654))
    println(getLength(argument))
    println(Runtime.getRuntime().totalMemory())
    println(Runtime.getRuntime().freeMemory())


    Runtime.getRuntime().gc()
    println(Runtime.getRuntime().totalMemory())
    println(Runtime.getRuntime().freeMemory())

    println('a'.code)
    var i = 0
    while (i < 5) {
        println(++i)
        i++
    }


}

// do not change function below

fun check(name: String): String? {
    return if (name.length > 5) null else name
}

fun reverse(input: Int?): Int {
    return input?.toString()?.reversed()?.toInt() ?: -1
}

fun getLength(input: String?): Int {
    return input?.length ?: -1
}