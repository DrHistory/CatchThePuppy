package com.kursatdrhistoryapp.catchthepuppy

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

var score = 0
var imageArrayList = ArrayList<ImageView>()
var handler = Handler(Looper.getMainLooper())
var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageArray
        imageArrayList.add(imageView)
        imageArrayList.add(imageView2)
        imageArrayList.add(imageView3)
        imageArrayList.add(imageView4)
        imageArrayList.add(imageView5)
        imageArrayList.add(imageView6)
        imageArrayList.add(imageView7)
        imageArrayList.add(imageView8)
        imageArrayList.add(imageView9)

        //Functions
        coundownTimer()
        hideAndshowImages()

    }

        fun puppyClick(view: View)
        {
            puppySound()
            score ++
            scoreText.text = "Score: $score"
        }


        fun coundownTimer()
        {
            object : CountDownTimer(15000 , 1000)
            {
                override fun onTick(millisUntilFinished: Long) {
                    timeText.text ="Time:" + millisUntilFinished / 1000
                }

                override fun onFinish() {

                    //AlertDialog
                    val alert = AlertDialog.Builder(this@MainActivity)
                    alert.setTitle("Time is Over")
                    alert.setMessage("Do you want to play again?")
                    alert.setPositiveButton("Yes") {dialog , which ->
                        //restart
                        val intent = intent
                        finish()
                        startActivity(intent)
                    }

                    alert.setNegativeButton("No") {dialog, which ->

                        //send to start activity
                        val startintent = Intent(this@MainActivity ,StartActivity::class.java)
                        finish()
                        startActivity(startintent)

                    }

                    alert.show()

                    //Stop Handler
                    handler.removeCallbacks(runnable)

                    //Hide Images

                    hideImages()

                }

            }.start()
        }

        fun hideAndshowImages()
        {
            runnable = object : Runnable
            {
                override fun run()
                {

                    //Hide
                    hideImages()

                    //Show
                    showImages()

                    //Handler
                    handler.postDelayed(runnable , 500)
                    
                }
            }
            handler.post(runnable)

        }


    fun hideImages()
    {

        for (image in imageArrayList)
        {
            image.visibility = View.INVISIBLE
        }
    }

    fun showImages()
    {
        val random = java.util.Random()
        val randomIndex = random.nextInt(9)
        imageArrayList[randomIndex].visibility = View.VISIBLE
    }

    fun puppySound()
    {
        val mediaPlayer = MediaPlayer.create(this,R.raw.puppysound)
        mediaPlayer.start()
    }

}