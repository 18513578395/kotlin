package movie.bw.com.mvp_j.presenter

import movie.bw.com.mvp_j.callback.MyCallback
import movie.bw.com.mvp_j.model.Modelmpl
import movie.bw.com.mvp_j.view.IView

/**
 *author(张渊卓)
 *date:2019/2/21
 *  constructor 构造方法需要在类上声明，他的固定构造体为init(),内部定义的
 */
class Presenter constructor (var iView: IView ): IPresenter {
   var modelmpl:Modelmpl //可以为null  防止空指针
    init {
        modelmpl= Modelmpl()
    }

    override fun<T> startRequest(url: String, map: Map<String, String>,clazz: Class<T>) {

        modelmpl.getData(url,map,clazz,object :MyCallback{
            override fun <T> success(data: T) {
                iView.success(data!!)
            }

            override fun error(error: String) {
                iView.error(error!!)
            }

        })
    }
}