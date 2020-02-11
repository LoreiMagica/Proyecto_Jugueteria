package com.iesvirgendelcarmen.proyecto_jugueteria

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager

class FragmentListaJuguetes : Fragment(){
    private var arrayJuguetes = mutableListOf<Juguete>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.activity_categoria, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        val categoria = bundle?.get("categoriaTocada") as String

        arrayJuguetes.add(Juguete ("Lego Casa del árbol", "https://sh-s7-live-s.legocdn.com/is/image/LEGO/21318_alt1?wid=320&hei=320", 1,
            "Juguetes de construcción", "Un set de piezas de construcción para hacer una casa del árbol", 29.99))
        arrayJuguetes.add(Juguete ("Geomag Panels", "https://images-na.ssl-images-amazon.com/images/I/81+XAEHpqTL._SX425_.jpg", 2,
            "Juguetes de construcción", "Un set de piezas de geomag con panelesl", 24.50))
        arrayJuguetes.add(Juguete ("Figura de acción de Spiderman", "https://ae01.alicdn.com/kf/HTB1x2Juef5G3KVjSZPxq6zI3XXam/Spider-Man-Homecoming" +
                "-The-Spiderman-estilo-Simple-Herioc-acci-n-PVC-figura-de-acci-n-coleccionable.jpg", 3,
            "Figuras de acción", "Una figura de spiderman articulable y con accesorios", 18.90))
        arrayJuguetes.add(Juguete ("Barbie con armario", "https://i.ytimg.com/vi/9mOFyvkvEv8/maxresdefault.jpg", 4,
            "Figuras de acción", "Una muñeca Barbie con armario para guardar accesorios", 23.49))

        var arrayFiltrado = mutableListOf<Juguete>()
        for (i in 0 until arrayJuguetes.size) {
            if (arrayJuguetes.get(i).categoria.equals(categoria)){
                arrayFiltrado.add(arrayJuguetes.get(i))
            }

        }

        val listViewJuguetes = getView()!!.findViewById<RecyclerView>(R.id.listaJuguetes)
        val llm = LinearLayoutManager(context)
        listViewJuguetes.layoutManager = llm

        val adapter = AdapterJuguetes(arrayFiltrado)
        listViewJuguetes.adapter = adapter
    }
}