import org.scalatest.flatspec.AnyFlatSpec

class MastermindCodeBreakerTest extends AnyFlatSpec {

  "guessToNumber" must "translate base 6 numbers to decimal" in {
    val mind = new MasterMindCodeBreaker()
    assert(mind.guessToNumber(List(0,0,0,0)) === 0)
    assert(mind.guessToNumber(List(0,0,0,1)) === 1)
    assert(mind.guessToNumber(List(0,0,1,0)) === 6)
    assert(mind.guessToNumber(List(0,0,1,1)) === 7)
    assert(mind.guessToNumber(List(0,1,1,1)) === 43)
    assert(mind.guessToNumber(List(1,1,1,1)) === 259)
    assert(mind.guessToNumber(List(5,5,5,5)) === 1295)
    assert(mind.guessToNumber(List(5,5,4,1,5,5)) === 46295)
  }
}
