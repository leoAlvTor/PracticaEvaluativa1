package ec.edu.ups.practicaevaluativa1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ec.edu.ups.practicaevaluativa1.databinding.FragmentAboutBinding
import ec.edu.ups.practicaevaluativa1.databinding.FragmentLoginBinding


class fragment_about : Fragment() {

    private lateinit var binding : FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        var text : String? = ""
        context?.openFileInput("usuarios_test").use { fileInputStream ->
            text = fileInputStream?.bufferedReader().use {
                it?.readText()
            }
        }
        val usuario = text?.split(";");

        binding.nombre = usuario?.get(0)
        binding.direccion = usuario?.get(1)

        return binding.root
    }


}