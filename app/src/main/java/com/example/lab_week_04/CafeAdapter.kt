package com.example.lab_week_04

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(private val context: Context, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CafeDetailFragment.newInstance(
                context.getString(R.string.starbucks_title),
                context.getString(R.string.starbucks_desc)
            )
            1 -> CafeDetailFragment.newInstance(
                context.getString(R.string.janjijiwa_title),
                context.getString(R.string.janjijiwa_desc)
            )
            2 -> CafeDetailFragment.newInstance(
                context.getString(R.string.kopikenangan_title),
                context.getString(R.string.kopikenangan_desc)
            )
            else -> throw IllegalStateException("Invalid position")
        }
    }

    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }
}
