import org.scalatest.flatspec.AnyFlatSpec

class MastermindCodeBreakerTest extends AnyFlatSpec {
  val mind = new MastermindCodeBreaker()

  "Mastermind" must "score guess with no matches" in {
    assert(mind.breakCode(List(0,0,0,0), List(1,1,1,1)) === 0)
  }

  "Mastermind" must "score guess with one position match" in {
    assert(mind.breakCode(List(0,0,0,0), List(0,1,1,1)) === 1)
  }

  "Mastermind" must "score guess with two position matches " in {
    assert(mind.breakCode(List(0,0,0,0), List(0,1,1,0)) === 2)
    assert(mind.breakCode(List(0,0,0,0), List(1,0,1,0)) === 2)
    assert(mind.breakCode(List(0,0,0,0), List(0,1,0,1)) === 2)
  }

  "Mastermind" must "score guess with several position matches " in {
    assert(mind.breakCode(List(1,1,1,1), List(0,1,1,1)) === 3)
    assert(mind.breakCode(List(0,0,0,0), List(0,0,0,1)) === 3)
    assert(mind.breakCode(List(1,2,3,4), List(1,2,3,4)) === 4)
  }
}
