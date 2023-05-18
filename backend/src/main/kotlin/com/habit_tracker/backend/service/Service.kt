package com.habit_tracker.backend.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.*
import com.google.firebase.cloud.FirestoreClient
import com.habit_tracker.backend.entity.Habit
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class Service {
    companion object {
        const val HABIT_COLLECTION_NAME = "habits"
        const val TASK_COLLECTION_NAME = "tasks"
    }

    fun saveHabit(habit: Habit): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val docRef: DocumentReference = dbFirestore.collection(HABIT_COLLECTION_NAME).document()

        // autogenerate id from firebase and set object id
        val docId: String = docRef.id
        habit.habitId = docId

        val result: ApiFuture<WriteResult> = docRef.set(habit)

        return docId
    }

    fun getHabit(habitId: String): Habit? {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val docRef: DocumentReference = dbFirestore.collection(HABIT_COLLECTION_NAME).document(habitId)
        val future: ApiFuture<DocumentSnapshot> = docRef.get()
        val document: DocumentSnapshot = future.get()

        var habit: Habit? = null

        if (document.exists()) {
            habit = document.toObject(Habit::class.java)

            return habit
        }

        return null
    }
    fun getAllHabits(): ArrayList<Habit> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val colRef: CollectionReference = dbFirestore.collection(HABIT_COLLECTION_NAME)
        val future: ApiFuture<QuerySnapshot> = colRef.get()

        val documents: List<QueryDocumentSnapshot> = future.get().documents

        val habitList: ArrayList<Habit> = ArrayList<Habit>()

        for (document in documents) {
            val habitObject: Habit = document.toObject(Habit::class.java)
            habitList.add(habitObject)
        }

        return habitList
    }

    fun getAllHabitsByDate(date: Date): ArrayList<Habit> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val colRef: CollectionReference = dbFirestore.collection(HABIT_COLLECTION_NAME)
        val future: ApiFuture<QuerySnapshot> = colRef.get()

        val documents: List<QueryDocumentSnapshot> = future.get().documents

        val habitList: ArrayList<Habit> = ArrayList<Habit>()

        for (document in documents) {
            val habitObject: Habit = document.toObject(Habit::class.java)
            habitList.add(habitObject)
        }

        return habitList
    }

}