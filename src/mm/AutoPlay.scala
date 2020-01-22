package mm

class AutoPlay(maker: MastermindCodeMaker, breaker: MasterMindCodeBreaker, codes: CodeGenerator) {
  def play() = {
    val code = codes.generate

    def helper(pastScores: List[(List[Int], (Int, Int))], lastGuess: List[Int], count: Int): Int = {
      val score = maker.score(code, lastGuess)
      val guess = breaker.breakCode(lastGuess, pastScores)

      if (score == (4, 0)) count
      else helper(pastScores :+ (guess, score), guess, count + 1)
    }

    helper(List(), List(0, 0, 0, 0), 1)
  }
}


