class MastermindCodeBreaker {

  def breakCode(code: List[Int], guess: List[Int]): List[String] =
    code.zip(guess).filter(x => x._1 == x._2).map(_ => "P")
}
