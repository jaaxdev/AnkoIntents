package com.jaax.ankointents

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnAccion1: Button
    private lateinit var btnAccion2: Button
    private lateinit var btnAccion3: Button
    private lateinit var btnAccion4: Button
    private lateinit var btnAccion5: Button
    private lateinit var btnAccion6: Button
    private lateinit var btnAccion7: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAccion1 = findViewById(R.id.btnAccion1)
        btnAccion2 = findViewById(R.id.btnAccion2)
        btnAccion3 = findViewById(R.id.btnAccion3)
        btnAccion4 = findViewById(R.id.btnAccion4)
        btnAccion5 = findViewById(R.id.btnAccion5)
        btnAccion6 = findViewById(R.id.btnAccion6)
        btnAccion7 = findViewById(R.id.btnAccion7)
    }

    override fun onResume() {
        super.onResume()
        btnAccion1.setOnClickListener {
            intentExplicito()
        }
        btnAccion2.setOnClickListener {
            intentImplicito()
        }
        btnAccion3.setOnClickListener {
            share( "Comparte comparte Anko", "Anko for Android" )
        }
        btnAccion4.setOnClickListener {
            sendSMS( "55331891505", "Anko SMS" )
        }
        //alerts
        btnAccion5.setOnClickListener {
            alert( "No pasa nada :v", "ALERTA!" ) {
                yesButton { toast("Oc") }
                noButton { toast("Te pasas!") }
            }.show()
        }
        btnAccion6.setOnClickListener {
            val langs = listOf( "Es", "En", "Fr", "Ru", "Po", "Mg" )
            selector( "Which lang u speak?", langs ) { _, i ->
                toast("U speak $i")
            }
        }
        btnAccion7.setOnClickListener {
            progressDialog( "Msj, espera...", "Ya casi está..." )
        }

        comprobarVersiones()
    }

    private fun intentExplicito() {
        // anko toast
        toast( "Anko toast" )
        val msj = "Salut mes amis !"
        startActivity<Activity2>( "message" to msj )
    }

    private fun intentImplicito() {

        val telefono = "5533891505"
        //val intent = Intent( Intent.ACTION_CALL, Uri.parse( "tel: $telefono" ) ) //antes intent implicito

        makeCall( telefono ) //con anko intent

        //val intent = Intent( Intent.ACTION_VIEW, Uri.parse("github.com/jaazielirc") ) //antes intent
        browse( "github.com/jaazielirc" ) // intent para URL
        email( "email destinatario", "titulo email", "mensaje" ) //intent para email
    }

    private fun comprobarVersiones() {
        doFromSdk( Build.VERSION_CODES.LOLLIPOP ) {
            toast(  "VERSION MAYOR A LOLLIPOP")
        }
        doIfSdk( Build.VERSION_CODES.LOLLIPOP ){
            toast( "VERSION MENOR O IGUAL A LOLLIPOP" )
        }
    }
}