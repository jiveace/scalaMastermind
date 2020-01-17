import org.scalatest.flatspec.AnyFlatSpec

class MastermindCodeBreakerTest extends AnyFlatSpec {
  val mind = new MastermindCodeBreaker()

  "Mastermind" must "score guess with no matches" in {
    assert(mind.breakCode(List(0, 0, 0, 0), List(1, 1, 1, 1)) === (0, 0))
  }

  "Mastermind" must "score guess with one position match" in {
    assert(mind.breakCode(List(0, 0, 0, 0), List(0, 1, 1, 1)) === (1, 0))
  }

  "Mastermind" must "score guess with two position matches " in {
    assert(mind.breakCode(List(0, 0, 0, 0), List(0, 1, 1, 0)) === (2, 0))
    assert(mind.breakCode(List(0, 0, 0, 0), List(1, 0, 1, 0)) === (2, 0))
    assert(mind.breakCode(List(0, 0, 0, 0), List(0, 1, 0, 1)) === (2, 0))
  }

  "Mastermind" must "score guess with several position matches " in {
    assert(mind.breakCode(List(1, 1, 1, 1), List(0, 1, 1, 1)) === (3, 0))
    assert(mind.breakCode(List(0, 0, 0, 0), List(0, 0, 0, 1)) === (3, 0))
    assert(mind.breakCode(List(1, 2, 3, 4), List(1, 2, 3, 4)) === (4, 0))
  }

  "Mastermind" must "score guess with value matches " in {
    assert(mind.breakCode(List(1, 2, 3, 4), List(2, 0, 0, 0)) === (0, 1))
    assert(mind.breakCode(List(1, 2, 3, 4), List(2, 3, 0, 0)) === (0, 2))
    assert(mind.breakCode(List(1, 2, 3, 4), List(2, 4, 1, 0)) === (0, 3))
    assert(mind.breakCode(List(1, 2, 3, 4), List(4, 3, 2, 1)) === (0, 4))
    assert(mind.breakCode(List(1, 2, 3, 4), List(2, 3, 4, 1)) === (0, 4))
  }

  "Mastermind" must "score guess with some position and some value matches" in {
    assert(mind.breakCode(List(1, 2, 3, 4), List(1,2,4,3)) === (2, 2))
    assert(mind.breakCode(List(1, 2, 3, 4), List(3,3,3,4)) === (2, 0))
  }
}