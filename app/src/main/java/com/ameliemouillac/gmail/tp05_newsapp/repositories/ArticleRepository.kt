package com.ameliemouillac.gmail.tp05_newsapp.repositories

import androidx.lifecycle.LiveData
import com.ameliemouillac.gmail.tp05_newsapp.dal.NewsDataSource
import com.ameliemouillac.gmail.tp05_newsapp.dal.online.ArticleOnlineDataSource
import com.ameliemouillac.gmail.tp05_newsapp.models.Article

class ArticleRepository private constructor() {
    private val dataSource: NewsDataSource = ArticleOnlineDataSource()

    fun getArticles(query: String): LiveData<List<Article>> {
        return dataSource.getArticles(query)
    }

    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}
