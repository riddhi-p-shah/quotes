package com.riddhi.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.riddhi.quotes.models.Quote
import java.io.InputStream
import java.nio.charset.Charset

object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null

    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)

    fun loadAssetFromFile(context:Context){
        val inputStream = context.assets.open("quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)

        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if(currentPage.value==Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}

