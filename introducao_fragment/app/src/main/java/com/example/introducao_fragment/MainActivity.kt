package com.example.introducao_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.introducao_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment1.setOnClickListener{
            trocarFragment(1)
        }

        binding.btnFragment2.setOnClickListener{
            trocarFragment(2)
        }

        binding.btnFragment3.setOnClickListener{
            trocarFragment(3)
        }
    }

    private fun trocarFragment(frag: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        val container = binding.fragmentContentView.id

        val bundle = bundleOf("EMAIL" to "usuario@email.com")
        val fragment2 = Fragment2()
        fragment2.arguments = bundle
        when (frag) {
            1 -> transaction.replace(container, Fragment1())
            2 -> transaction.replace(container, fragment2)
            else -> transaction.replace(container, Fragment3())
        }
        transaction.commit()

    }
}