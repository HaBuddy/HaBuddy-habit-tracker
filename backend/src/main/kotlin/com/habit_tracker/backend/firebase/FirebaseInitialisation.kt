package com.habit_tracker.backend.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import javax.annotation.PostConstruct

@Service
class FirebaseInitialisation {

    @PostConstruct
    fun initialisation() {
        val serviceAccount = FileInputStream("./serviceAccountKey.json")
        val credentials = GoogleCredentials.fromStream(serviceAccount)

        val options = FirebaseOptions.Builder()
            .setCredentials(credentials)
            .build()

        FirebaseApp.initializeApp(options)
    }
}