class MasterMindCodeBreaker() {

  def guessToNumber(guess: List[Int]) : Int =
    guess.reduceLeft(_*6 + _)
}
