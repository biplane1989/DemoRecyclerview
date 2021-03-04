package com.example.demorecyclerview.stickyheader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demorecyclerview.databinding.FragmentStickyHeaderBinding
import com.example.demorecyclerview.sticky.StickHeaderItemDecoration

class StickyFragment : Fragment() {

    private var _binding: FragmentStickyHeaderBinding? = null
    private val binding: FragmentStickyHeaderBinding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStickyHeaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = StickyAdapter()
        binding.stickyRv.adapter = adapter
        binding.stickyRv.addItemDecoration(StickHeaderItemDecoration(adapter))
        adapter.submitList(demoData)
    }

}