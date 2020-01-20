class MasterMindCodeBreaker() {
  def numberToGuess(n: Int): List[Int] =
    List((n / 216) % 6, (n / 36) % 6, (n / 6) % 6, n % 6)

  def breakCode(value: List[Nothing]): List[Int] =
    List(0, 0, 0, 1)

  def incrementGuess(value: List[Int]): List[Int] = ???


  def guessToNumber(guess: List[Int]): Int =
    guess.reduceLeft(_ * 6 + _)
}
