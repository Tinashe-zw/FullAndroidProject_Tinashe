package com.example.tinashe2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentSwitchingActivity : AppCompatActivity() {

    private var showingFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_switching)

        // Initial Fragment
        replaceFragment(FragmentA())

        val switchButton: Button = findViewById(R.id.switchButton)
        switchButton.setOnClickListener {
            if (showingFragmentA) {
                replaceFragment(FragmentB())
            } else {
                replaceFragment(FragmentA())
            }
            showingFragmentA = !showingFragmentA
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
