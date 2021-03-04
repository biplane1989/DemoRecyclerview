package com.example.demorecyclerview.stickyheader

data class StickyData(val title: String, val header: Boolean)

val demoData by lazy {
    val result = mutableListOf<StickyData>()
    for (i in 0 until 100) {
        if (i % 10 == 0) {
            result.add(StickyData("Header $i", true))
        } else {
            result.add(StickyData("Item $i", false))
        }
    }
    result
}

