package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CafeDetailFragment : Fragment() {

    private var content: String? = null
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the arguments passed in newInstance
        arguments?.let {
            content = it.getString(TAB_CONTENT)
            title = it.getString(TAB_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the text for the TextViews dynamically
        view.findViewById<TextView>(R.id.cafe_title)?.text = title
        view.findViewById<TextView>(R.id.content_description)?.text = content
    }

    companion object {
        private const val TAB_TITLE = "TAB_TITLE"
        private const val TAB_CONTENT = "TAB_CONTENT"

        // Use this method to create a new instance of the fragment with title and content
        fun newInstance(title: String, content: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_TITLE, title)
                    putString(TAB_CONTENT, content)
                }
            }
    }
}
