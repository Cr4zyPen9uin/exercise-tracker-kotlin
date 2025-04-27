// app/src/main/java/com/example/exercise_tracker_kotlin/ui/workout/WorkoutListFragment.kt
package com.example.exercise_tracker_kotlin.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.exercise_tracker_kotlin.databinding.FragmentWorkoutListBinding
import kotlinx.coroutines.launch

class WorkoutListFragment : Fragment() {
    private var _binding: FragmentWorkoutListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WorkoutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WorkoutAdapter(emptyList()) { workout ->
            // Handle workout click
        }
        binding.workoutRecyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.workouts.collect { workouts ->
                adapter.apply {
                    (binding.workoutRecyclerView.adapter as WorkoutAdapter).apply {
                        this.workouts = workouts
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}