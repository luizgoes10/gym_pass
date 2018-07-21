package codeone.com.br.gympass.adpters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import codeone.com.br.gympass.R
import codeone.com.br.gympass.models.Company
import kotlinx.android.synthetic.main.adapter_company.view.*

class CompanyAdpter(var company:List<Company>, val onClick:(Company)->Unit):
        RecyclerView.Adapter<CompanyAdpter.CompanyViewHolder>() {


    class CompanyViewHolder(view:View):RecyclerView.ViewHolder(view){
        var tName:TextView
        var photo:ImageView
        var progressBarAdapeter:ProgressBar
        var cardView:CardView
        init{
            tName = view.findViewById<TextView>(R.id.tName)
            photo = view.findViewById<ImageView>(R.id.img)
            progressBarAdapeter = view.findViewById<ProgressBar>(R.id.progressBarAdapter)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}