package com.iesvirgendelcarmen.proyecto_jugueteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adaptador_juguetes.view.*
class AdapterJuguetes(private val arrayJuguetes: MutableList<Juguete>) :
    RecyclerView.Adapter<AdapterJuguetes.MyViewHolder>() {
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var juguete: Juguete? = null
        fun bindPhoto(juguete: Juguete) {
            this.juguete = juguete
            Glide.with(view.context).load(juguete.imagen).into(view.imagenJuguete)
            view.nombreJuguete.text = juguete.nombre
            view.precioJuguete.text = juguete.precio.toString()
            view.setOnClickListener {
                //listener.onClick(juguete)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterJuguetes.MyViewHolder {
        // create a new view
        val inflatedView = parent.inflate(R.layout.adaptador_juguetes, false)
        return MyViewHolder(inflatedView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemPhoto = arrayJuguetes[position]
        holder.bindPhoto(itemPhoto)
    }
    override fun getItemCount() = arrayJuguetes.size
    interface OnClickListener {
        fun onClick(categoria: Categoria)
    }
}
/*fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
} */

