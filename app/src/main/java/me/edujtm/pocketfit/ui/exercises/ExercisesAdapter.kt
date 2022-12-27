package me.edujtm.pocketfit.ui.exercises

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.shape.ShapeAppearanceModel
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

            binding.exerciseItemName.text = item.name.uppercase()
            Log.i("ExercisesAdapter", "Muscles ${item.workedMuscles.joinToString { it.name }}")

            binding.musclesChipGroup.removeAllViews()
            item.workedMuscles.forEach { muscle ->
                val chip = Chip(binding.root.context).apply {
                    text = muscle.name
                    setTypeface(typeface, Typeface.BOLD)

                    isCloseIconVisible = false
                    chipBackgroundColor = ColorStateList.valueOf(0xFFFFFF)
                    chipStrokeColor = ColorStateList.valueOf(Color.parseColor(muscle.majorGroup.groupColor))
                    chipStrokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        1F, binding.root.context.resources.displayMetrics)

                    updatePadding(top = 4, bottom = 4)
                }
                binding.musclesChipGroup.addView(chip)
            }
        }
    }
}