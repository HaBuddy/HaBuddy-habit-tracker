package com.habit_tracker.backend.entity

import jakarta.persistence.Id
import java.util.*
import kotlin.collections.ArrayList

class Task (
    var taskId: String?,
    var name: String,
    var description: String?,
    var tags: ArrayList<Tag>,
    var datetime: Date
) {}