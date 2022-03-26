package com.voltaire.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import com.voltaire.jogodavelha.models.BtnInfo
import com.voltaire.jogodavelha.models.Player

class MainActivity : AppCompatActivity() {

    private lateinit var gb1: Button
    private lateinit var gb2: Button
    private lateinit var gb3: Button
    private lateinit var gb4: Button
    private lateinit var gb5: Button
    private lateinit var gb6: Button
    private lateinit var gb7: Button
    private lateinit var gb8: Button
    private lateinit var gb9: Button


    private lateinit var btn1: BtnInfo
    private lateinit var btn2 : BtnInfo
    private lateinit var btn3 : BtnInfo
    private lateinit var btn4 : BtnInfo
    private lateinit var btn5 : BtnInfo
    private lateinit var btn6 : BtnInfo
    private lateinit var btn7 : BtnInfo
    private lateinit var btn8 : BtnInfo
    private lateinit var btn9 : BtnInfo



    private var lastReturn: String? = null
    private var firstReturn: String? = null


    val playerOne = Player("Player 1", 0)
    val playerTwo = Player("Player 2", 0)

    val playerPlay1 = mutableListOf<Int>()
    val playerPlay2 = mutableListOf<Int>()

    private lateinit var playerOneName: TextView
    private lateinit var winsCountPlayerOne: TextView

    private lateinit var winMessage: TextView
    private lateinit var BtnplayAgain: Button

    private lateinit var player_name_1: TextView
    private lateinit var player_name_2: TextView

    private lateinit var playerTwoName: TextView
    private lateinit var winsCountPlayerTwo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player_name_1 = findViewById(R.id.player_name_1)

        val first_player = intent.getStringExtra("nome_first")
        val second_player = intent.getStringExtra("nome_second")

        if (first_player != "" && second_player != "") {
            playerOne.nome = first_player.toString()
            playerTwo.nome = second_player.toString()
        }

        setInfoPlayers()


        winMessage = findViewById(R.id.win_message)
        BtnplayAgain = findViewById(R.id.play_again)


        gb1 = findViewById(R.id.game_box_1)
        gb2 = findViewById(R.id.game_box_2)
        gb3 = findViewById(R.id.game_box_3)
        gb4 = findViewById(R.id.game_box_4)
        gb5 = findViewById(R.id.game_box_5)
        gb6 = findViewById(R.id.game_box_6)
        gb7 = findViewById(R.id.game_box_7)
        gb8 = findViewById(R.id.game_box_8)
        gb9 = findViewById(R.id.game_box_9)

        btn1 = BtnInfo (gb1, 1)
        btn2 = BtnInfo (gb2, 2)
        btn3 = BtnInfo (gb3, 3)
        btn4 = BtnInfo (gb4, 4)
        btn5 = BtnInfo (gb5, 5)
        btn6 = BtnInfo (gb6, 6)
        btn7 = BtnInfo (gb7, 7)
        btn8 = BtnInfo (gb8, 8)
        btn9 = BtnInfo (gb9, 9)

