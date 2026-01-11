class ResultView {

    fun printResult(gameResult: GameResult) {
        if (gameResult.isSuccess) {
            println(gameResult.emojiArray)
            println("성공입니다!")
        } else {
            println(gameResult.emojiArray)
        }
    }
}
