package com.appxcore.quicksetup.dagger2.dataModels.apiResponse

import com.google.gson.annotations.SerializedName
import com.appxcore.quicksetup.dagger2.questions.QuestionWithBody
import java.util.*

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}