package com.cutecensus.dal

import org.springframework.stereotype.Component

@Component
object AssetDal {
  private val shelterCats = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/blanche.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/declan.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/snowball.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/penelope.jpg",
    )
  private val shelterDogs = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/ellie_may.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/june.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/nina.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/ranger.jpg",
    )
  private val shelterRabbits = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/rabbit.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/marzipan.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/venus.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/yeti.jpg",
  )
  private val shelterMice = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/carol.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/piglet-mouse.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/lex-luger.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/mouse.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/mouse2.jpg",
  )
  private val seals = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/baby-seal.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/harp-seal.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/seal.jpg",
  )
  private val pigs = listOf(
    "https://d1oblw1lg7ia0k.cloudfront.net/cheerios.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/jelly.jpg",
    "https://d1oblw1lg7ia0k.cloudfront.net/pig.jpg",
  )
  private val images = mapOf(
    "cat"       to  shelterCats,
    "dog"       to  shelterDogs,
    "duck"      to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/duckling.jpg", "https://d1oblw1lg7ia0k.cloudfront.net/dud.jpg"),
    "mouse"     to  shelterMice,
    "pangolin"  to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/pangolin-excuseme.jpg"),
    "pig"       to  pigs,
    "pigeon"    to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/pigeon.jpg"),
    "opossum"   to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-baby-possum.jpg", "https://d1oblw1lg7ia0k.cloudfront.net/gotta-go.jpeg"),
    "raccoon"   to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki_raccoon.jpeg"),
    "rabbit"    to  shelterRabbits,
    "rat"       to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/rat.jpg"),
    "seal"      to  seals,
    "squirrel"  to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-squirrel.jpg"),
  )

  fun getImage(candidate: String): String? {
    return images[candidate]?.random()
  }
}