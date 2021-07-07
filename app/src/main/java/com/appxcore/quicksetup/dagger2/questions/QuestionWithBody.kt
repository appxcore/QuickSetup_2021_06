package com.appxcore.quicksetup.dagger2.questions

import com.google.gson.annotations.SerializedName
import com.appxcore.quicksetup.dagger2.dataModels.users.User

data class QuestionWithBody(
        @SerializedName("title") val title: String,
        @SerializedName("question_id") val id: String,
        @SerializedName("body") val body: String,
        @SerializedName("owner") val owner: User
)