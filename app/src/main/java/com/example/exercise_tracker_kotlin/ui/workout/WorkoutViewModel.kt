// app/src/main/java/com/example/exercise_tracker_kotlin/ui/workout/WorkoutViewModel.kt
package com.example.exercise_tracker_kotlin.ui.workout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise_tracker_kotlin.data.AppDatabase
import com.example.exercise_tracker_kotlin.model.Workout
import com.example.exercise_tracker_kotlin.repository.WorkoutRepository
import com.example.exercise_tracker_kotlin.repository.WorkoutRepositoryImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WorkoutRepository

    val workouts: StateFlow<List<Workout>>

    init {
        val workoutDao = AppDatabase.getDatabase(application).workoutDao()
        repository = WorkoutRepositoryImpl(workoutDao)
        workouts = repository.getAllWorkouts()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    fun addWorkout(workout: Workout) {
        viewModelScope.launch {
            repository.insertWorkout(workout)
        }
    }

    fun updateWorkout(workout: Workout) {
        viewModelScope.launch {
            repository.updateWorkout(workout)
        }
    }

    fun deleteWorkout(workout: Workout) {
        viewModelScope.launch {
            repository.deleteWorkout(workout)
        }
    }
}