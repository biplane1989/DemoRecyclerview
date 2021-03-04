package com.example.demorecyclerview.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.demorecyclerview.databinding.FragmentProgressBinding
import com.example.demorecyclerview.databinding.FragmentStickyHeaderBinding
import com.example.demorecyclerview.sticky.StickHeaderItemDecoration
import com.example.demorecyclerview.stickyheader.StickyAdapter
import com.example.demorecyclerview.stickyheader.demoData

class ProgressFragment : Fragment() {
    private var _binding: FragmentProgressBinding? = null
    private val binding: FragmentProgressBinding get() = _binding!!
    private val viewModel: ProgressViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ProgressAdapter()
        binding.progressRv.adapter = adapter
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}