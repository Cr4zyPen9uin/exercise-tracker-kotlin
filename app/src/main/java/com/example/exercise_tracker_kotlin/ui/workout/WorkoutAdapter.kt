// app/src/main/java/com/example/exercise_tracker_kotlin/ui/workout/WorkoutAdapter.kt
package com.example.exercise_tracker_kotlin.ui.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_tracker_kotlin.databinding.ItemWorkoutBinding
import com.example.exercise_tracker_kotlin.model.Workout

class WorkoutAdapter(
    var workouts: List<Workout>,
    private val onWorkoutClick: (Workout) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    inner class WorkoutViewHolder(private val binding: ItemWorkoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(workout: Workout) {
            binding.workoutName.text = workout.name
            binding.workoutDescription.text = workout.description
            binding.root.setOnClickListener { onWorkoutClick(workout) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ItemWorkoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(workouts[position])
    }

    override fun getItemCount(): Int = workouts.size
}