package com.example.understanding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.understanding.adapters.ViewPagerAdapter
import com.example.understanding.callbacks.LoadChild
import com.example.understanding.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

val names = arrayOf(
    "Series",
    "Movies",
    "Games"
)
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }


}