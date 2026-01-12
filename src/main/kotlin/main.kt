fun main(args: Array<String>) {
    val start = Start()
    val resultView = ResultView()
    val wordleGame = WordleGame()
    val game = Game(wordleGame, resultView, InputView())
    val answer = start.findAnswer()
    game.run(answer);
}
