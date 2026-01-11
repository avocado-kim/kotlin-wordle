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

        gameLogic(inputWord, answer)


        if (inputWord == answer) {
            println("good 시도횟수: ${currentCount}")
        } else {
            currentCount++
            println("bad 시도횟수: ${currentCount}")
        }
    }


}

fun gameLogic(inputWord: String, answer: String): List<String> {
    val inputWordChars = inputWord.toMutableList()
    val answerChars = answer.toMutableList()
    val emojiArray = MutableList(inputWordChars.size) { Color.GREY.colorBox }
    val usedChars = MutableList(inputWordChars.size) { false }
    for (i in inputWordChars.indices) {
        if (inputWordChars[i] == answerChars[i]) {
            emojiArray[i] = Color.GREEN.colorBox
            usedChars[i] = true
        } else {
            emojiArray[i] = Color.GREY.colorBox
        }
    }

    for (i in inputWordChars.indices) {
        if (emojiArray[i] == Color.GREEN.colorBox) {
            continue
        }
        for (j in answerChars.indices) {
            if (usedChars[j]) continue
            if (inputWordChars[i] == answerChars[j]) {
                emojiArray[i] = Color.YELLOW.colorBox
                usedChars[j] = true
                break
            }
        }
    }

    println(emojiArray)
    return emojiArray
}
