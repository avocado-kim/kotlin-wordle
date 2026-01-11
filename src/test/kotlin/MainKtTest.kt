import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test

 class MainKtTest {

@Test
 fun 정답을_맞추면_모두_초록색이다() {
  val input = GameString("under")
  val answer = GameString("under")
  val game = GameLogic(ResultView(), InputView())
  val expected = listOf(Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox)

  val result = game.gameLogic(input, answer).emojiArray

  Assertions.assertThat(result).isEqualTo(expected)
 }

  @Test
  fun 입력문자열이_answer의_글자에_포함되어있으면_yellow() {
   val input = GameString("uooon")
   val answer = GameString("under")
   val game = GameLogic(ResultView(), InputView())
   val expected = listOf(Color.GREEN.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.YELLOW.colorBox)

   val result = game.gameLogic(input, answer).emojiArray

   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun 정답글자를_중복으로_입력할_경우_grey() {
   val input = GameString("uuooo")
   val answer = GameString("under")
   val game = GameLogic(ResultView(), InputView())
   val expected = listOf(Color.GREEN.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox)

   val result = game.gameLogic(input, answer).emojiArray

   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun 오류케이스_추가() {
   val input = GameString("uuuuo")
   val answer = GameString("undeu")
   val game = GameLogic(ResultView(), InputView())
   val expected = listOf(Color.GREEN.colorBox, Color.YELLOW.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox)

   val result = game.gameLogic(input, answer).emojiArray
   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun `반복문 break 오류케이스 추가`() {
   val input = GameString("ououo")
   val answer = GameString("unueu")
   val game = GameLogic(ResultView(), InputView())
   val expected = listOf(Color.GREY.colorBox, Color.YELLOW.colorBox, Color.GREY.colorBox, Color.YELLOW.colorBox, Color.GREY.colorBox)

   val result = game.gameLogic(input, answer).emojiArray
   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun `반복문 break 오류케이스 추가2`() {
   val input = GameString("unueu")
   val answer = GameString("ououo")
   val game = GameLogic(ResultView(), InputView())
   val expected = listOf(Color.YELLOW.colorBox, Color.GREY.colorBox, Color.YELLOW.colorBox, Color.GREY.colorBox, Color.GREY.colorBox)

   val result = game.gameLogic(input, answer).emojiArray
   Assertions.assertThat(result).isEqualTo(expected)
  }
}
