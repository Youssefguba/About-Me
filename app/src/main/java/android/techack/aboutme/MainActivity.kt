package android.techack.aboutme

import android.content.Context
import android.os.Bundle
import android.techack.aboutme.databinding.ActivityMainBinding
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName(name = "Youssef Ahmed")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        //  This is First Way
        //  binding.nicknameText.text = binding.editText.text
        //  binding.editText.visibility = View.GONE
        //  binding.doneButton.visibility = View.GONE
        //  binding.nicknameText.visibility = View.VISIBLE

        //This is Second Way
        binding.apply {
        // nicknameText.text = binding.editText.text
            myName?.nickname = editText.text.toString()
            invalidateAll()  // ->  To Refresh UI with new Data
            editText.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
