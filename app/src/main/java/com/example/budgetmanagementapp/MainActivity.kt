package com.example.budgetmanagementapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.budgetmanagementapp.ui.theme.BudgetManagementAppTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.sql.Types.NULL

class MainActivity : ComponentActivity() {

    lateinit var auth:FirebaseAuth
    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var user : FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        button = findViewById(R.id.logout)
        textView = findViewById(R.id.userdetails)
        // !! - NULL asserted call
        if (auth.currentUser == null){
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
        else {
            user = auth.currentUser!!
            textView.text = user.email
        }

        button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
