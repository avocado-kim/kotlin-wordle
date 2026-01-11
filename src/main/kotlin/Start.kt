import java.io.FileInputStream
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Start {

    fun findAnswer() :GameString {
        val words = FileInputStream("/Users/taehyeongban/Desktop/Project/kotlin-wordle/src/main/resources/words.txt")
            .bufferedReader()
            .readLines()
        val startDate = LocalDate.of(2021,6,19)
        val daySinceStart = ChronoUnit.DAYS.between(startDate, LocalDate.now())
        val index = (daySinceStart % words.size).toInt()

        return GameString(words[index])
    }
}
