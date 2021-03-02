package com.ameliemouillac.gmail.tp05_newsapp.dal.online.model

data class ArticleResponse(
    val articles: List<ArticleItem>,
    val status: String,
    val totalResults: Int
)

data class ArticleItem(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceResponse,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class SourceResponse(
    val id: String,
    val name: String
)
