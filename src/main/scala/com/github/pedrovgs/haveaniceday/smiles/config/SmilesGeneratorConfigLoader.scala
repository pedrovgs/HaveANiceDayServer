package com.github.pedrovgs.haveaniceday.smiles.config

import com.github.pedrovgs.haveaniceday.smiles.model.SmilesGeneratorConfig
import com.typesafe.config.Config

import scala.collection.JavaConverters._

object SmilesGeneratorConfigLoader {

  def loadSmilesGeneratorConfig(config: Config): Option[SmilesGeneratorConfig] = {
    try {
      val twitterAccounts             = config.getStringList("twitterAccounts").asScala.toList
      val scheduleTasks               = config.getBoolean("scheduleTasks")
      val extractionSchedule          = config.getString("extractionSchedule")
      val generationSchedule          = config.getString("generationSchedule")
      val allowManualSmilesExtraction = config.getBoolean("allowManualSmilesExtraction")
      val allowManualSmilesGeneration = config.getBoolean("allowManualSmilesGeneration")
      Some(
        SmilesGeneratorConfig(twitterAccounts,
                              scheduleTasks,
                              extractionSchedule,
                              generationSchedule,
                              allowManualSmilesExtraction,
                              allowManualSmilesGeneration))
    } catch {
      case _: Throwable => None
    }
  }

}
