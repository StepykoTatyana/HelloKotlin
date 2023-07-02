fun pepTalk(name: String): String {
    val array = name.split(" ").toTypedArray()
    val firstName = array[0]
    val secondName = array[1]
    return "Don't lose the towel, traveler $firstName $secondName!"
}
// do not change the function above

fun main() {
    val name = readLine()!!
    val advice: String = try {
        "Good luck!\n" + pepTalk(name)
    } catch (e: Exception) {
        "Good luck!\n" + "Don't lose the towel, nameless one."
    }
    print(advice)


    val answer: Int = try {
        readLine()!!.toInt()
    } catch (e: Exception) {
        42
    } finally {
        println("The Ex4.getAnswer is a number")
    }
    println(answer)
}