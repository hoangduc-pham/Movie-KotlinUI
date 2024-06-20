package com.jicsoftwarestudio.bad_02_viewclassic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val imageResId = intent.getIntExtra("imageResId", R.drawable.mv)
        val title = intent.getStringExtra("title") ?: "Unknown Title"
        val rate = intent.getStringExtra("rate") ?: "Unknown Rate"
        val genre = intent.getStringExtra("genre") ?: "Unknown Genre"
        val overview = intent.getStringExtra("overview") ?: "Unknown Overview"

        findViewById<ImageView>(R.id.imageView).setImageResource(imageResId)
        findViewById<ImageView>(R.id.imageViewDetail).setImageResource(imageResId)
        findViewById<TextView>(R.id.titleText).text = title
        findViewById<TextView>(R.id.subText).text = genre
        findViewById<TextView>(R.id.textRate).text = rate
        findViewById<TextView>(R.id.overViewText).text = overview
    }
}
