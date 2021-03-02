package com.ameliemouillac.gmail.tp05_newsapp.dal

import androidx.lifecycle.LiveData
import com.ameliemouillac.gmail.tp05_newsapp.models.Article

interface NewsDataSource {
    fun getArticles(query: String): LiveData<List<Article>>
}
