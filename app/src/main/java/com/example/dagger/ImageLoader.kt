package com.example.dagger

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader {
    fun load(url : String , image  :ImageView)
    = Picasso.get().load(url).into(image)
}