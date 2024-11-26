package com.example.mad_practical_6_22012011058

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    private lateinit var guniAnimation: AnimationDrawable
    private lateinit var tweenAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgView = findViewById<ImageView>(R.id.uvpce_imgview)
        imgView.setBackgroundResource(R.drawable.uvpce_animation_list)
        guniAnimation = imgView.background as AnimationDrawable
        tweenAnimation = AnimationUtils.loadAnimation(this, R.anim.tween)
        tweenAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            guniAnimation.start()
            findViewById<ImageView>(R.id.uvpce_imgview).startAnimation(tweenAnimation)
        }
        else{
            guniAnimation.stop()
        }
    }

    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }
}