package movie.bw.com.mvp_j.callback

/**
 *author(张渊卓)
 *date:2019/2/21
 */
interface MyCallback {
    fun<T> success(data: T)
    fun error(error:String)
}