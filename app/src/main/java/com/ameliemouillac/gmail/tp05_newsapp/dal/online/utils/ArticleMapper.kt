package com.ameliemouillac.gmail.tp05_newsapp.dal.online.utils

import com.ameliemouillac.gmail.tp05_newsapp.dal.online.model.ArticleItem
import com.ameliemouillac.gmail.tp05_newsapp.dal.online.model.SourceResponse
import com.ameliemouillac.gmail.tp05_newsapp.models.Article
import com.ameliemouillac.gmail.tp05_newsapp.models.Source

fun ArticleItem.toArticle() = Article(
    author = author ?: "",
    content = content ?: "",
    description = description ?: "",
    publishedAt = publishedAt ?: "",
    source = source.toSource() ?: null,
    title = title ?: "",
    url = url ?: "",
    urlToImage = urlToImage
)

fun SourceResponse.toSource() = Source(
    id = id ?: "",
    name = name ?: ""
)
