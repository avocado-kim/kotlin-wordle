fun main(args: Array<String>) {
    val start = Start()
    val resultView = ResultView()
    val game = GameLogic(resultView, InputView())
    val answer = start.findAnswer()
    game.run(answer);
}
