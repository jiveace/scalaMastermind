package mm

class AutoPlay(maker: MastermindCodeMaker, breaker: MasterMindCodeBreaker, codes: CodeGenerator) {
  def playSeq() = play("Seq")

  def play3x2() = play("3x2")

  def playDoubleRainbow() = play("DoubleRainbow")

  private def play(algorithm: String) = {
    val code = codes.generate

    def helper(pastScores: List[(List[Int], (Int, Int))], lastGuess: List[Int], count: Int): Int = {
      val guess = algorithm match  {
        case "3x2" => breaker.breakCode3x2(lastGuess, pastScores)
        case "DoubleRainbow" => breaker.breakCodeDoubleRainbow(lastGuess, pastScores)
        case _ => breaker.breakCodeSeq(lastGuess, pastScores)
      }
      val score = maker.score(code, guess)

      if (score == (4, 0)) count
      else helper(pastScores :+ (guess, score), guess, count + 1)
    }

    helper(List(), null, 1)
  }

  def square(n: Int) = n * n

  def mean(n: List[Int]) =
    n.reduce(_ + _)*1.0 / n.size

  def median(n: List[Int]) =
    n(n.size / 2)

  def histogram(n: List[Int]): List[(Int, Int)] =
    n.groupBy(x => x).toList.map(x => (x._1,x._2.size)).sortWith(_._1 < _._1)

  def analyseStrategy(n: Int, strategy: () => Int) = {
    val scores = (1 to n).map(_ => strategy()).sortWith(_ < _).toList
    Map(("mean", mean(scores)),
      ("min", scores.head),
      ("max", scores(scores.length - 1)),
      ("median", median(scores)),
      ("hist", histogram(scores)),
    )
  }

  def analyseStrategies(n: Int) = {
    println(s"Seq: ${analyseStrategy(n, playSeq)}")
    println(s"3x2: ${analyseStrategy(n, play3x2)}")
    println(s"DR:  ${analyseStrategy(n, playDoubleRainbow)}")
  }
}


