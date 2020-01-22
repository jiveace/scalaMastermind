package mm

import org.mockito.{MockitoSugar}
import org.scalatest.flatspec.AnyFlatSpec

class AutoPlayTest extends AnyFlatSpec with MockitoSugar {
  val mockMaker = mock[MastermindCodeMaker]
  val mockBreaker = mock[MasterMindCodeBreaker]
  val mockCodeGenerator = mock[CodeGenerator]

  val autoPlay = new AutoPlay(mockMaker, mockBreaker, mockCodeGenerator)

  "AutoPlay" must "if initial guess is correct, return 1" in {
    when(mockCodeGenerator.generate) thenReturn List(0, 0, 0, 0)
    when(mockMaker.score(List(0, 0, 0, 0), List(0, 0, 0, 0))) thenReturn ((4, 0))
    when(mockBreaker.breakCode(null, List())) thenReturn List(0, 0, 0, 0)

    assert(autoPlay.play() === 1)
  }

  "AutoPlay" must "take two tries if code is [0,0,0,1]" in {
    when(mockCodeGenerator.generate) thenReturn List(0, 0, 0, 1)
    val autoPlay = new AutoPlay(new MastermindCodeMaker, new MasterMindCodeBreaker, mockCodeGenerator)

    assert(autoPlay.play() === 2)
  }

  "AutoPlay" must "take three tries if code is [0,0,1,0]" in {
    when(mockCodeGenerator.generate) thenReturn List(0, 0, 1, 0)
    val autoPlay = new AutoPlay(new MastermindCodeMaker, new MasterMindCodeBreaker, mockCodeGenerator)

    assert(autoPlay.play() === 3)
  }
}