package me.edujtm.pocketfit.ui.lastworkouts

import android.content.Context
import android.graphics.Color
import android.text.format.DateFormat
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import me.edujtm.pocketfit.R
import me.edujtm.pocketfit.domain.entities.MajorGroup
import me.edujtm.pocketfit.domain.entities.Workout
import kotlin.math.roundToInt

// TODO: maybe avoid using a custom view and just do everything on the recyclerview adapter
class WorkoutCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr)
{
    private var tvMonthDay: TextView? = null
    private var tvMonthYear: TextView? = null
    private var llWorkoutProportion: LinearLayoutCompat? = null

    var workout: Workout? = null
        set(value) {
            field = value
            update()
            invalidate()
        }

    init {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.workout_card, this)

        tvMonthDay = findViewById(R.id.tv_day_of_month)
        tvMonthYear = findViewById(R.id.tv_month_year)
        llWorkoutProportion = findViewById(R.id.ll_workout_proportions)

        layoutParams = MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            90f.toDIP(resources.displayMetrics).roundToInt(),
        ).apply {
            setMargins(20, 16f.toDIP(resources.displayMetrics).roundToInt(), 20, 0)
            setPadding(16, 8, 16, 8)
        }
    }

    private fun update() {
        workout?.let { wk ->
            tvMonthDay?.text = DateFormat.format("dd", wk.date)
            tvMonthYear?.text = "${DateFormat.format("MMM", wk.date)} ${DateFormat.format("yyyy", wk.date)}"

            // TODO: Move this logic to the Workout class or some WorkoutScoreCalculator
            val scores = mutableMapOf<MajorGroup, Float>()
            wk.repetitions.forEach { rep ->
                val score = rep.score()
                // Divides the score per the proportion of worked muscles
                // in each major group
                for (group in MajorGroup.values()) {
                    val groupMuscle = rep.exercise.workedMuscles.count { it.majorGroup == group }
                    val prop = groupMuscle.toFloat() / rep.exercise.workedMuscles.size
                    Log.i("WorkoutCardView", "Group: $group - Prop: $prop")

                    val currentScore = scores[group] ?: 0f
                    scores[group] = currentScore + prop * score
                }
            }

            val totalScore = scores.values.sum()
            val proportions = scores.mapValues { it.value / totalScore }

            llWorkoutProportion?.let { linearLayout ->
                linearLayout.removeAllViews()

                for ((group, prop) in proportions) {
                    val weight = prop * 100
                    if (weight == 0.0f) {
                        continue
                    }

                    Log.i("WorkoutCardView", "Group: $group - Proportion: $prop")
                    val view = View(context)

                    Log.i("WorkoutCardView", "Calculated weight: $weight")
                    view.layoutParams = LinearLayoutCompat.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        weight
                    )
                    view.setBackgroundColor(Color.parseColor(group.groupColor))

                    linearLayout.addView(view)
                }
            }
        }
    }

    private fun Float.toDIP(metrics: DisplayMetrics): Float {
       return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, metrics)
    }
}
