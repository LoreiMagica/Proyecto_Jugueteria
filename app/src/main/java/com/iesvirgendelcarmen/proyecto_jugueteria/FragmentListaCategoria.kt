package com.iesvirgendelcarmen.proyecto_jugueteria

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager

class FragmentListaCategoria : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.activity_categoria, container, false)
    }
    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var arrayJuguetes = mutableListOf<Juguete>()
        var arrayCategoria = mutableListOf<Categoria>()
        val listViewJuguetes = getView()!!.findViewById<RecyclerView>(R.id.listaJuguetes)
        val llm = GridLayoutManager(context, 2, GridLayout.VERTICAL, false)

        listViewJuguetes.layoutManager = llm


        val listener = object : AdapterCategoria.OnClickListener {
            override fun onClick(categoria: Categoria) {
                val fragmentFicha = FragmentListaJuguetes()
                val bundle: Bundle = Bundle()
                bundle.putSerializable("categoriaTocada", categoria.nombre)
                fragmentFicha.arguments = bundle
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.contenedor, fragmentFicha, "ficha")
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }




        val adapter = AdapterCategoria(arrayCategoria, listener)
        listViewJuguetes.adapter = adapter

//        CategoriaRepository.getCategorias(
//            object : CategoriaRepository.CategoriaListCallback{
//                override fun onCategoriaResponse(listaCategorias: List<Categoria>) {
//                    arrayCategoria = listaCategorias
//                }
//            }
//        )

        arrayCategoria.add(Categoria("Juguetes de construcción", "https://plazatoy.com/184-large_default/bloques-de-construccion-hape.jpg"))
        arrayCategoria.add(Categoria("Figuras de acción", "https://media.kapowtoys.co.uk/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/u/super-7-voltron-1.jpg"))


        arrayJuguetes.add(Juguete ("Lego Casa del árbol", "https://sh-s7-live-s.legocdn.com/is/image/LEGO/21318_alt1?wid=320&hei=320", 1,
            "Juguetes de construcción", "Un set de piezas de construcción para hacer una casa del árbol", 29.99))
        arrayJuguetes.add(Juguete ("Geomag Panels", "https://images-na.ssl-images-amazon.com/images/I/81+XAEHpqTL._SX425_.jpg", 2,
            "Juguetes de construcción", "Un set de piezas de geomag con panelesl", 24.50))
        arrayJuguetes.add(Juguete ("Figura de acción de Spiderman", "https://ae01.alicdn.com/kf/HTB1x2Juef5G3KVjSZPxq6zI3XXam/Spider-Man-Homecoming" +
                "-The-Spiderman-estilo-Simple-Herioc-acci-n-PVC-figura-de-acci-n-coleccionable.jpg", 3,
            "Figuras de acción", "Una figura de spiderman articulable y con accesorios", 18.90))
        arrayJuguetes.add(Juguete ("Barbie con armario", "https://i.ytimg.com/vi/9mOFyvkvEv8/maxresdefault.jpg", 4,
            "Figuras de acción", "Una muñeca Barbie con armario para guardar accesorios", 23.49))
    }


}