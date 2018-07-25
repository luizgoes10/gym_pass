package codeone.com.br.gympass.adpters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import codeone.com.br.gympass.R
import codeone.com.br.gympass.models.Photos
import com.squareup.picasso.Picasso

class PhotoAdapter(var context:Context, var photo:List<Photos>, val onClick:(Photos)->Unit):
        RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(view: View):RecyclerView.ViewHolder(view){
        var imgDetails:ImageView
        var progressBarDetails:ProgressBar
        var cardView:CardView
        init{
            imgDetails = view.findViewById<ImageView>(R.id.imgPhotos)
            progressBarDetails = view.findViewById<ProgressBar>(R.id.pbAdapterPhotos)
            cardView = view.findViewById<CardView>(R.id.card_view_photo)
        }
    }

    override fun getItemCount(): Int = photo.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_photo, parent, false)

        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val context = holder.itemView.context
        val photo = photo[position]
        holder.progressBarDetails.visibility = View.VISIBLE
        Picasso.with(context).load(photo.imgReference()).fit().into(holder.imgDetails,
                object : com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.progressBarDetails.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.progressBarDetails.visibility = View.GONE
                    }
                }
                )
        holder.itemView.setOnClickListener { onClick(photo) }
    }

    fun setList(photos:MutableList<Photos>){
        photo = photos
    }
}