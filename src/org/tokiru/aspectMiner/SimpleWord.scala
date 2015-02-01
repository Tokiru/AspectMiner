package org.tokiru.aspectMiner

import edu.stanford.nlp.ling.HasWord

class SimpleWord(value: String) extends HasWord {

  override def toString: String = value

  override def word(): String = value

  override def setWord(word: String): Unit = ???
}
