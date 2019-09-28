package com.kodeveloper.mymemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kodeveloper.mymemo.R
import com.kodeveloper.mymemo.item.MemoItem
import kotlinx.android.synthetic.main.activity_main.view.*

class MemoListAdapter(private val resource:Int,
                      private val itemList: ArrayList<MemoItem>) : RecyclerView.Adapter<MemoListAdapter.ViewHolder>(){

    fun addItem(item:MemoItem) {
        this.itemList.add(0, item)
        notifyDataSetChanged()
    }

    fun addItemList(itemList:ArrayList<MemoItem>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

//    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

//    간단하게 값 입력 받는 방법
    override fun getItemCount() = itemList.size

    // View가 생성되면 onBindViewHolder가 호출됨
    // 각 memoView에 데이터를 넣는다.
    override fun onBindViewHolder(holder: MemoListAdapter.ViewHolder, position: Int) {
        val memoItem = itemList[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked: ${memoItem.memo}", Toast.LENGTH_SHORT).show()
        }

        holder.apply {
            bind(listener, memoItem)
        }

    }

//    MemoListAdapter가 처음 초기화 되었을때 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoListAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(resource, parent, false)

        return  MemoListAdapter.ViewHolder(inflatedView)
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var categoryText:TextView = view.findViewById(R.id.category)
        private var memoText:TextView = view.findViewById(R.id.memo)
        private var dateText:TextView = view.findViewById(R.id.regdate)

        fun bind(listener: View.OnClickListener, item: MemoItem) {
            this.categoryText.text = item.category
            this.memoText.text = item.memo
            this.dateText.text = item.regDate

            this.view.setOnClickListener(listener)
        }
    }
}