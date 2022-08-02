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
import com.kursatdrhistoryapp.catchthepuppy.databinding.FragmentHardModeBinding


class HardModeFragment : Fragment() {

    private var _binding: FragmentHardModeBinding? = null
    private val binding get() = _binding!!
    var score = 0
    var imageArrayList = ArrayList<ImageView>()
    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable { }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHardModeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ImageArray
        imageArrayList.add(binding.hardimageView)
        imageArrayList.add(binding.hardimageView2)
        imageArrayList.add(binding.hardimageView3)
        imageArrayList.add(binding.hardimageView4)
        imageArrayList.add(binding.hardimageView5)
        imageArrayList.add(binding.hardimageView6)
        imageArrayList.add(binding.hardimageView7)
        imageArrayList.add(binding.hardimageView8)
        imageArrayList.add(binding.hardimageView9)
        imageArrayList.add(binding.hardimageView10)
        imageArrayList.add(binding.hardimageView11)
        imageArrayList.add(binding.hardimageView12)
        imageArrayList.add(binding.hardimageView13)
        imageArrayList.add(binding.hardimageView14)
        imageArrayList.add(binding.hardimageView15)
        imageArrayList.add(binding.hardimageView16)
        imageArrayList.add(binding.hardimageView17)
        imageArrayList.add(binding.hardimageView18)
        imageArrayList.add(binding.hardimageView19)
        imageArrayList.add(binding.hardimageView20)
        //Functions
        coundownTimer(view)
        hideAndshowImages()
        puppyClick()
    }

    fun puppyClick() {
        binding.hardimageView.setOnClickListener { addScore() }
        binding.hardimageView2.setOnClickListener { addScore() }
        binding.hardimageView3.setOnClickListener { addScore() }
        binding.hardimageView4.setOnClickListener { addScore() }
        binding.hardimageView5.setOnClickListener { addScore() }
        binding.hardimageView6.setOnClickListener { addScore() }
        binding.hardimageView7.setOnClickListener { addScore() }
        binding.hardimageView8.setOnClickListener { addScore() }
        binding.hardimageView9.setOnClickListener { addScore() }
        binding.hardimageView10.setOnClickListener { addScore() }
        binding.hardimageView11.setOnClickListener { addScore() }
        binding.hardimageView12.setOnClickListener { addScore() }
        binding.hardimageView13.setOnClickListener { addScore() }
        binding.hardimageView14.setOnClickListener { addScore() }
        binding.hardimageView15.setOnClickListener { addScore() }
        binding.hardimageView16.setOnClickListener { addScore() }
        binding.hardimageView17.setOnClickListener { addScore() }
        binding.hardimageView18.setOnClickListener { addScore() }
        binding.hardimageView19.setOnClickListener { addScore() }
        binding.hardimageView20.setOnClickListener { addScore() }
    }

    fun addScore() {
        puppySound()
        score++
        binding.scoreText.text = "Score: $score"
    }

    fun coundownTimer(view:View) {
        object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time:" + millisUntilFinished / 1000
            }

            override fun onFinish() {
                //Stop Handler
                handler.removeCallbacks(runnable)
                //Hide Images
                hideImages()
                val action = HardModeFragmentDirections.actionHardModeFragmentToResultFragment(score)
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