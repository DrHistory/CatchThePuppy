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
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_hard_mode.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.imageView
import kotlinx.android.synthetic.main.activity_main.imageView2
import kotlinx.android.synthetic.main.activity_main.imageView3
import kotlinx.android.synthetic.main.activity_main.imageView4
import kotlinx.android.synthetic.main.activity_main.imageView5
import kotlinx.android.synthetic.main.activity_main.imageView6
import kotlinx.android.synthetic.main.activity_main.imageView7
import kotlinx.android.synthetic.main.activity_main.imageView8
import kotlinx.android.synthetic.main.activity_main.imageView9

class HardModeActivity : AppCompatActivity() {
    var score = 0
    var imageArrayList = ArrayList<ImageView>()
    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_mode)

        //ImageArray
        imageArrayList.add(hardimageView)
        imageArrayList.add(hardimageView2)
        imageArrayList.add(hardimageView3)
        imageArrayList.add(hardimageView4)
        imageArrayList.add(hardimageView5)
        imageArrayList.add(hardimageView6)
        imageArrayList.add(hardimageView7)
        imageArrayList.add(hardimageView8)
        imageArrayList.add(hardimageView9)
        imageArrayList.add(hardimageView10)
        imageArrayList.add(hardimageView11)
        imageArrayList.add(hardimageView12)
        imageArrayList.add(hardimageView13)
        imageArrayList.add(hardimageView14)
        imageArrayList.add(hardimageView15)
        imageArrayList.add(hardimageView16)
        imageArrayList.add(hardimageView17)
        imageArrayList.add(hardimageView18)
        imageArrayList.add(hardimageView19)
        imageArrayList.add(hardimageView20)


        //Functions
        countdownTimer()
        hideAndshowImages()

    }

    fun puppyClick(view: View)
    {
        puppySound()
        score ++
        hardscoreText.text = "Score: $score"


    }


    fun countdownTimer()
    {
        object : CountDownTimer(15000 , 1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                hardtimeText.text ="Time:" + millisUntilFinished / 1000
            }

            override fun onFinish() {

                //AlertDialog
                val alert = AlertDialog.Builder(this@HardModeActivity)
                alert.setTitle("Time is Over")
                alert.setMessage("Do you want to play again?")

                //Positive Button
                alert.setPositiveButton("Yes") {dialog , which ->

                    //restart
                    val intent = intent
                    finish()
                    startActivity(intent)
                }

                //Negative Button
                alert.setNegativeButton("No") {dialog, which ->

                    //send to start activity
                    val startintent = Intent(this@HardModeActivity ,StartActivity::class.java)
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
                handler.postDelayed(runnable , 250)

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
        val randomIndex = random.nextInt(20)
        imageArrayList[randomIndex].visibility = View.VISIBLE
    }

    fun puppySound()
    {
        val mediaPlayer = MediaPlayer.create(this,R.raw.puppysound)
        mediaPlayer.start()
    }
}