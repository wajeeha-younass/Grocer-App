package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfileSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup) // Ensure this layout file exists

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val houseInput = findViewById<EditText>(R.id.houseInput)
        val blockInput = findViewById<EditText>(R.id.blockInput)
        val streetInput = findViewById<EditText>(R.id.streetInput)
        val nearbyPlaceInput = findViewById<EditText>(R.id.nearbyPlaceInput)

        val homeButton = findViewById<Button>(R.id.homeButton)
        val officeButton = findViewById<Button>(R.id.officeButton)
        val otherButton = findViewById<Button>(R.id.otherButton)

        val saveButton = findViewById<Button>(R.id.saveButton)

        // Set up location label buttons
        homeButton.setOnClickListener {
            setButtonActive(homeButton, officeButton, otherButton)
        }

        officeButton.setOnClickListener {
            setButtonActive(officeButton, homeButton, otherButton)
        }

        otherButton.setOnClickListener {
            setButtonActive(otherButton, homeButton, officeButton)
        }

        // Save button functionality
        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val house = houseInput.text.toString()
            val block = blockInput.text.toString()
            val street = streetInput.text.toString()
            val nearbyPlace = nearbyPlaceInput.text.toString()

            // Validate inputs
            if (name.isNotEmpty() && house.isNotEmpty() && block.isNotEmpty()) {
                Toast.makeText(this, "Information saved successfully!", Toast.LENGTH_SHORT).show()

                // Navigate to the next activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Call finish() to prevent going back to this activity
            } else {
                Toast.makeText(this, "Please fill all required fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setButtonActive(activeButton: Button, inactiveButton1: Button, inactiveButton2: Button) {
        activeButton.setBackgroundResource(R.drawable.button_active) // Custom drawable for active state
        inactiveButton1.setBackgroundResource(R.drawable.button_inactive) // Custom drawable for inactive state
        inactiveButton2.setBackgroundResource(R.drawable.button_inactive)
    }
}
