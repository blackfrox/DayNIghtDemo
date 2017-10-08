package com.example.minitest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

@Suppress("DEPRECATED_IDENTITY_EQUALS")
/**
 * Created by Administrator on 2017/10/8.
 */
class RecyclerViewEmptySupport
    @JvmOverloads constructor(context: Context,attributeSet: AttributeSet?=null,defStyle: Int=0)
    : RecyclerView(context,attributeSet,defStyle) {

    private  var emptyView: View?=null

    private val observer=object : AdapterDataObserver(){
        override fun onChanged() {
            showEmptyView()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            super.onItemRangeChanged(positionStart, itemCount)
            showEmptyView()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            showEmptyView()
        }
    }

  private  fun showEmptyView(){
        if (adapter!=null&&emptyView!=null){
            if (adapter.itemCount===0){
                emptyView!!.visibility=View.VISIBLE
                visibility=GONE
            }else{
                emptyView!!.visibility=GONE
                visibility=View.VISIBLE
            }
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
        if (adapter!=null){
            adapter.registerAdapterDataObserver(observer)
            observer.onChanged()
        }
    }

    fun setEmptyView(v: View){
        emptyView=v
    }
}