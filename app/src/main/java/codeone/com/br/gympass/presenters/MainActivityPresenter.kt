package codeone.com.br.gympass.presenters

import codeone.com.br.gympass.api.services.ServiceApi
import codeone.com.br.gympass.models.Features
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class MainActivityPresenter(val viewCallBack: ViewCallBack) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setFeaturesNearBySearch(features:MutableList<Features>)
    }
    fun onViewCreated(){
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    open fun taskFeaturesNearBySearch(location:String,radius:String,type:String,keyword:String,key:String){
        //Programação reativa -> padrão observador
        //Falta implementar
        Observable.fromCallable{ServiceApi.getFeaturesNearBySearch(location,radius,type,keyword,key)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext ={
                    if(it.result.isEmpty()){
                        return@subscribeBy
                    }
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                )
    }
}