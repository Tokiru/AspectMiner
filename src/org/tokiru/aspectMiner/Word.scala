package org.tokiru.aspectMiner

import edu.stanford.nlp.ling.TaggedWord

class Word(taggedWord: TaggedWord, aspect: Boolean) {
  def value: String = taggedWord.value()
  def tag: String = taggedWord.tag()
  def isAspect: Boolean = aspect

  override def toString() = value + " " + tag + " " + isAspect
}
