package com.appxcore.quicksetup.dagger2.networking

import com.google.gson.annotations.SerializedName
import com.appxcore.quicksetup.dagger2.questions.Question

data class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)