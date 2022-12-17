package me.edujtm.pocketfit.ui.exercises

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.edujtm.pocketfit.databinding.ExerciseListItemBinding
import me.edujtm.pocketfit.domain.entities.Exercise

class ExercisesAdapter
    : RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {

    private val _exercises = mutableListOf<Exercise>()

    override fun getItemCount(): Int = _exercises.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ExerciseListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(_exercises[position])
    }

    fun submitExercises(items: List<Exercise>) {
        _exercises.clear()
        _exercises.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(
        val binding: ExerciseListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var exerciseItem: Exercise? = null

        fun bind(item: Exercise) {
            exerciseItem = item

            binding.exerciseItemName.text = item.name
            Log.i("ExercisesAdapter", "Muscles ${item.workedMuscles.joinToString { it.name }}")
            binding.exerciseWorkedMuscles.text = item.workedMuscles.joinToString { it.name }
        }
    }
}