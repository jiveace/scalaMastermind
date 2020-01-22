package mm

class AutoPlay(maker: MastermindCodeMaker, breaker: MasterMindCodeBreaker, codes: CodeGenerator) {
  def play() = {
    val code = codes.generate

    def helper(pastScores: List[(List[Int], (Int, Int))], lastGuess: List[Int], count: Int): Int = {
      val guess = breaker.breakCode(lastGuess, pastScores)
      val score = maker.score(code, guess)

      if (score == (4, 0)) count
      else helper(pastScores :+ (guess, score), guess, count + 1)
    }

    helper(List(), null, 1)
  }

  def square(n: Int) = n * n

  def mean(n: List[Int]) =
    n.reduce(_ + _) / n.size

  def median(n: List[Int]) =
    n(n.size / 2)

  def histogram(n: List[Int]): List[(Int)] =
    n.groupBy(x => x).toList.map(x => x._2.size)

  def expectedTurns(n: Int) = {
    val scores = (1 to n).map(_ => play()).sortWith(_ < _).toList
    Map(("mean", mean(scores)),
      ("min", scores.head),
      ("max", scores(scores.length - 1)),
      ("median", median(scores)),
      ("hist", histogram(scores)),
    )
  }
}


