import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextLine().toInt()
    var flag = false
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 1..num) {
        val newNum = scanner.nextLine().toInt()
        mutList.add(newNum)
    }
    val list = scanner.nextLine().split(" ")
    val p = list[0].toInt()
    val m = list[1].toInt()
    for (index in 0 until mutList.size - 1) {
        if (mutList[index] == p || mutList[index] == m) {
            if (mutList[index] == p) {
                if (mutList[index + 1] == m) {
                    flag = true
                    break
                }
            } else {
                if (mutList[index + 1] == p) {
                    flag = true
                    break
                }
            }

        }
    }
    if (!flag) {
        println("YES")
    } else {
        println("NO")
    }

    val number: Int = readln().toInt()
    println(number)

    val throwException = throw Exception()

    val blankException = Exception()

    val anException = Exception("New exception")
}