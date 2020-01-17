class MastermindCodeBreaker {

  def breakCode(code: List[Int], guess: List[Int]): (Int, Int) = {
    val posMatches = code.zip(guess).count(x => x._1 == x._2)
    (posMatches, 0)
  }
}
