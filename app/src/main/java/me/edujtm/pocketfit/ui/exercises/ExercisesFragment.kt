package me.edujtm.pocketfit.ui.exercises

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import me.edujtm.pocketfit.databinding.FragmentExercisesBinding
import me.edujtm.pocketfit.platform.mainActivityInjector
import me.edujtm.pocketfit.platform.viewModel

class ExercisesFragment : Fragment() {

    private val exercisesViewModel: ExercisesViewModel by viewModel {
        mainActivityInjector.exercisesViewModel
    }

    private var _binding: FragmentExercisesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExercisesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val exercisesAdapter = ExercisesAdapter()
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        with(binding.exercisesRecyclerView) {
            adapter = exercisesAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            addItemDecoration(decoration)
        }

        exercisesViewModel.exercise.observe(viewLifecycleOwner) { exercises ->
            Log.i("ExercisesFragment", "Exercises ${exercises.joinToString { it.name }}")
            exercisesAdapter.submitExercises(exercises)
        }

        exercisesViewModel.fetchExercises();
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}