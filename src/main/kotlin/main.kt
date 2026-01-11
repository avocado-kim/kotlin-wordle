import java.io.FileInputStream
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

fun main(args: Array<String>) {
    val words = FileInputStream("/Users/taehyeongban/Desktop/Project/kotlin-wordle/src/main/resources/words.txt")
        .bufferedReader()
        .readLines()
    val startDate = LocalDate.of(2021,6,19)
    val daySinceStart = ChronoUnit.DAYS.between(startDate, LocalDate.now())
    val index = (daySinceStart % words.size).toInt()
    val answer = words[index]
    println(answer)
    val maxCount = 6
    var currentCount = 0
    while (currentCount < maxCount) {
        val line = readLine()!!.trim()
        if (line.length != 5) {
            println("5글자를 입력해주세요")
            continue
        }
        if (line == answer) {
            println("good 시도횟수: ${currentCount}")
        } else {
            currentCount++
            println("bad 시도횟수: ${currentCount}")
        }
    }


}
