class MastermindCodeBreaker {

  def breakCode(code: List[Int], guess: List[Int]): Int =
    code.zip(guess).filter(x => x._1 == x._2).length
}
