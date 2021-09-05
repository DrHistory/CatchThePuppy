package com.kursatdrhistoryapp.catchthepuppy

import android.animation.Animator
import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class AnimationsClass {

    fun fadeOut(context: Context , imageView: ImageView)
    {
        val anifadeOut = AnimationUtils.loadAnimation(context , R.anim.fadeout)
        imageView.startAnimation(anifadeOut)
    }

    fun fromLeft(context: Context , imageView: ImageView)
    {
        val anifromLeft = AnimationUtils.loadAnimation(context , R.anim.fromleft)
        imageView.startAnimation(anifromLeft)
    }
    fun fromTop(context: Context , imageView: ImageView)
    {
        val animfromTop = AnimationUtils.loadAnimation(context,R.anim.fromtop)
        imageView.startAnimation(animfromTop)
    }
}