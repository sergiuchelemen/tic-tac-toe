package com.example.tictactoe

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.ImageView

class TabelSettings {
    companion object{
        fun changeIcons(round: Int, tabel1: ImageView, tabel2: ImageView, gradientDrawable1: GradientDrawable, gradientDrawable2: GradientDrawable){
            if(round % 2 == 1){
                tabel1.setImageResource(R.drawable._p2onf_circle_picture)
                tabel2.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                gradientDrawable1.setStroke(0, Color.BLACK)
                gradientDrawable2.setStroke(8, Color.BLACK)
            }else{
                tabel1.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                tabel2.setImageResource(R.drawable._p2onf_circle_picture)
                gradientDrawable1.setStroke(8, Color.BLACK)
                gradientDrawable2.setStroke(0, Color.BLACK)
            }
        }
    }

}