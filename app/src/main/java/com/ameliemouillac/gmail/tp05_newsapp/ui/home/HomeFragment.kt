package com.ameliemouillac.gmail.tp05_newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ameliemouillac.gmail.tp05_newsapp.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recycler_view: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view = view.findViewById(R.id.recyclerViewArticles)
        bindRecyclerView()
    }

    private fun bindRecyclerView() {

        homeViewModel.articles.observe(
            viewLifecycleOwner, Observer { articles ->
                Log.d("Articles", "Waiting for articles")
                if (articles != null) {
                    Log.d("Articles", articles.toString())
                }
            }
        )
        homeViewModel.loadArticles("tesla")
        /*
        val articlesW = listOf(
            Article(null, "ben", "super article", "lalal", "https://www.reuters.com/article/eu-bancapopolare-stateaid-idUSL2N2L00O2", "https://s1.reutersmedia.net/resources_v2/images/rcom-default.png?w=800", "2021-03-02T10:25:00Z", "lilalo"),
            Article(null, "ben", "super deuxième article", "lalal", "https://www.reuters.com/article/eu-bancapopolare-stateaid-idUSL2N2L00O2", "https://ichef.bbci.co.uk/news/1024/branded_news/58B1/production/_117350722_churchill_paintinghi065757285.jpg", "2021-03-02T10:25:00Z", "lilalo") ,
            Article(null, "ben", "super deuxième article", "lalal", "https://www.reuters.com/article/eu-bancapopolare-stateaid-idUSL2N2L00O2", "https://ichef.bbci.co.uk/news/1024/branded_news/58B1/production/_117350722_churchill_paintinghi065757285.jpg", "2021-03-02T10:25:00Z", "lilalo"),
        Article(null, "ben", "super deuxième article", "lalal", "https://www.reuters.com/article/eu-bancapopolare-stateaid-idUSL2N2L00O2", "https://ichef.bbci.co.uk/news/1024/branded_news/58B1/production/_117350722_churchill_paintinghi065757285.jpg", "2021-03-02T10:25:00Z", "lilalo")

        )
        val adapterRecycler = ArticleAdapter(articlesW)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapterRecycler
        */
    }
}
