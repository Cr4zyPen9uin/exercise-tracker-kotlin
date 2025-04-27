package com.example.exercise_tracker_kotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exercise_tracker_kotlin.data.dao.WorkoutDao
import com.example.exercise_tracker_kotlin.data.entity.*

@Database(
    entities = [
        WorkoutEntity::class,
        RoutineEntity::class,
        ExerciseEntity::class,
        RoutineExerciseCrossRef::class,
        WorkoutRoutineCrossRef::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "workout_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}