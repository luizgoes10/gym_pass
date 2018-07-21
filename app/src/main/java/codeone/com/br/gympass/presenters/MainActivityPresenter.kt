package codeone.com.br.gympass.presenters

import android.os.Bundle
import codeone.com.br.gympass.api.BaseUrl
import codeone.com.br.gympass.api.services.ServiceApi
import codeone.com.br.gympass.models.Company
import codeone.com.br.gympass.models.Features
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class MainActivityPresenter(val viewCallBack: ViewCallBack) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun onSwipeLoadItems()
        fun onSwipeCompleteLoadItems()
        fun showProgressView()
        fun hideProgressView()
        fun setFeaturesNearBySearch(company:MutableList<Company>)
    }
    fun onViewCreated(){
        viewCallBack.showProgressView()
        viewCallBack.setUpRecycler()
        getCompany()
    }

    private fun getCompany(){
        taskFeaturesNearBySearch(
                "-25.431936,-49.3383357",
                "50000",
                "motel",
                "motel",
                BaseUrl.API_KEY)
    }
    open fun taskFeaturesNearBySearch(location:String,radius:String,type:String,keyword:String,key:String){
        //Programação reativa -> padrão observador
        var teste = location
        Observable.fromCallable{ServiceApi.getFeaturesNearBySearch(location,radius,type,keyword,key)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext ={
                    if(it.results.isEmpty()){
                        return@subscribeBy
                    }
                    viewCallBack.hideProgressView()
                    viewCallBack.setFeaturesNearBySearch(it.results)
                }

                )
    }

    fun clickedItem(company: Company) {
        val bundle = Bundle()
    }
}