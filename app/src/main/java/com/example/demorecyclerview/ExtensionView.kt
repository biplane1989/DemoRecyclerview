package com.example.demorecyclerview

import android.view.LayoutInflater
import android.view.View

fun View.getLayoutInflater(): LayoutInflater {
    return LayoutInflater.from(context)
}
