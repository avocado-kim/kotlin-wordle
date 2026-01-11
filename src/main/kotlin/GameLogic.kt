class GameLogic(val resultView: ResultView, val input: InputView) {

    fun run(answer: GameString) {
        var currentCount = 0
        while (currentCount < Constant.MAX_GAME_TRY_COUNT) {
            val input = input.getInput()

            val gameResult = gameLogic(input, answer)

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
}
