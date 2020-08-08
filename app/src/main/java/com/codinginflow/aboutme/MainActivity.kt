package com.codinginflow.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codinginflow.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * Variable for binding object
     */
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Vidyesh Churi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /**
         * Set value of myName variable
         */
        binding.myName = myName

        /**
         * Set Click listener for button
         */
        /*findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }*/
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        /*val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE*/

        binding.apply {
            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        /**
         * Hide the soft keyboard.
         */
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}