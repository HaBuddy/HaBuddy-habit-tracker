package com.habit_tracker.backend.entity

import com.habit_tracker.backend.entity.Day

class Habit (
    var habitId: String? = "",
    var name: String = "",
    var description: String? = "",
    var tags: ArrayList<Tag> = arrayListOf(),
    var days: ArrayList<Day> = arrayListOf(),
    var time: Time = Time.NONE,
    var customTime: String? = "",
)