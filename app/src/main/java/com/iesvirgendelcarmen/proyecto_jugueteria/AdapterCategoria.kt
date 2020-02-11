package com.iesvirgendelcarmen.proyecto_jugueteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adaptador_juguetes.view.*
class AdapterCategoria(private val arrayCategoria: MutableList<Categoria>, private val listener: OnClickListener) :
    RecyclerView.Adapter<AdapterCategoria.MyViewHolder>() {
    class MyViewHolder(v: View, val listener: OnClickListener) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var categoria: Categoria? = null
        fun bindPhoto(categoria: Categoria) {
            this.categoria = categoria
            Glide.with(view.context).load(categoria.imagen).into(view.imagenJuguete)
            view.nombreJuguete.text = categoria.nombre
            view.setOnClickListener {
                listener.onClick(categoria)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCategoria.MyViewHolder {
        // create a new view
        val inflatedViewCategoria = parent.inflate(R.layout.mi_adaptador, false)
        return MyViewHolder(inflatedViewCategoria, listener)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemPhoto = arrayCategoria[position]
        holder.bindPhoto(itemPhoto)
    }
    override fun getItemCount() = arrayCategoria.size
    interface OnClickListener {
        fun onClick(categoria: Categoria)
    }
}
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
