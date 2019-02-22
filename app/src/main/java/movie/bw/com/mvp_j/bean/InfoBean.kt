package movie.bw.com.mvp_j.bean

/**
 *author(张渊卓)
 *date:2019/2/21
 */
class InfoBean constructor() {

    val message: String ?= null
    val result: List<Result>? = null
    val status: String ?= null

    override fun toString(): String {
        return "InfoBean(message='$message', result=$result, status='$status')"
    }
    class Result constructor() {
        val fare: Double = 0.0
        val id: Int = 0
        val imageUrl: String ?= null
        val name: String ?= null
        val releaseTime: Long = 0L
        val summary: String ?= null
        override fun toString(): String {
            return "Result(fare=$fare, id=$id, imageUrl='$imageUrl', name='$name', releaseTime=$releaseTime, summary='$summary')"
        }
    }
}

