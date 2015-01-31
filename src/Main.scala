import org.tokiru.aspectMiner.SemEvalDataParser

object Main {
  def main(args: Array[String]): Unit = {
    val data = SemEvalDataParser.parseData("/home/tokiru/diploma/corpus/corpus1/SemEval/Restaurants_Train_v2.xml")
    println(data.length)
    println(data take 5)
  }
}
