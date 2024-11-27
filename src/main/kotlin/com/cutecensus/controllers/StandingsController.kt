package com.cutecensus.controllers

import com.cutecensus.dal.AssetDal
import com.cutecensus.dal.MatchupDal
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
final class StandingsController(
  @Autowired val matchupDal: MatchupDal,
  @Autowired val assetDal: AssetDal
) {

  @GetMapping("/api/v1/standings")
  fun getStandings(request: HttpServletRequest): StandingsResponse {
    // TODO: grab IP from servlet request?
//    println(request)
//    println(request.remoteAddr)
    return StandingsResponse(
      matchupDal.getRankings()
        .map { (name, score) -> ScoredResult(name, score)}
        .sortedByDescending { it.score }
    )
  }

  @GetMapping("/api/v1/matchups/random")
  fun getRandomMatchup(
    @RequestParam(name = "except", defaultValue = "") excluded: List<String>
  ): GetMatchupResponse {
    val (left, right) = matchupDal.getRandomMatchup(excluded)
    return GetMatchupResponse(
      ScoredResult(left.first, left.second),
      assetDal.getImage(left.first),
      ScoredResult(right.first, right.second),
      assetDal.getImage(right.first),
    )
  }

  @PostMapping("/api/v1/comparison")
  fun postComparison(
    @RequestParam(name = "winner") winner: String,
    @RequestParam(name = "loser") loser: String,
    @RequestParam(name = "isDraw") isDraw: Boolean
  ) {
    matchupDal.updateRankings(winner, loser, isDraw)
  }
}

data class StandingsResponse(
  val standings: List<ScoredResult>
)

data class GetMatchupResponse(
  val left: ScoredResult,
  val leftImage: String?,
  val right: ScoredResult,
  val rightImage: String?
)

data class ScoredResult(
  val name: String,
  val score: Double
)