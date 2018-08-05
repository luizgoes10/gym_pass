package codeone.com.br.gympass.adpters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import codeone.com.br.gympass.R
import codeone.com.br.gympass.models.Reviews
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_rewiews.view.*

class ReviewsAdapter(var context: Context, var reviews:List<Reviews>, val onClick:(Reviews)->Unit):
        RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>() {
    class ReviewsViewHolder(view: View):RecyclerView.ViewHolder(view){
        var authorName:TextView
        var authorUrl:TextView
        var language:TextView
        var profilePhotoUrl:ImageView
        var rbAuthor:RatingBar
        var relativeTimeDescription:TextView
        var text:TextView
        var progressBarr:ProgressBar
        var cardView:CardView
        init{
            authorName = view.findViewById<TextView>(R.id.tAuthorName)
            language = view.findViewById<TextView>(R.id.tLanguage)
            authorUrl = view.findViewById<TextView>(R.id.tAuthorUrl)
            profilePhotoUrl = view.findViewById<ImageView>(R.id.imgPhotosUrl)
            rbAuthor = view.findViewById<RatingBar>(R.id.rbAuthor)
            relativeTimeDescription = view.findViewById<TextView>(R.id.tRelativeTimeDescription)
            text = view.findViewById<TextView>(R.id.tText)
            progressBarr = view.findViewById<ProgressBar>(R.id.pbPhotosUrl)
            cardView = view.findViewById<CardView>(R.id.card_view_reviews)
        }
    }

    override fun getItemCount(): Int = reviews.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_rewiews, parent, false)

        return ReviewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {

        val context = holder.itemView.context
        val review = reviews[position]
        holder.authorName.text = review.authorName
        holder.language.text = review.language
        holder.authorUrl.text = review.authorUrl
        holder.progressBarr.visibility = View.VISIBLE
        Picasso.with(context).load(review.profilePhotoUrl).fit().into(holder.profilePhotoUrl,
                object : com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.progressBarr.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.progressBarr.visibility = View.GONE
                    }
                }
                )
        holder.rbAuthor.rating = review.rating.toFloat()
        holder.relativeTimeDescription.text = review.relativeTimeDescription
        holder.text.text = review.text
        holder.itemView.setOnClickListener { onClick(review) }
    }


    fun setListReviews(review:MutableList<Reviews>){
        reviews = review
    }
}