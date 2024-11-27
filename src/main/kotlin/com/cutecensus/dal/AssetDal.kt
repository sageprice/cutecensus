package com.cutecensus.dal

import org.springframework.stereotype.Component

@Component
object AssetDal {
  private val images = mapOf(
    "cat"       to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-sheba.jpeg"),
    "dog"       to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-bulldog.jpg"),
    "duck"      to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/duckling.jpg"),
    "mouse"     to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/mouse.jpg", "https://d1oblw1lg7ia0k.cloudfront.net/mouse2.jpg"),
    "pangolin"  to  listOf("https://i.imgur.com/wKxzaxN.jpeg"),
    "seal"      to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/pig.jpg"),
    "pig"       to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/pig.jpg"),
    "pigeon"    to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/pigeon.jpg"),
    "possum"    to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-baby-possum.jpg"),
    "raccoon"   to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki_raccoon.jpeg"),
    "rabbit"    to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/rabbit.jpg"),
    "rat"       to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/rat.jpg"),
    "seal"      to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/seal.jpg"),
    "squirrel"  to  listOf("https://d1oblw1lg7ia0k.cloudfront.net/wiki-squirrel.jpg"),
  )

  fun getImage(candidate: String): String? {
    return images[candidate]?.random()
  }
}