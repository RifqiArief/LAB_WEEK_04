package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    // Array of cafe titles (to match each tab)
    private val cafes = listOf(
        R.string.starbucks_title,
        R.string.janjijiwa_title,
        R.string.kopikenangan_title
    )

    // Total number of tabs
    override fun getItemCount(): Int {
        return cafes.size
    }

    // Provide the appropriate fragment for each tab
    override fun createFragment(position: Int): Fragment {
        val titleResId = cafes[position]
        val descriptionResId = when (position) {
            0 -> R.string.starbucks_desc
            1 -> R.string.janjijiwa_desc
            2 -> R.string.kopikenangan_desc
            else -> R.string.starbucks_desc
        }

        return CafeDetailFragment.newInstance(
            titleResId,
            descriptionResId
        )
    }
}
