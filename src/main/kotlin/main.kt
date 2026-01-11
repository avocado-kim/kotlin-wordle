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
        val inputWord = readLine()!!.trim()
        if (inputWord.length != 5) {
            println("5글자를 입력해주세요")
            continue
        }

        val inputWordChars = inputWord.toMutableList()
        val answerChars = answer.toMutableList()
        val emojiArray = MutableList(inputWordChars.size) { Color.GREY.colorBox }
        for (i in inputWordChars.indices) {
            if (inputWordChars[i] == answerChars[i]) {
                emojiArray[i] = Color.GREEN.colorBox
            } else {
                emojiArray[i] = Color.GREY.colorBox
            }
        }

        for (i in emojiArray.indices) {
            if (emojiArray[i] == Color.GREY.colorBox
                && answer.contains(inputWordChars[i])) {
                emojiArray[i] = Color.YELLOW.colorBox
            }
        }

        println(emojiArray)

        if (inputWord == answer) {
            println("good 시도횟수: ${currentCount}")
        } else {
            currentCount++
            println("bad 시도횟수: ${currentCount}")
        }
    }


}
