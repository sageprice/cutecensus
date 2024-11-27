package com.cutecensus.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SiteController {

  @GetMapping("/")
  fun getHomepage(
    @RequestParam(name="name", required=false) name: String?,
    model: Model): String {
    name?.let {
      model.addAttribute("name", name)
    }
    return "index"
  }

  @GetMapping("/standings")
  fun getStandings(model: Model): String {
    return "standings"
  }

  @GetMapping("/head2head")
  fun getHomepage(model: Model): String {
    return "head2head"
  }
}