package movie.bw.com.mvp_j.net

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap
import retrofit2.http.Url
import rx.Observable

/**
 *author(张渊卓)
 *date:2019/2/21
 */
interface APIService {
    @GET
    fun get(@Url url: String,@QueryMap map: Map<String,String>):Observable<ResponseBody>

    @POST
    fun post(@Url url: String,@QueryMap map: Map<String, String>):Observable<ResponseBody>
}