package org.tokiru.aspectMiner

import edu.stanford.nlp.ling.Sentence
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import collection.JavaConversions._

object POSTagger {
  private def MODEL = "/home/tokiru/diploma/postagger/stanford-postagger-full-2014-10-26/models/english-caseless-left3words-distsim.tagger"

  def tag(corpus: List[List[(SimpleWord, Boolean)]]): List[List[Word]] = {
    val tagger = new MaxentTagger(MODEL)

    for (sentence <- corpus) yield {
      val stanfordSentence = Sentence.toWordList((sentence map (_._1.word())).toArray:_*)
      val taggedSentence = tagger.tagSentence(stanfordSentence)
      val isAspect = sentence map (_._2)

      (taggedSentence, isAspect).zipped map (new Word(_, _))
    }.toList

  }
}

