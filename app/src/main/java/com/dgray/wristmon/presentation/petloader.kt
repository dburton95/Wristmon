package com.dgray.wristmon.presentation

import android.content.Context
import com.google.gson.Gson

fun loadPetFromConfig(context: Context, fileName: String = "wristy.json"): Pet {
    val json = context.assets.open(fileName).bufferedReader().use {it.readText()}
    return Gson().fromJson(json, Pet::class.java)
}