package com.kodeveloper.mymemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodeveloper.mymemo.adapter.MemoListAdapter
import com.kodeveloper.mymemo.item.MemoItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val TAG:String = "MainActivity"

    private lateinit var memoListAdapter: MemoListAdapter
    private lateinit var context: Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        this.setView(this)
        setRecyclerView(this)
        setMemoListItem()
    }

    private fun setView(context: Context) {

        register.setOnClickListener { v ->
            registerMemo(v)
        }

        setRecyclerView(context)
    }

    private fun setRecyclerView(context: Context) {
        val layoutManager:LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false )

        recyclerview.layoutManager = layoutManager

        memoListAdapter = MemoListAdapter(R.layout.row_memo_item, ArrayList<MemoItem>())
        recyclerview.adapter = memoListAdapter

    }

    private fun setMemoListItem() {
        val list:ArrayList<MemoItem> = getMemoDummyList()
        memoListAdapter.addItemList(list)
    }

    private fun getMemoDummyList() : ArrayList<MemoItem> {
        val list = ArrayList<MemoItem>()

        list.add(MemoItem("일상","TEST1"))
        list.add(MemoItem("일상","TEST2"))

        return list
    }


    private fun registerMemo(view: View) {
        var strCategory:String = ""
        var strMemo:String = memo.text.toString()
        if (category.selectedItem is String) {
            strCategory = category.selectedItem.toString()
        }

        if (TextUtils.isEmpty(strMemo)) {
            Toast.makeText(view.context, "메모를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        addMemoItem(strCategory, strMemo)

        category.setSelection(0)
        memo.setText("")

        hideKeyboard()

    }

    private fun hideKeyboard() {
        val view:View = this.currentFocus
        if (view != null) {
            val imm:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    private fun addMemoItem(category: String, memo: String) {
        val item: MemoItem = MemoItem(category, memo)

        memoListAdapter.addItem(item)
    }
}
