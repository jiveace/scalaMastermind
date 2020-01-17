class MastermindCodeBreaker {

  def breakCode(code: List[Int], guess: List[Int]): (Int, Int) = {
    val p = positionalMatches(code, guess)
    val v = valueMatches(code, guess)
    (p, v - p)
  }

  private def valueMatches(code: List[Int], guess: List[Int]) = {
    guess.count(x => code.toSet.contains(x))
  }

  private def positionalMatches(code: List[Int], guess: List[Int]) = {
    code.zip(guess).count(x => x._1 == x._2)
  }
}
