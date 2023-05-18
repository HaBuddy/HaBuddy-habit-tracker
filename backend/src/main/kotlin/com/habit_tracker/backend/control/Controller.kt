package com.habit_tracker.backend.control

import com.habit_tracker.backend.entity.Habit
import com.habit_tracker.backend.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/api")
class Controller(@Autowired val service: Service) {

    @PostMapping("/habits/create")
    fun saveHabit(@RequestBody habit: Habit): String {
        return service.saveHabit(habit)
    }

    @GetMapping("/habits/{habitId}")
    fun getHabit(@PathVariable("habitId") habitId: String): Habit? {
        return service.getHabit(habitId)
    }

    @GetMapping("/habits")
    fun getAllHabits(): ArrayList<Habit> {
        return service.getAllHabits()
    }

//    @GetMapping("/habits")
//    fun getAllHabitsByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") date: Date): ArrayList<Habit> {
//        return service.getAllHabitsByDate(date)
//    }

}