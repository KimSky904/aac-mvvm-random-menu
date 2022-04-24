package com.cloud.aac_mvvm_random_menu.model

import android.util.Log
import java.util.*

class DataBase {
    var instance : DataBase?
    var personList : ArrayList<Menu> = ArrayList()
    lateinit var selectedMenu : String
    lateinit var databaseListener : DataBaseListener

    init {
        instance = null
        Log.d("model","DataBase 생성자 호출")
        personList.add(Menu(0,"짜장면"))
        personList.add(Menu(1,"탕수육"))
        personList.add(Menu(2,"볶음밥"))
        personList.add(Menu(3,"짬뽕"))
    }

    @JvmName("getInstance1")
    fun getInstance() : DataBase {
        Log.d("model","Model에 접근하기 위해 DB인스턴스 값 요청")
        if(instance==null) instance = DataBase()
        return instance as DataBase
    }
    fun getUser() {
        Log.d("model","getUser 호출")
        selectedMenu = personList[Random().nextInt(personList.size)].name
        notifyChange()
    }

    fun getWinner(): String? {
        return selectedMenu
    }

    fun notifyChange() : Unit {
        Log.d("model","Model데이터 변경으로 notify할 것을 명령")
        databaseListener.onChanged()
    }

    fun setOnDatabaseListener(dataBaseListener: DataBaseListener) {
        databaseListener = dataBaseListener
    }

    interface DataBaseListener {
        fun onChanged()
    }


}