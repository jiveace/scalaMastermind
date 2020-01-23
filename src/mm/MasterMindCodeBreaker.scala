package mm

class MasterMindCodeBreaker() {
  val mind = new MastermindCodeMaker

  def breakCodeSeq(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] = {
    if (lastGuess == null) List(0, 0, 0, 0)
    else nextGuess(lastGuess, history)
  }

  def breakCode3x2(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] =
    history.size match {
      case 0 => List(0, 0, 1, 1)
      case 1 => List(2, 2, 3, 3)
      case 2 => List(4, 4, 5, 5)
      case _ => nextGuess(lastGuess, history)
    }

  def breakCodeDoubleRainbow(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] =
    history.size match {
      case 0 => List(0, 1, 2, 3)
      case 1 => List(2, 3, 4, 5)
      case 2 => List(4, 5, 0, 1)
      case _ => nextGuess(lastGuess, history)
    }

  private def nextGuess(guess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] =
    if (history.size > 10) throw new IllegalStateException("Ten guesses are up")
    else if (history.map(x => mind.score(code = guess, guess = x._1) == x._2).count(!_) == 0) guess
    else nextGuess(incrementGuess(guess), history)

  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def incrementGuess(value: List[Int]): List[Int] =
    numberToGuess(guessToNumber(value) + 1)

  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
