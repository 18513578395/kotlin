package movie.bw.com.mvp_j.util

import movie.bw.com.mvp_j.net.APIService
import movie.bw.com.mvp_j.net.Contants
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.contracts.contract

/**
 *author(张渊卓)
 *date:2019/2/21
 */
object RetrofitUtils {//单例模式，通过object创建

    var httpLoggingInterceptor: HttpLoggingInterceptor= HttpLoggingInterceptor()


     var okHttpClient:OkHttpClient=OkHttpClient.Builder()
             .writeTimeout(20,TimeUnit.SECONDS)
             .readTimeout(20,TimeUnit.SECONDS)
             .connectTimeout(20,TimeUnit.SECONDS)
             //设置日志拦截器
             .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
             .build()

    var retrofit: Retrofit=Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(Contants.BASE_URL)
            .build()

    var apiService:APIService= retrofit.create(APIService::class.java);

    fun get(url:String,map: Map<String,String>,subscribe:Subscriber<ResponseBody>){
        apiService.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe)

    }
}