import org.tokiru.aspectMiner.{POSTagger, SemEvalDataParser}

object Main {
  def main(args: Array[String]): Unit = {
    val data = SemEvalDataParser.parseData("/home/tokiru/diploma/corpus/corpus1/SemEval/Restaurants_Train_v2.xml")
    val taggedData = POSTagger.tag(data)
    println(taggedData take 5)
  }
}
