package com.example.tictactoe

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val firstPlayer = intent.getStringExtra("EXTRA_NAME1")
        val secondPlayer = intent.getStringExtra("EXTRA_NAME2")
        var score1 = 0
        var score2 = 0
        val box1 = findViewById<ImageView>(R.id.box1)
        val box2 = findViewById<ImageView>(R.id.box2)
        val box3 = findViewById<ImageView>(R.id.box3)
        val box4 = findViewById<ImageView>(R.id.box5)
        val box5 = findViewById<ImageView>(R.id.box6)
        val box6 = findViewById<ImageView>(R.id.box4)
        val box7 = findViewById<ImageView>(R.id.box9)
        val box8 = findViewById<ImageView>(R.id.box7)
        val box9 = findViewById<ImageView>(R.id.box8)
        val tabel1 = findViewById<ImageView>(R.id.tabel1)
        val tabelText = findViewById<TextView>(R.id.tabeltext)
        val tabel2 = findViewById<ImageView>(R.id.tabel2)
        val tabelText2 = findViewById<TextView>(R.id.tabeltext2)
        val tabelBorder1 = findViewById<ConstraintLayout>(R.id.constraintLayout2)
        val gradientDrawable1 = tabelBorder1.background as GradientDrawable
        val tabelBorder2 = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val gradientDrawable2 = tabelBorder2.background as GradientDrawable
        gradientDrawable1.setStroke(8, Color.BLACK)
        var boxes = arrayOf(intArrayOf(-1, -1, -1), intArrayOf(-1, -1, -1), intArrayOf(-1, -1, -1))
        var turn = 1
        var round = 1
        var winner: String
        tabel1.setImageResource(R.drawable.icone_fermer_et_x_jaune)
        tabel2.setImageResource(R.drawable._p2onf_circle_picture)
        tabelText.text = "$firstPlayer"
        tabelText2.text = "$secondPlayer"
        val dialog =
            CustomDialogFragment(this, box1, box2, box3, box4, box5, box6, box7, box8, box9)

        box1.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box1.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[0][0] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box1.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[0][0] = 0
                turn = 1
            }
            box1.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    round += 1
                    turn = 1
                    TabelSettings.changeIcons(
                        round,
                        tabel1,
                        tabel2,
                        gradientDrawable1,
                        gradientDrawable2
                    )
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                }else {
                    if (Check.draw(boxes)) {
                        score1 += 1
                        score2 += 1
                        dialog.show(supportFragmentManager, "customDialog")
                        dialog.setTextViewText("Draw!")
                        dialog.setScore2("$secondPlayer: $score2")
                        dialog.setScore1("$firstPlayer: $score1")
                        TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                        round += 1
                        turn = 1
                        boxes = arrayOf(
                            intArrayOf(-1, -1, -1),
                            intArrayOf(-1, -1, -1),
                            intArrayOf(-1, -1, -1)
                        )
                    }
                }
            }
        box2.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box2.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[0][1] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box2.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[0][1] = 0
                turn = 1
            }
            box2.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box3.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box3.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[0][2] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box3.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[0][2] = 0
                turn = 1
            }
            box3.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!

                    } else {
                        score2 += 1
                        winner = secondPlayer!!

                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            } else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box4.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box4.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[1][0] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box4.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[1][0] = 0
                turn = 1
            }
            box4.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box5.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box5.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[1][1] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box5.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[1][1] = 0
                turn = 1
            }
            box5.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box6.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box6.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[1][2] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box6.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[1][2] = 0
                turn = 1
            }
            box6.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box7.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box7.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[2][0] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box7.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[2][0] = 0
                turn = 1
            }
            box7.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box8.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box8.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[2][1] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box8.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[2][1] = 0
                turn = 1
            }
            box8.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
        box9.setOnClickListener {
            if (turn == 1) {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }
                box9.setImageResource(R.drawable.icone_fermer_et_x_jaune)
                boxes[2][2] = 1
                turn = 0
            } else {
                if(round % 2 == 1){
                    gradientDrawable1.setStroke(8, Color.BLACK)
                    gradientDrawable2.setStroke(0, Color.BLACK)
                }else{
                    gradientDrawable1.setStroke(0, Color.BLACK)
                    gradientDrawable2.setStroke(8, Color.BLACK)
                }
                box9.setImageResource(R.drawable._p2onf_circle_picture)
                boxes[2][2] = 0
                turn = 1
            }
            box9.isClickable = false
            if (Check.checkForX(boxes) || Check.checkForY(boxes)) {
                if (Check.checkForX(boxes)) {
                    if (round % 2 == 1) {
                        score1 += 1
                        winner = firstPlayer!!
                    } else {
                        score2 += 1
                        winner = secondPlayer!!
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    turn = 1
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore1("$firstPlayer: $score1")
                    dialog.setScore2("$secondPlayer: $score2")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
                if (Check.checkForY(boxes)) {
                    if (round % 2 == 1) {
                        winner = secondPlayer!!
                        score2 += 1
                    } else {
                        winner = firstPlayer!!
                        score1 += 1
                    }
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("$winner wins!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }else {
                if (Check.draw(boxes)) {
                    score1 += 1
                    score2 += 1
                    dialog.show(supportFragmentManager, "customDialog")
                    dialog.setTextViewText("Draw!")
                    dialog.setScore2("$secondPlayer: $score2")
                    dialog.setScore1("$firstPlayer: $score1")
                    TabelSettings.changeIcons(round, tabel1, tabel2, gradientDrawable1, gradientDrawable2)
                    round += 1
                    turn = 1
                    boxes = arrayOf(
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1),
                        intArrayOf(-1, -1, -1)
                    )
                }
            }
        }
    }
}



