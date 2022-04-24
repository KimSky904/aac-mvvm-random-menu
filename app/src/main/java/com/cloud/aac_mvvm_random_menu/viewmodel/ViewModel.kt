package com.cloud.aac_mvvm_random_menu.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.cloud.aac_mvvm_random_menu.model.DataBase

class ViewModel(_database: DataBase) : BaseObservable() {
    var database : DataBase
    var selectedItem : String? = ""

    init {
        Log.d("viewmodel","ViewModel 생성자 실행")
        database = _database

        var dbl = DataBase()
        database.setOnDatabaseListener(object : DataBase.DataBaseListener {
            override fun onChanged() {
                selectedItem = null
                selectedItem = database.selectedMenu
                Log.d("viewmodel","selectedMenu 값 부여")
                notifyChange()
            }
        });
    }

    fun getUser() {
        Log.d("viewmodel","db에게 menu(selectedItem)를 달라고 요청")
        database.getUser()
    }

    fun getWinner(): String? {
        Log.d("viewmodel","selectedItem 반환")
        return selectedItem
    }

}