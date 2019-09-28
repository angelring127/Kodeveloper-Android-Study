package com.kodeveloper.mymemo.item

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MemoItem {

    private val TAG:String = "MemoItem"

    public var category:String = ""
    public var memo:String = ""
    public var regDate:String = ""

    constructor(category:String, memo:String){
        val formatter:DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPAN)
        val date:Date = Date()

        this.category = category
        this.memo = memo
        this.regDate = formatter.format(date)
    }

}