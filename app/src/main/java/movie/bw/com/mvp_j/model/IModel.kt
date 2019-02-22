package movie.bw.com.mvp_j.model

import movie.bw.com.mvp_j.callback.MyCallback
import kotlin.reflect.KClass

/**
 *author(张渊卓)
 *date:2019/2/21
 */
interface IModel {  //泛型Any表示任意类型
    fun<T> getData(url:String , map:Map<String,String> ,clazz: Class<T>,callback:MyCallback)
}