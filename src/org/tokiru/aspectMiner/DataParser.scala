package org.tokiru.aspectMiner

trait DataParser {
  def parseData(path: String): List[List[(SimpleWord, Boolean)]]
}
