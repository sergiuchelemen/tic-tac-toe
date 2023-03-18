package com.example.tictactoe
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class CustomDialogFragment(private val activity: Activity, private var box1: ImageView, private var box2: ImageView, private var box3: ImageView,
                           private var box4: ImageView, private var box5: ImageView, private var box6: ImageView,
                           private var box7: ImageView, private var box8: ImageView, private var box9: ImageView): DialogFragment() {
    private lateinit var message: TextView
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var menu: Button
    private lateinit var newGame: Button
    private val handler = android.os.Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = true
        val view = inflater.inflate(R.layout.winner_dialog, container, false)
        message = view.findViewById(R.id.winner)
        score1 = view.findViewById(R.id.score1)
        score2 = view.findViewById(R.id.score2)
        menu = view.findViewById(R.id.button3)
        newGame = view.findViewById(R.id.button2)

        menu.setOnClickListener {
            val activity = activity
            if (!activity.isFinishing) {
                activity.finish()
            }
            val menuActivity = requireActivity()
            menuActivity.finish()
            val intent = Intent(activity, MainActivity::class.java)
            menuActivity.startActivity(intent)
        }
        newGame.setOnClickListener {
            dismiss()
            box1.isClickable = true
            box1.setImageDrawable(null)
            box2.isClickable = true
            box2.setImageDrawable(null)
            box3.isClickable = true
            box3.setImageDrawable(null)
            box4.isClickable = true
            box4.setImageDrawable(null)
            box5.isClickable = true
            box5.setImageDrawable(null)
            box6.isClickable = true
            box6.setImageDrawable(null)
            box7.isClickable = true
            box7.setImageDrawable(null)
            box8.isClickable = true
            box8.setImageDrawable(null)
            box9.isClickable = true
            box9.setImageDrawable(null)
        }
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return view
    }
    fun setTextViewText(winner: String) {
        handler.post {
            message.text = winner
        }
    }
    fun setScore1(player: String) {
        handler.post{
            score1.text = player
        }
    }
    fun setScore2(player: String) {
        handler.post{
            score2.text = player
        }
    }
}

