package movie.bw.com.mvp_j

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import movie.bw.com.mvp_j.bean.InfoBean
import movie.bw.com.mvp_j.net.Contants
import movie.bw.com.mvp_j.presenter.Presenter
import movie.bw.com.mvp_j.view.IView
import java.util.HashMap

class MainActivity : AppCompatActivity(), IView {


    private lateinit var presenter: Presenter
    lateinit var map: MutableMap<String, String>
    lateinit var homeAdapter: HomeAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        linearLayoutManager = LinearLayoutManager(this)
        home_recy.layoutManager = linearLayoutManager
        //kotlin中推荐的map
        val airPorts = mapOf(Pair(Contants.key, "1"))
        map = airPorts.toMutableMap()

        presenter.startRequest(Contants.NEW_URL, map, InfoBean::class.java)


    }

    override fun error(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun <T> success(data: T) {
        var infoBean = InfoBean()
        if (data is InfoBean) {
            infoBean = data
            homeAdapter = HomeAdapter(this, infoBean.result as List<InfoBean.Result>)
            home_recy.adapter = homeAdapter

            homeAdapter.setOnItemClickListener(object : HomeAdapter.SetOnclick {
                override fun onClick(view: View, position: Int) {
                    Toast.makeText(applicationContext, "下表為："+position, Toast.LENGTH_SHORT).show()
                }

            })
        }
    }


}