        btn1.Btn.setOnClickListener {
            btn1.isTight = 1
            thePlay(btn1, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn2.Btn.setOnClickListener {
            btn2.isTight = 1
            thePlay(btn2, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn3.Btn.setOnClickListener {
            btn3.isTight = 1
            thePlay(btn3, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn4.Btn.setOnClickListener {
            btn4.isTight = 1
            thePlay(btn4, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn5.Btn.setOnClickListener {
            btn5.isTight = 1
            thePlay(btn5, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn6.Btn.setOnClickListener {
            btn6.isTight = 1
            thePlay(btn6, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn7.Btn.setOnClickListener {
            btn7.isTight = 1
            thePlay(btn7, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn8.Btn.setOnClickListener {
            btn8.isTight = 1
            thePlay(btn8, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }
        btn9.Btn.setOnClickListener {
            btn9.isTight = 1
            thePlay(btn9, playerOne.nome, playerTwo.nome)
            it.isEnabled = false
        }

        BtnplayAgain.setOnClickListener {
            playAgain()
        }

    }

    private fun setInfoPlayers() {

        playerOneName = findViewById(R.id.player_name_1)
        playerOneName.text = playerOne.nome
        winsCountPlayerOne = findViewById(R.id.number_wins_1)
        winsCountPlayerOne.text = playerOne.wins.toString()

        playerTwoName = findViewById(R.id.player_name_2)
        playerTwoName.text = playerTwo.nome
        winsCountPlayerTwo = findViewById(R.id.number_wins_2)
        winsCountPlayerTwo.text = playerTwo.wins.toString()

    }

    private fun thePlay(gameBox: BtnInfo, player1: String, player2: String) {

        val listButtons = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        val whichPlayer = playersTurn(playerOne.nome, playerTwo.nome)

        if (whichPlayer == player1) {
            gameBox.Btn.setBackgroundResource(R.drawable.player1_play)
            playerPlay1.add(gameBox.number)

            winCheck()

        } else {
            gameBox.Btn.setBackgroundResource(R.drawable.player2_play)
            playerPlay2.add(gameBox.number)

            winCheck()
        }

        tieCheck(listButtons)

    }

    private fun playersTurn(player1: String, player2: String): String? {
        if (lastReturn == firstReturn) {
            lastReturn = player1
        } else {
            lastReturn = player2
            firstReturn = lastReturn
        }
        return lastReturn
    }

    private fun winCheck() {

        val listButtons = listOf(gb1, gb2, gb3, gb4, gb5, gb6, gb7, gb8, gb9)

        val win1 = listOf(1, 2, 3)
        val win2 = listOf(4, 5, 6)
        val win3 = listOf(7, 8, 9)
        val win4 = listOf(1, 5, 9)
        val win5 = listOf(3, 5, 7)
        val win6 = listOf(1, 4, 7)
        val win7 = listOf(2, 5, 8)
        val win8 = listOf(3, 6, 9)


        if (playerPlay1.containsAll(win1) or
            playerPlay1.containsAll(win2) or
            playerPlay1.containsAll(win3) or
            playerPlay1.containsAll(win4) or
            playerPlay1.containsAll(win5) or
            playerPlay1.containsAll(win6) or
            playerPlay1.containsAll(win7) or
            playerPlay1.containsAll(win8)
        ) {

            playerOne.wins += 1

            disableButtons(listButtons)

            BtnplayAgain.isEnabled = true
            BtnplayAgain.visibility = VISIBLE

            winMessage.text = getString(R.string.Winner, playerOne.nome)
            winMessage.visibility = VISIBLE

            setInfoPlayers()

        } else if (playerPlay2.containsAll(win1) or
            playerPlay2.containsAll(win2) or
            playerPlay2.containsAll(win3) or
            playerPlay2.containsAll(win4) or
            playerPlay2.containsAll(win5) or
            playerPlay2.containsAll(win6) or
            playerPlay2.containsAll(win7) or
            playerPlay2.containsAll(win8)
        ) {

            playerTwo.wins += 1

            disableButtons(listButtons)

            BtnplayAgain.isEnabled = true
            BtnplayAgain.visibility = VISIBLE

            winMessage.text = getString(R.string.Winner, playerTwo.nome)
            winMessage.visibility = VISIBLE
            setInfoPlayers()

        }
    }

    private fun disableButtons(list: List<Button>) {
        list[0].isEnabled = false
        list[1].isEnabled = false
        list[2].isEnabled = false
        list[3].isEnabled = false
        list[4].isEnabled = false
        list[5].isEnabled = false
        list[6].isEnabled = false
        list[7].isEnabled = false
        list[8].isEnabled = false
    }

    private fun enableButtons(list: List<Button>) {
        list[0].isEnabled = true
        list[1].isEnabled = true
        list[2].isEnabled = true
        list[3].isEnabled = true
        list[4].isEnabled = true
        list[5].isEnabled = true
        list[6].isEnabled = true
        list[7].isEnabled = true
        list[8].isEnabled = true
    }

    private fun cleanButtons(list: List<Button>) {
        list[0].setBackgroundResource(android.R.drawable.btn_default)
        list[1].setBackgroundResource(android.R.drawable.btn_default)
        list[2].setBackgroundResource(android.R.drawable.btn_default)
        list[3].setBackgroundResource(android.R.drawable.btn_default)
        list[4].setBackgroundResource(android.R.drawable.btn_default)
        list[5].setBackgroundResource(android.R.drawable.btn_default)
        list[6].setBackgroundResource(android.R.drawable.btn_default)
        list[7].setBackgroundResource(android.R.drawable.btn_default)
        list[8].setBackgroundResource(android.R.drawable.btn_default)

    }

    private fun playAgain() {
        val listButtons = listOf(gb1, gb2, gb3, gb4, gb5, gb6, gb7, gb8, gb9)

        lastReturn = firstReturn
        playerPlay1.clear()
        playerPlay2.clear()
        cleanButtons(listButtons)
        enableButtons(listButtons)
        winMessage.visibility = INVISIBLE
        BtnplayAgain.visibility = INVISIBLE

        btn1.isTight = 0
        btn2.isTight = 0
        btn3.isTight = 0
        btn4.isTight = 0
        btn5.isTight = 0
        btn6.isTight = 0
        btn7.isTight = 0
        btn8.isTight = 0
        btn9.isTight = 0
    }

    private fun tieCheck(list : List<BtnInfo>) {

        if ((list[0].isTight == 1 &&
                list[1].isTight == 1 &&
                list[2].isTight == 1 &&
                list[3].isTight == 1 &&
                list[4].isTight == 1 &&
                list[5].isTight == 1 &&
                list[6].isTight == 1 &&
                list[7].isTight == 1 &&
                list[8].isTight == 1 )
                && !(winMessage.visibility == VISIBLE)) {

            BtnplayAgain.isEnabled = true
            BtnplayAgain.visibility = VISIBLE

            winMessage.text = getString(R.string.deu_velha)
            winMessage.visibility = VISIBLE

            setInfoPlayers()

        }
    }
}

