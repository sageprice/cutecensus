package com.cutecensus.dal

import org.springframework.stereotype.Component
import kotlin.math.pow

@Component
object MatchupDal {
  private const val STARTING_ELO = 1500.0
  private const val K = 20
  private val animals = listOf(
    "cat",
    "dog",
    "mouse",
    "pangolin",
    "pig",
    "pigeon",
    "opossum",
    "raccoon",
    "rabbit",
    "rat",
    "seal",
    "squirrel",
  )
  private val rankings = animals.associateWith { STARTING_ELO }.toMutableMap()

  fun getRandomMatchup(
    excluded: List<String>
  ): Pair<Pair<String, Double>, Pair<String, Double>> {
    val excludedIndices = excluded.map { animals.indexOf(it) }
    val index1 = getRandomIndex(excluding = excludedIndices)
    val index2 = getRandomIndex(excluding = excludedIndices + index1)
    val left = animals[index1]
    val right = animals[index2]
    return (left to rankings[left]!!) to (right to rankings[right]!!)
  }

  private fun getRandomIndex(excluding: List<Int>): Int {
    var idx = (Math.random() * rankings.size).toInt()
    while (idx in excluding) {
      idx = (Math.random() * rankings.size).toInt()
    }
    return idx
  }

  fun getRankings(): Map<String, Double> = rankings

  fun updateRankings(winner: String, loser: String, isTie: Boolean) {
    if (winner !in rankings || loser !in rankings) return
    val delta = getEloDelta(rankings[winner]!!, rankings[loser]!!, isTie)
    rankings[winner] = delta + (rankings[winner] ?: STARTING_ELO)
    rankings[loser] = -delta + (rankings[loser] ?: STARTING_ELO)
  }

  private fun getEloDelta(r1: Double, r2: Double, isTie: Boolean): Double =
    K * ((if (isTie) 0.5 else 1.0) - getExpectedScore(r1, r2))

  private fun getExpectedScore(r1: Double, r2: Double): Double {
    val exponent = ((r2 - r1) / 400.0)
    return 1.0 / (1 + 10.0.pow(exponent))
  }
}
