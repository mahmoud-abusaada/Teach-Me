package com.abusada.teachme.data.models.type_adapters

import com.abusada.teachme.application.AppConstants
import com.abusada.teachme.data.models.Student
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.data.models.UserInfo
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class UserTypeAdapter : JsonDeserializer<UserInfo> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): UserInfo {
        val userObject = json.asJsonObject
        val accountType = userObject.get("account_type").asInt

        if (accountType == AppConstants.AccountType.STUDENT.value) {
            return context!!.deserialize(json, Student::class.java)
        } else if (accountType == AppConstants.AccountType.TEACHER.value) {
            return context!!.deserialize(json, Teacher::class.java)
        }

        return context!!.deserialize(json, UserInfo::class.java)
    }

}