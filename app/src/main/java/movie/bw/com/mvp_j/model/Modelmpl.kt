package movie.bw.com.mvp_j.model


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import movie.bw.com.mvp_j.bean.InfoBean
import movie.bw.com.mvp_j.callback.MyCallback
import movie.bw.com.mvp_j.util.RetrofitUtils
import okhttp3.ResponseBody
import org.json.JSONObject
import rx.Subscriber

/**
 *author(张渊卓)
 *date:2019/2/21
 */
class Modelmpl: IModel {
    override fun <T> getData(url: String, map: Map<String, String>, clazz: Class<T>, callback: MyCallback) {
        RetrofitUtils.get(url, map, object : Subscriber<ResponseBody>() {
            override fun onNext(t: ResponseBody?) {
                var string = t!!.string()
                val gson = GsonBuilder().disableHtmlEscaping().create()
                val response = gson.fromJson(string!!, clazz)
                callback.success(response!!)   //双感叹号为not null

            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                callback.error(e?.message!!)
            }
        })
    }



}




