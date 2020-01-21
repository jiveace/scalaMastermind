package mm

class MasterMindCodeBreaker() {
  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def breakCode(lastGuess: List[Int], history: List[(List[Int], (Int, Int))]): List[Int] = {
    val mind = new MastermindCodeMaker

    def helper(guess: List[Int]): List[Int] =
      if (guess == List(0, 0, 0, 0)) throw new IllegalStateException("guess has looped around to (0,0,0,0)")
      else if (mind.score(code = guess, guess = history.head._1) == history.head._2) guess
      else {
        println(s"TargetScore: ${history.head._2}  Code:${guess} Guess:${history.head._1}  Result:${mind.score(code = guess, guess = history.head._1)}   ${history.head._2}")
        helper(incrementGuess(guess))
      }

    if (lastGuess == null) List(0, 0, 0, 0)
    else if (lastGuess == List(0, 0, 0, 0)) helper(incrementGuess(lastGuess))
    else helper(lastGuess)
  }

  def incrementGuess(value: List[Int]): List[Int] =
    numberToGuess(guessToNumber(value) + 1)


  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
