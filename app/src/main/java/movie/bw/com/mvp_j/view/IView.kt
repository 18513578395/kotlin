package movie.bw.com.mvp_j.view

/**
 *author(张渊卓)
 *date:2019/2/21
 */
interface IView {
    fun<T> success(data: T)
    fun error(error: String)
}