package com.cutecensus.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SiteController {

  @GetMapping("/")
  fun getHomepage(model: Model): String {
    return getHead2Head(model)
  }

  @GetMapping("/standings")
  fun getStandings(model: Model): String {
    return "standings"
  }

  @GetMapping("/head2head")
  fun getHead2Head(model: Model): String {
    return "head2head"
  }

  @GetMapping("/faq")
  fun getFaq(model: Model): String {
    return "faq"
  }
}