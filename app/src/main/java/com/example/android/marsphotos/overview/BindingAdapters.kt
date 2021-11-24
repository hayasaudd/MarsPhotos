package com.example.android.marsphotos.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.R
import com.example.android.marsphotos.network.MarsPhoto


@BindingAdapter("imageUrl")
fun bindingImage(imgView: ImageView, imageURL: String?){
    imageURL?.let {
        val imgUri = imageURL.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<MarsPhoto>?) {
    //maby forom this
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}