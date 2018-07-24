package codeone.com.br.gympass.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codeone.com.br.gympass.R
import codeone.com.br.gympass.presenters.DetailsActivityPresenter

class DetailsActivity : AppCompatActivity(), DetailsActivityPresenter.ViewCallBack {

    private val presenter:DetailsActivityPresenter by lazy { DetailsActivityPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        //passando Bundle e a activity
        presenter.onCreate(intent.extras, this)
    }
}
