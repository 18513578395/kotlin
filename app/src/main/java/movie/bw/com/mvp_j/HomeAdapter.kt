package movie.bw.com.mvp_j

import android.app.Activity
import android.drm.DrmStore
import android.support.constraint.ConstraintLayout
import android.support.constraint.Constraints
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import movie.bw.com.mvp_j.bean.InfoBean


/**
 *author(张渊卓)
 *date:2019/2/22
 */

//构造里面的话  val是为了变成常量以供全局使用
class HomeAdapter constructor(private val activity: Activity, private val mList: List<InfoBean.Result>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {
    /*@param1
    * @param2
    * 都需要自己手动改名字group/viewType
    * MutableList 是一个kotlin中的推荐集合
    * */

    private lateinit var mViewHolder:ViewHolder

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(activity).inflate(R.layout.recycle_item, group, false)
        var viewHolder: RecyclerView.ViewHolder = ViewHolder(view)
        this.mViewHolder= viewHolder as ViewHolder
        view.setOnClickListener(this)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        val result = mList[position]

        mViewHolder.item_name.text=result.name
        viewHolder.itemView.setTag(position)//注册点击事件


    }

    private class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val rootLayout: ConstraintLayout = view as ConstraintLayout
        val item_name: TextView = rootLayout.findViewById(R.id.item_name)
    }
    //点击存值，view+position
    override fun onClick(v: View?) {
        mSetOnclick.onClick(v!!,v.getTag() as Int) //接口存值
    }
    //定义接口回调
     interface SetOnclick {
        fun onClick(view: View, position: Int)
    }

    private lateinit var mSetOnclick: SetOnclick

    fun setOnItemClickListener(setOnclick: SetOnclick){
        this.mSetOnclick=setOnclick
    }
}