package mm

import scala.util.Random

class CodeGenerator extends App {
  def generate: List[Int] = {
    val mind = new MasterMindCodeBreaker
    val number = mind.numberToGuess(new Random().nextInt(6 * 6 * 6 * 6 - 1))
    number
  }
}
