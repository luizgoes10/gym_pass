package codeone.com.br.gympass.adpters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import codeone.com.br.gympass.R
import codeone.com.br.gympass.models.Company
import codeone.com.br.gympass.models.Details
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_company.view.*

class CompanyAdpter(var context:Context, var company:List<Company>, val onClick:(Company)->Unit):
        RecyclerView.Adapter<CompanyAdpter.CompanyViewHolder>() {


    class CompanyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var tName:TextView
        var tRating:TextView
        var photo:ImageView
        var progressBarAdapeter:ProgressBar
        var rbRating:RatingBar
        var error:TextView
        var cardView:CardView
        init{
            tName = view.findViewById<TextView>(R.id.tName)
            tRating = view.findViewById<TextView>(R.id.tRating)
            photo = view.findViewById<ImageView>(R.id.img)
            progressBarAdapeter = view.findViewById<ProgressBar>(R.id.pbAdapterCompany)
            rbRating = view.findViewById<RatingBar>(R.id.rbRatingMain)
            error = view.findViewById<TextView>(R.id.tImgError)
            cardView = view.findViewById<CardView>(R.id.card_view_company)
        }
    }

    override fun getItemCount(): Int {
        return company.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_company,parent,false)
        return CompanyViewHolder(view)
    }
    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val context = holder.itemView.context
        val company = company[position]
        holder.tName.text = company.name
        holder.tRating.text = "Avaliação: " + company.rating.toString()
        holder.rbRating.rating = company.rating!!.toFloat()
        holder.progressBarAdapeter.visibility = View.VISIBLE
        if(company.photos != null){
        Picasso.with(context).load(company.photos!![0].imgReference()).fit().into(holder.photo,
                object : com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.progressBarAdapeter.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.progressBarAdapeter.visibility = View.GONE
                    }
                })
        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeter.visibility = View.GONE
            holder.error.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener { onClick(company) }
    }

    fun setList(companys:MutableList<Company>){
        company = companys
    }
}