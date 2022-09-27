package com.example.a7mintuesworkout

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingjacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingjacks)
        val lunge = ExerciseModel(
            2,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunge)
        val plank = ExerciseModel(
            3,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)
        val pushup = ExerciseModel(
            4,
            "Push Up",
            R.drawable.ic_push_up,
            false,
            false
        )
        exerciseList.add(pushup)
        val sideplank = ExerciseModel(
            5,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sideplank)
        val squat = ExerciseModel(
            6,
            "Squat",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)
        val pushupRotation  = ExerciseModel(
            7,
            "Push Up Rotation",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        )
        exerciseList.add(pushupRotation)
        val stepup = ExerciseModel(
            8,
            "Step Up",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        )
        exerciseList.add(stepup)
        val triceps = ExerciseModel(
            9,
            "Triceps Dip",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        )
        exerciseList.add(triceps)
        val wallsit = ExerciseModel(
            10,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            false,
            false
        )
        exerciseList.add(wallsit)
        val abdominal = ExerciseModel(
            11,
            "Abdominal",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominal)
        val highknees = ExerciseModel(
            12,
            "High Knees Running",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highknees)
        return exerciseList
    }
}