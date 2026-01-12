package domain

import view.InputView
import view.ResultView

class RetryableGame(val wordleGame: WordleGame, val resultView: ResultView, val input: InputView) {
    fun run(answer: GameString) {
        var currentCount = 0
        while (currentCount < Constant.MAX_GAME_TRY_COUNT) {
            val input = input.getInput()

            val gameResult = wordleGame.logic(input, answer)

            resultView.printResult(gameResult)
            if (gameResult.isSuccess) {
                break
            }
        }
    }
}