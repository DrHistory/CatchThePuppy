package com.kursatdrhistoryapp.catchthepuppy

import android.animation.Animator
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    val animation = AnimationsClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        animations()

    }


    fun easyClick (view: View)
    {
        clickSound()
        animation.fadeOut(this,easymodeBtn)
        val intent = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intent)

    }

    fun hardClick (view: View)
    {
        clickSound()
        animation.fadeOut(this,hardmodeBtn)
        val intent = Intent(this, HardModeActivity::class.java)
        finish()
        startActivity(intent)

    }

    fun clickSound()
    {
       val mediaPlayer = MediaPlayer.create(this,R.raw.buttonsound)
       mediaPlayer.start()
    }

    fun animations ()
    {
        animation.fromLeft(this,easymodeBtn)
        animation.fromLeft(this,hardmodeBtn)
        animation.fromTop(this,iconImage)
        animation.fadeOut(this,nameImage)
    }
}