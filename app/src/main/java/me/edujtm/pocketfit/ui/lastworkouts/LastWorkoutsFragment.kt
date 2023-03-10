package me.edujtm.pocketfit.ui.lastworkouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.edujtm.pocketfit.databinding.FragmentLastWorkoutsBinding

class LastWorkoutsFragment : Fragment() {

    private var _binding: FragmentLastWorkoutsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val lastWorkoutsViewModel =
            ViewModelProvider(this).get(LastWorkoutsViewModel::class.java)

        _binding = FragmentLastWorkoutsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val workoutsAdapter = LastWorkoutsListAdapter()
        with(binding.rvLastWorkouts) {
            adapter = workoutsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}