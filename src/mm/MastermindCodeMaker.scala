package mm

class MastermindCodeMaker {

  def score(code: List[Int], guess: List[Int]): (Int, Int) = {
    val p = positionalMatches(code, guess)
    val v = valueMatches(code, guess)
    val oc = overcount(code, guess)
    (p, v - p - oc.getOrElse(0))
  }

  private def countOf(target: Int, values: List[Int]) =
    values.count(_ == target)

  private def overcount(code: List[Int], guess: List[Int]) = {
    val codeSet = code.toSet
    codeSet.map(x => countOf(x, guess) - countOf(x, code)).filter(_ > 0).reduceOption(_ + _)
  }

  private def valueMatches(code: List[Int], guess: List[Int]) = {
    guess.count(x => code.contains(x))
  }

  private def positionalMatches(code: List[Int], guess: List[Int]) = {
    code.zip(guess).count(x => x._1 == x._2)
  }
}
