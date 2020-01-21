package mm

import org.scalatest.flatspec.AnyFlatSpec

class MastermindCodeBreakerTest extends AnyFlatSpec {
  val mind = new MasterMindCodeBreaker()

  "guessToNumber" must "translate base 6 numbers to decimal" in {
    assert(mind.guessToNumber(List(0, 0, 0, 0)) === 0)
    assert(mind.guessToNumber(List(0, 0, 0, 1)) === 1)
    assert(mind.guessToNumber(List(0, 0, 1, 0)) === 6)
    assert(mind.guessToNumber(List(0, 0, 1, 1)) === 7)
    assert(mind.guessToNumber(List(0, 1, 1, 1)) === 43)
    assert(mind.guessToNumber(List(1, 1, 1, 1)) === 259)
    assert(mind.guessToNumber(List(5, 5, 5, 5)) === 1295)
    assert(mind.guessToNumber(List(5, 5, 4, 1, 5, 5)) === 46295)
  }

  "guessToNumber" must "translate decimal to base 6 number" in {
    assert(mind.numberToGuess(0) === List(0, 0, 0, 0))
    assert(mind.numberToGuess(1) === List(0, 0, 0, 1))
    assert(mind.numberToGuess(6) === List(0, 0, 1, 0))
    assert(mind.numberToGuess(7) === List(0, 0, 1, 1))
    assert(mind.numberToGuess(43) === List(0, 1, 1, 1))
    assert(mind.numberToGuess(259) === List(1, 1, 1, 1))
    assert(mind.numberToGuess(1295) === List(5, 5, 5, 5))
  }

  "incrementGuess" must "increment a guess to represent the next base 6 number" in {
    assert(mind.incrementGuess(List(0, 0, 0, 0)) === List(0, 0, 0, 1))
    assert(mind.incrementGuess(List(0, 0, 0, 5)) === List(0, 0, 1, 0))
    assert(mind.incrementGuess(List(0, 0, 5, 5)) === List(0, 1, 0, 0))
    assert(mind.incrementGuess(List(0, 5, 5, 5)) === List(1, 0, 0, 0))
    assert(mind.incrementGuess(List(5, 5, 5, 5)) === List(0, 0, 0, 0))
  }

  "breakCode" must "initialise with a base 6 0" in {
    assert(mind.breakCode(null,
      List()) === List(0, 0, 0, 0))
  }

  "breakCode" should "have a first step for code [1,2,3,4]" in {
    assert(mind.breakCode(List(0, 0, 0, 0),
      (List((List(0, 0, 0, 0), (0, 0))))) === List(1, 1, 1, 1))
  }

  "breakCode" should "have a first step for code [0,0,0,1]" in {
    assert(mind.breakCode(List(0, 0, 0, 0),
      (List((List(0, 0, 0, 0), (3, 0))))) === List(0, 0, 0, 1))
  }

  "breakCode" should "have a first step for code [0,0,1,0]" in {
    assert(mind.breakCode(List(0, 0, 0, 1),
      (List((List(0, 0, 0, 1), (2, 2))))) === List(0, 0, 0, 1))
  }

}
