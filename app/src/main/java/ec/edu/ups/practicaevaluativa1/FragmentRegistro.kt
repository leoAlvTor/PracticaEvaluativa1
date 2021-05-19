package ec.edu.ups.practicaevaluativa1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ec.edu.ups.practicaevaluativa1.databinding.FragmentRegistroBinding

class FragmentRegistro : Fragment() {

    private lateinit var binding : FragmentRegistroBinding
    private var textAnterior : String = "";
    private var operacion : String = "";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registro, container, false)
        binding.btnRegistrar.setOnClickListener {
            guardarUsuario()
            view?.findNavController()?.navigate(R.id.action_fragment_registro_to_fragment_login)
        }

        return binding.root
    }

    fun guardarUsuario(){
        val filename = "usuarios_test"
        val fileContent = binding.nombre+";"+binding.direccion+";"+binding.password
        context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it?.write(fileContent.toByteArray())
        }

    }



}