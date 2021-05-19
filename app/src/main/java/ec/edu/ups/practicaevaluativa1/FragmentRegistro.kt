package ec.edu.ups.practicaevaluativa1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class fragment_registro : Fragment() {

    private lateinit var binding : fragment_registro
    private var textAnterior : String = "";
    private var operacion : String = "";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registro, container, false)
    }


}