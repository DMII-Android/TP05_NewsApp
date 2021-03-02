package com.ameliemouillac.gmail.tp05_newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ameliemouillac.gmail.tp05_newsapp.models.Article
import com.ameliemouillac.gmail.tp05_newsapp.repositories.ArticleRepository
import java.util.concurrent.Executors

class HomeViewModel : ViewModel() {

    private val repository: ArticleRepository = ArticleRepository.getInstance()
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articles: LiveData<List<Article>>
        get() = _articles

    init {
        //loadArticles("tesla")
    }

    fun loadArticles(query: String) {
        Executors.newSingleThreadExecutor().execute() {
            val result = repository.getArticles(query)
            _articles.postValue(result.value)
        }
    }

}
