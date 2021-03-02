package com.ameliemouillac.gmail.tp05_newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ameliemouillac.gmail.tp05_newsapp.R
import com.ameliemouillac.gmail.tp05_newsapp.models.Article
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class ArticleAdapter(private val dataset: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.size

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {

        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.article_title)
            txtTitle.text = item.title

            val txtContent = root.findViewById<TextView>(R.id.article_content)
            txtContent.text = item.content

            val img = root.findViewById<ImageView>(R.id.article_image)
            Glide.with(root.context).load(item.urlToImage).fitCenter().into(img)
        }
    }
}
