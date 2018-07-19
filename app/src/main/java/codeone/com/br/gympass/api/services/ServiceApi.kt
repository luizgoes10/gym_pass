package codeone.com.br.gympass.api.services

import codeone.com.br.gympass.api.BaseUrl
import codeone.com.br.gympass.api.utils.createRetrofitService
import codeone.com.br.gympass.api.utils.exceptions.FeaturesException
import codeone.com.br.gympass.models.Details
import codeone.com.br.gympass.models.Features
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class ServiceApi {
    interface Retrofit{
        @GET("json")
        fun getFeaturesNearBySearch(
                @Query("location")
                location:String,
                @Query("radius")
                radius:String,
                @Query("type")
                type:String,
                @Query("keyword")
                keyword:String,
                @Query("key")
                key:String
        ): Call<Features>
        @GET("json")
        fun getFeaturesTextSearch(
                @Query("location")
                location:String,
                @Query("radius")
                radius:String,
                @Query("type")
                type:String,
                @Query("keyword")
                keyword:String,
                @Query("key")
                key:String
        ):Call<Features>
        @GET("json")
        fun getDetails(
                @Query("placeid")
                placeId:String,
                @Query("key")
                key:String
        ):Call<Details>
    }
    companion object Factory{
        @Throws
        fun getFeaturesNearBySearch(location: String, radius: String, type: String, keyword: String, key: String)
                : Features {
            val service = createRetrofitService<Retrofit>(BaseUrl.URL_ADDRESS_NEARBY_SEARCH)
            val execute = service.getFeaturesNearBySearch(location,radius,type,keyword,key).execute()
            val responseVo = execute.body()
            responseVo?.let {
              return it
            }
            throw FeaturesException("Houve um erro")
        }
        @Throws
        fun getFeaturesTextSearch(location: String, radius: String, type: String, keyword: String, key: String)
                : Features {
            val service = createRetrofitService<Retrofit>(BaseUrl.URL_ADDRESS_TEXT_SEARCH)
            val execute = service.getFeaturesNearBySearch(location,radius,type,keyword,key).execute()
            val responseVo = execute.body()
            responseVo?.let {
                return it
            }
            throw FeaturesException("Houve um erro")
        }
        //Falta implementar details
        @Throws
        fun getDetails(placeId: String, key: String)
                : Details {
            val service = createRetrofitService<Retrofit>(BaseUrl.URL_DETAIL)
            val execute = service.getDetails(placeId, key).execute()
            val responseVo = execute.body()
            responseVo?.let {
                return it
            }
            throw FeaturesException("Houve um erro")
        }
    }
}