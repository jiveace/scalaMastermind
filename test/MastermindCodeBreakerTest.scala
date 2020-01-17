import org.scalatest.flatspec.AnyFlatSpec

class MastermindCodeBreakerTest extends AnyFlatSpec {

  "Mastermind" must "score guess with no matches" in {
    val mind = new MastermindCodeBreaker()
    assert(mind.breakCode(List(0,0,0,0), List(1,1,1,1)) === List())
  }

  "Mastermind" must "score guess with one position match" in {
    val mind = new MastermindCodeBreaker()
    assert(mind.breakCode(List(0,0,0,0), List(0,1,1,1)) === List("P"))
  }

  "Mastermind" must "score guess with two position matches " in {
    val mind = new MastermindCodeBreaker()
    assert(mind.breakCode(List(0,0,0,0), List(0,1,1,0)) === List("P", "P"))
  }
}
