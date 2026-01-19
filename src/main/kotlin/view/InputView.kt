package view

import domain.GameString

class InputView {

    fun getInput(): GameString {
        while (true) {
            val inputWord = readLine()!!.trim()
            try {
                return GameString(inputWord)
            } catch (exception: Exception) {
                println(exception.message)
                println("정답을 입력해 주세요.")
            }
        }
    }
}