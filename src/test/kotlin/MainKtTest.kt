import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test

 class MainKtTest {

@Test
 fun 정답을_맞추면_모두_초록색이다() {
  val input = "under"
  val answer = "under"
  val expected = listOf(Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox,Color.GREEN.colorBox)

  val result = gameLogic(input, answer)

  Assertions.assertThat(result).isEqualTo(expected)
 }

  @Test
  fun 입력문자열이_answer의_글자에_포함되어있으면_yellow() {
   val input = "uooon"
   val answer = "under"
   val expected = listOf(Color.GREEN.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.YELLOW.colorBox)

   val result = gameLogic(input, answer)

   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun 정답글자를_중복으로_입력할_경우_grey() {
   val input = "uuooo"
   val answer = "under"
   val expected = listOf(Color.GREEN.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox)

   val result = gameLogic(input, answer)

   Assertions.assertThat(result).isEqualTo(expected)
  }

  @Test
  fun 오류케이스_추가() {
   val input = "uuuuo"
   val answer = "undeu"
   val expected = listOf(Color.GREEN.colorBox, Color.YELLOW.colorBox, Color.GREY.colorBox, Color.GREY.colorBox, Color.GREY.colorBox)

   val result = gameLogic(input, answer)

   Assertions.assertThat(result).isEqualTo(expected)
  }
}
