package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_TITLE = "title"
private const val ARG_DESCRIPTION = "description"

class CafeDetailFragment : Fragment() {

    // Variables to store the title and description
    private var titleResId: Int? = null
    private var descriptionResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titleResId = it.getInt(ARG_TITLE)
            descriptionResId = it.getInt(ARG_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the title and description in the views
        view.findViewById<TextView>(R.id.cafe_title).text = getString(titleResId ?: R.string.starbucks_title)
        view.findViewById<TextView>(R.id.cafe_desc).text = getString(descriptionResId ?: R.string.starbucks_desc)
    }

    companion object {
        // Factory method to create a new instance of this fragment
        @JvmStatic
        fun newInstance(titleResId: Int, descriptionResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TITLE, titleResId)
                    putInt(ARG_DESCRIPTION, descriptionResId)
                }
            }
    }
}

