package me.edujtm.pocketfit.ui.lastworkouts

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.edujtm.pocketfit.R
import me.edujtm.pocketfit.databinding.WorkoutCardBinding
import me.edujtm.pocketfit.domain.entities.*
import me.edujtm.pocketfit.platform.TimePeriod
import me.edujtm.pocketfit.platform.minus
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date

class LastWorkoutsListAdapter : RecyclerView.Adapter<LastWorkoutsListAdapter.ViewHolder>() {

    private val items = listOf<Workout>(
        Workout(1, Date(),  listOf(
            Repetition(1, 2, 10, Exercise(1, "LEG PRESS", listOf(
                Muscle(1, MajorGroup.LEGS, "Quadriceps")
            ))),
            Repetition(1, 2, 5, Exercise(1, "BENCH PRESS", listOf(
                Muscle(1, MajorGroup.ARMS, "Biceps"),
                Muscle(2, MajorGroup.ARMS, "Triceps"),
                Muscle(3, MajorGroup.CHEST, "Pectorals"),
            )))
        )),
        Workout(1, Date().minus(1, TimePeriod.DAY),  listOf(
            Repetition(1, 2, 5, Exercise(1, "LEG PRESS", listOf(
                Muscle(1, MajorGroup.LEGS, "Quadriceps")
            ))),
            Repetition(1, 2, 10, Exercise(1, "BENCH PRESS", listOf(
                Muscle(1, MajorGroup.ARMS, "Biceps"),
                Muscle(2, MajorGroup.ARMS, "Triceps"),
                Muscle(3, MajorGroup.CHEST, "Pectorals"),
            )))
        ))
    )

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = WorkoutCardView(parent.context)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: WorkoutCardView) : RecyclerView.ViewHolder(view) {

        fun bind(workout: Workout) {
            view.workout = workout
            /*
            binding.tvDayOfMonth.text = DateFormat.format("dd", workout.date)
            binding.tvMonthYear.text = "${DateFormat.format("MMM", workout.date)} ${DateFormat.format("yyyy", workout.date)}"
             */
        }
    }
}