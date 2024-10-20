package com.example.app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var resendConfirmationButton: Button
    private lateinit var deleteAccountButton: TextView // Changed to TextView
    private lateinit var editProfileButton: TextView
    private lateinit var backButton: ImageView
    private var isEditMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Log.d("ProfileActivity", "ProfileActivity created")

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        dobEditText = findViewById(R.id.dobEditText)
        genderEditText = findViewById(R.id.genderEditText)
        resendConfirmationButton = findViewById(R.id.resendConfirmationButton)
        deleteAccountButton = findViewById(R.id.deleteAccountTextView) // Correct reference
        editProfileButton = findViewById(R.id.editProfileButton)
        backButton = findViewById(R.id.backButton)

        // Handle Back Button click
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Handle Edit button click
        editProfileButton.setOnClickListener {
            toggleEditMode()
        }

        // Handle Resend Confirmation button click
        resendConfirmationButton.setOnClickListener {
            Toast.makeText(this, "Confirmation email resent", Toast.LENGTH_SHORT).show()
        }

        // Handle Delete Account button click
        deleteAccountButton.setOnClickListener {
            Toast.makeText(this, "Account deletion requested", Toast.LENGTH_SHORT).show()
        }
    }

    private fun toggleEditMode() {
        isEditMode = !isEditMode
        nameEditText.isEnabled = isEditMode
        emailEditText.isEnabled = isEditMode
        phoneEditText.isEnabled = isEditMode
        dobEditText.isEnabled = isEditMode
        genderEditText.isEnabled = isEditMode

        if (isEditMode) {
            editProfileButton.text = "SAVE"
        } else {
            editProfileButton.text = "EDIT"
            // Save the updated profile (You can add your save logic here)
            Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
        }
    }
}
