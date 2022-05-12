package com.neocaptainnemo.secondmaterialapp12thmay

import android.content.ContextWrapper
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_THEME = "KEY_THEME"
    }

    private var savedTheme: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        AppCompatDelegate.setDefaultNightMode()

        savedInstanceState?.getInt(KEY_THEME, -1)
            ?.takeIf {
                it != -1
            }?.let {
                setTheme(it)
            }

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.theme1).setOnClickListener {
            savedTheme = R.style.Theme_SecondMaterialApp12thMay

            recreate()
        }

        findViewById<Button>(R.id.theme2).setOnClickListener {
            savedTheme = R.style.Theme_SecondMaterialApp12thMay2

            recreate()
        }

        findViewById<TextInputLayout>(R.id.text_input).error = "Error"


        val container: LinearLayout = findViewById(R.id.container)

        val contextWrapper = ContextThemeWrapper(this, R.style.CustomButton)

        val button = MaterialButton(contextWrapper)

        container.addView(button)


//        window.statusBarColor = Color.BLACK
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        savedTheme?.let {
            outState.putInt(KEY_THEME, it)
        }

    }
}