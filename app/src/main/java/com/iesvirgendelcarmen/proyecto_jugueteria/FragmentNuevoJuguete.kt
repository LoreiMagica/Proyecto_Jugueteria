package com.iesvirgendelcarmen.proyecto_jugueteria

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class FragmentNuevoJuguete : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.activity_nuevo, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}