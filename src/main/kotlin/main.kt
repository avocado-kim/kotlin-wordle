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

    val resultView = ResultView()

    println(answer)
    var currentCount = 0

    while (currentCount < Constant.MAX_GAME_TRY_COUNT) {
        val input = getInput()

        val gameResult = gameLogic(input, GameString(answer))

        resultView.printResult(gameResult)
        if (gameResult.isSuccess) {
            break
        }
    }


}

fun gameLogic(inputWord: GameString, answer: GameString): GameResult {
    val inputWordChars = inputWord.value.toMutableList()
    val answerChars = answer.value.toMutableList()
    val emojiArray = MutableList(inputWordChars.size) { Color.GREY.colorBox }
    val usedChars = MutableList(inputWordChars.size) { false }
    var greenCount = 0
    for (i in inputWordChars.indices) {
        if (inputWordChars[i] == answerChars[i]) {
            emojiArray[i] = Color.GREEN.colorBox
            usedChars[i] = true
            greenCount++
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

    return GameResult(emojiArray, greenCount == 5)
}

fun getInput(): GameString {
    while(true) {
        val inputWord = readLine()!!.trim()
        try {
            return GameString(inputWord)
        } catch (exception: Exception) {
            println(exception.message)
            continue
        }
    }
}
