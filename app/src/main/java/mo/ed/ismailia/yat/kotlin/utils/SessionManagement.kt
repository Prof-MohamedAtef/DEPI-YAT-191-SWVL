package mo.ed.ismailia.yat.kotlin.utils

import android.content.Context
import android.content.SharedPreferences

/*
    SharedPrefs
     */
class SessionManagement(var context: Context) {

    var sharedPreferences: SharedPreferences

    init {

        sharedPreferences = context.getSharedPreferences("SwvlPreferences", Context.MODE_PRIVATE)
    }


    fun putUserName(userName: String){
        val editor = sharedPreferences.edit()
        editor.putString(Constants.SharedConstants.USER_NAME, userName)
        editor.apply()
    }

    fun getUserName(): String{
        return sharedPreferences.getString(Constants.SharedConstants.USER_NAME, "") ?: ""
    }

    fun getPhone(): String{
        return sharedPreferences.getString(Constants.SharedConstants.USER_PHONE, "") ?: ""
    }

    fun getEmail(): String{
        return sharedPreferences.getString(Constants.SharedConstants.USER_EMAIL, "") ?: ""
    }

    fun putEmail(email: String){
        val editor = sharedPreferences.edit()
        editor.putString(Constants.SharedConstants.USER_EMAIL, email)
        editor.apply()
    }

    fun putPhone(phone: String){
        val editor = sharedPreferences.edit()
        editor.putString(Constants.SharedConstants.USER_PHONE, phone)
        editor.apply()
    }


}