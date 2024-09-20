package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class CafeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the ViewPager2 and Adapter
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<com.google.android.material.tabs.TabLayout>(R.id.tab_layout)

        val cafeAdapter = CafeAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = cafeAdapter

        // Set up TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val titleResId = when (position) {
                0 -> R.string.starbucks_title
                1 -> R.string.janjijiwa_title
                2 -> R.string.kopikenangan_title
                else -> R.string.starbucks_title
            }
            tab.text = getString(titleResId)
        }.attach()
    }
}
