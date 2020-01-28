package mm

object Client extends App {
  val autoPlay = new AutoPlay(new MastermindCodeMaker, new MasterMindCodeBreaker, new CodeGenerator)
  autoPlay.analyseStrategies(1000)

}
