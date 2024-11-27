package com.cutecensus.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
final class MatchupController {

  @GetMapping("/hello/{who}")
  fun getMatchup(
    @PathVariable(name = "who") who: String
  ): String {
    return "Hello $who"
  }
}