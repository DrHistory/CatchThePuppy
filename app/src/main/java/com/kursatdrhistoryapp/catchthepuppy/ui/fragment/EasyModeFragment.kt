package com.kursatdrhistoryapp.catchthepuppy.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.kursatdrhistoryapp.catchthepuppy.R
import com.kursatdrhistoryapp.catchthepuppy.databinding.FragmentEasyModeBinding


class EasyModeFragment : Fragment() {


    private var _binding: FragmentEasyModeBinding? = null
    private val binding get() = _binding!!
    var score = 0
    var imageArrayList = ArrayList<ImageView>()
    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable { }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEasyModeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ImageArray
        imageArrayList.add(binding.imageView)
        imageArrayList.add(binding.imageView2)
        imageArrayList.add(binding.imageView3)
        imageArrayList.add(binding.imageView4)
        imageArrayList.add(binding.imageView5)
        imageArrayList.add(binding.imageView6)
        imageArrayList.add(binding.imageView7)
        imageArrayList.add(binding.imageView8)
        imageArrayList.add(binding.imageView9)

        //Functions
        coundownTimer(view)
        hideAndshowImages()
        puppyClick()


    }

    fun puppyClick() {
        binding.imageView.setOnClickListener { addScore() }
        binding.imageView2.setOnClickListener { addScore() }
        binding.imageView3.setOnClickListener { addScore() }
        binding.imageView4.setOnClickListener { addScore() }
        binding.imageView5.setOnClickListener { addScore() }
        binding.imageView6.setOnClickListener { addScore() }
        binding.imageView7.setOnClickListener { addScore() }
        binding.imageView8.setOnClickListener { addScore() }
        binding.imageView9.setOnClickListener { addScore() }
    }

    fun addScore() {
        puppySound()
        score++
        binding.scoreText.text = "Score: $score"
    }

    fun coundownTimer(view: View) {
        object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time:" + millisUntilFinished / 1000
            }

            override fun onFinish() {
                //Stop Handler
                handler.removeCallbacks(runnable)
                //Hide Images
                hideImages()
                val action = EasyModeFragmentDirections.actionEasyModeFragmentToResultFragment(score)
                Navigation.findNavController(view).navigate(action)
            }
        }.start()
    }

    fun hideAndshowImages() {
        runnable = Runnable { //Hide
            hideImages()

            //Show
            showImages()

            //Handler
            handler.postDelayed(runnable, 500)
        }
        handler.post(runnable)

    }

    fun hideImages() {

        for (image in imageArrayList) {
            image.visibility = View.INVISIBLE
        }
    }

    fun showImages() {
        val random = java.util.Random()
        val randomIndex = random.nextInt(9)
        imageArrayList[randomIndex].visibility = View.VISIBLE
    }

    fun puppySound() {
        val mediaPlayer = MediaPlayer.create(activity, R.raw.puppysound)
        mediaPlayer.start()
    }

}