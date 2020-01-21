package mm

class MasterMindCodeBreaker() {
  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def breakCode(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] = {
    val mind = new MastermindCodeMaker

    def helper(guess: List[Int]): List[Int] =
      if (mind.score(code = guess, guess = history.head._1) == history.head._2) guess
      else helper(incrementGuess(guess))


    if (lastGuess == null) List(0, 0, 0, 0)
    else helper(lastGuess)
  }

  def incrementGuess(value: List[Int]): List[Int] =
    numberToGuess(guessToNumber(value) + 1)


  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
