class MasterMindCodeBreaker() {
  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def breakCode(lastGuess: List[Int], lastResult: (Int, Int)): List[Int] =
    if (lastGuess.isEmpty) List(0, 0, 0, 0)
    else List(1, 1, 1, 1)

  def incrementGuess(value: List[Int]): List[Int] =
    numberToGuess(guessToNumber(value) + 1)


  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
