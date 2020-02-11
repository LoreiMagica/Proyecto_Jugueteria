package com.iesvirgendelcarmen.proyecto_jugueteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private val fragmentListaCategoria = FragmentListaCategoria()
    private val fragmentNuevoJuguete = FragmentNuevoJuguete()


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.contenedor, fragmentListaCategoria)
        transaction.commit()


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menuOpcion1 -> {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedor, fragmentListaCategoria)
            transaction.commit()
            true
        }
        R.id.menuOpcion2 -> {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.contenedor, fragmentNuevoJuguete)
            transaction.commit()
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
