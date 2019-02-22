package movie.bw.com.mvp_j.presenter


/**
 *author(张渊卓)
 *date:2019/2/21
 */
interface IPresenter {
    fun<T> startRequest(url: String,map: Map<String,String>,clazz: Class<T>)
}