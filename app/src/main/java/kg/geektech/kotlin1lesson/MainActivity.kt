package kg.geektech.kotlin1lesson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin1lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val KEY = "key"
    }

    private lateinit var binding: ActivityMainBinding

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val data = it.data?.getStringExtra(KEY)
                binding.etTitle.setText(data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnSend()
    }

    private fun btnSend() {
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.toString().isEmpty()) {
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                val etText = binding.etTitle.text.toString()
                intent.putExtra(KEY, etText)
                startActivityForResult.launch(intent)
            }
        }
    }
}