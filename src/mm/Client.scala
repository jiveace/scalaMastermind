package mm

object Client extends App {
  val autoPlay = new AutoPlay(new MastermindCodeMaker, new MasterMindCodeBreaker, new CodeGenerator)
  //  autoPlay.analyseStrategies(1000)

  def three(x: String, y: String): String =
    x * 2 + y  * 2
//  Left =>  0011001122001100112233
//  Right => 0011223322331122332233
  println(List("0", "1", "2", "3").reduceLeft(three))
  println(List("0", "1", "2", "3").reduceRight(three))

}
