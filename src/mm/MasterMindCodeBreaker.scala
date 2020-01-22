package mm

class MasterMindCodeBreaker() {
  val mind = new MastermindCodeMaker

  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def nextGuess(guess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] =
    if (guess == List(0, 0, 0, 0) && history.size > 1) throw new IllegalStateException("guess has looped around to (0,0,0,0)")
    else if (history.map(x => mind.score(code = guess, guess = x._1) == x._2).count(!_) == 0) guess
    else {
      nextGuess(incrementGuess(guess), history)
    }

  def breakCodeSeq(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] = {
    if (lastGuess == null) List(0, 0, 0, 0)
    else nextGuess(lastGuess, history)
  }

  def incrementGuess(value: List[Int]): List[Int] =
    numberToGuess(guessToNumber(value) + 1)


  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
