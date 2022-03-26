package com.voltaire.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PlayerNamesActivity : AppCompatActivity() {

    private lateinit var player_name_initial2: EditText
    private lateinit var player_name_initial1: EditText
    private lateinit var btnJogar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player_names_activity)

        player_name_initial1 = findViewById(R.id.pninitial_first)
        player_name_initial2 = findViewById(R.id.player_name_initial2)
        btnJogar = findViewById(R.id.btn_jogar)

        btnJogar.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("nome_first", player_name_initial1.text.toString())

            intent.putExtra("nome_second", player_name_initial2.text.toString())

            startActivity(intent)
            (finish())

        }
    }
}
