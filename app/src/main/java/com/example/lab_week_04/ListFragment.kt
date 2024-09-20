package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find coffee list views
        val coffeeList = listOf<TextView>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte)
        )

        coffeeList.forEach { coffee ->
            coffee.visibility = View.VISIBLE
            coffee.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt(DetailFragment.COFFEE_ID, coffee.id)
                }

                // Navigate to DetailFragment
                Navigation.findNavController(view)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }
}
