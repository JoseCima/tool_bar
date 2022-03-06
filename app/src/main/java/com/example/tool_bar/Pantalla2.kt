package com.example.tool_bar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class Pantalla2 : AppCompatActivity() {

    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        //Definiendo la como oficial
        setSupportActionBar(toolbar)

        //Creando Boton hacia atras (sin confirgurar)
        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Creando las acciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menupantalla2, menu)

        return super.onCreateOptionsMenu(menu)
    }

}