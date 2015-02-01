package org.tokiru.aspectMiner

import  scala.xml.XML

object SemEvalDataParser extends DataParser {

  private val REGEX = "\\P{L}+"

  override def parseData(path: String): List[List[(SimpleWord, Boolean)]] = {
    val xmlData = XML.loadFile(path)
    for (sentence <- xmlData \\ "sentence") yield {
      val aspectsXML = sentence \\ "aspectTerms"

      val aspects: List[String] =
        (for (aspectXML <- aspectsXML \ "aspectTerm") yield {
          (aspectXML \ "@term").text.split(REGEX).toList

         }).toList.flatten

      for (word <- ((sentence \\ "text").text).split(REGEX)) yield {
        (new SimpleWord(word), aspects.exists(_==word))
      }
    }.toList
  }.toList
}
