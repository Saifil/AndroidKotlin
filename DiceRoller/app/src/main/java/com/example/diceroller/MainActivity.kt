package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // final variable for generated binding class

    // we do not define loose variables like in java, so we set a get() method to this variable
    // which returns the button view (-> R.id.roll_button)
    // now rollButton variable can be accessed anywhere in the file (it is just an alias for binder.rollButton)
//    private val rollButton: Button get() = binding.rollButton

    // Use lateinit keyword to tell the compiler that the variable will be used after initializing
    private lateinit var rollButton: Button
    private lateinit var diceImage: ImageView

    private val NUM_DICE_FACES = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root // root contains the root element in layout (here RelativeLayout)
        setContentView(view)

        initialize()
    }

    private fun initialize() {
        rollButton = binding.rollButton
        rollButton.text = getString(R.string.lets_roll)

        diceImage = binding.diceImage
        rollDice()

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val diceImageResource = when (Random().nextInt(NUM_DICE_FACES) + 1) {
            1    -> R.drawable.dice_1
            2    -> R.drawable.dice_2
            3    -> R.drawable.dice_3
            4    -> R.drawable.dice_4
            5    -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageResource)
    }
}
