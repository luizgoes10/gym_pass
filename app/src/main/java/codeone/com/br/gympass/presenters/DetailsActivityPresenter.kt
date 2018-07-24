package codeone.com.br.gympass.presenters

import android.content.Context
import android.os.Bundle
import codeone.com.br.gympass.models.Company
import codeone.com.br.gympass.utils.BundlesConstants

open class DetailsActivityPresenter(viewCallBack:ViewCallBack) {

    private lateinit var company: Company

    interface ViewCallBack{

    }

    fun onCreate(extras: Bundle, context: Context){
        //Recuperando a company pela key
        company = extras.getParcelable(BundlesConstants.COMPANY_KEY)

    }
}