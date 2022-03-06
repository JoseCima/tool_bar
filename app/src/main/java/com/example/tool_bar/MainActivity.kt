package com.example.tool_bar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.SearchEvent
import android.widget.Button
//import androidx.appcompat.widget.ShareActionProvider
//import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat


class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        //Definiendo la como oficial
        setSupportActionBar(toolbar)

        val bIr  = findViewById<Button>(R.id.bIr)

        bIr.setOnClickListener {
            val intent = Intent(this, Pantalla2::class.java)
            startActivity(intent)
        }
    }

    //Creando las acciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        val itemBusqueda = menu?.findItem(R.id.search)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView
        val itemShare = menu?.findItem(R.id.share)

        val shareActionProvider = MenuItemCompat.getActionProvider(itemShare) as ShareActionProvider
        compartirIntent(shareActionProvider)

        //Placeholder

        vistaBusqueda.queryHint = "Escribe tu busqueda..."

        //Saber si esta activo la busqueda
        vistaBusqueda.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }

        //
        vistaBusqueda.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            //Cuando el usuario Escribe
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("OnQueryTextChange", newText.toString())
                return true
            }

            //Cuando el usuario de enter

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("OnQueryTextSubmit", query.toString())
                return true
            }

        })


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId){
            R.id.bFav ->{
                Toast.makeText(this, "Elemento añadido como Favorito", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }

    }


    private fun compartirIntent(shareActionProvider: ShareActionProvider){
        if(shareActionProvider != null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido - JoseCima")
            shareActionProvider.setShareIntent(intent)
        }
    }


}