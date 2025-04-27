package com.example.exercise_tracker_kotlin.data.dao

import androidx.room.*
import com.example.exercise_tracker_kotlin.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Insert
    suspend fun insertWorkout(workout: WorkoutEntity): Long

    @Delete
    suspend fun deleteWorkout(workout: WorkoutEntity)

    @Update
    suspend fun updateWorkout(workout: WorkoutEntity)

    @Query("SELECT * FROM workouts")
    fun getAllWorkouts(): Flow<List<WorkoutEntity>>

    @Query("SELECT * FROM workouts WHERE id = :id")
    suspend fun getWorkoutById(id: Long): WorkoutEntity?
}