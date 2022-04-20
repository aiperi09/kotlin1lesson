package kg.geektech.kotlin1lesson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.kotlin1lesson.MainActivity.Companion.KEY
import kg.geektech.kotlin1lesson.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContent()
        btnSend()
    }

    private fun setContent() {
        binding.tvTitleSecond.setText(intent.getStringExtra(KEY).toString())
    }

    private fun btnSend() {
        binding.btnSaveSecond.setOnClickListener {
            if (binding.tvTitleSecond.text.toString().isEmpty()) {
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                val etText = binding.tvTitleSecond.text.toString()
                intent.putExtra(KEY, etText)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}