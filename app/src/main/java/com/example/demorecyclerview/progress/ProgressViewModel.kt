package com.example.demorecyclerview.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressViewModel : ViewModel() {
    private val _list = MutableLiveData<List<ProgressData>>()
    val list: LiveData<List<ProgressData>> get() = _list

    init {
        viewModelScope.launch {
            val result = mutableListOf<ProgressData>()
            for (i in 0 until 50) {
                val data = ProgressData("Item $i", 0)
                result.add(data)
                startUpdate(i)
            }
            _list.value = result
        }
    }

    private fun startUpdate(index: Int) {
        viewModelScope.launch {
            val data = _list.value?.get(index)
            if (data != null) {
                while (data.progress < 100) {
                    delay(100 + index * 5L)
                    data.progress += 1
                    val copyItem = data.copy()
                    (_list.value as ArrayList).set(index, copyItem)
                    _list.value = _list.value
                }
            }
        }
    }

}