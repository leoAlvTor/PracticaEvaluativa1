package ec.edu.ups.practicaevaluativa1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import ec.edu.ups.practicaevaluativa1.databinding.FragmentLoginBinding
import java.util.ArrayList

class FragmentLogin : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnEnviar.setOnClickListener {
            chequearDatos(it)
        }


        return binding.root
    }

    fun chequearDatos(view: View){
        var text : String? = ""
        context?.openFileInput("usuarios_test").use { fileInputStream ->
            text = fileInputStream?.bufferedReader().use {
                it?.readText()
            }
        }
        val usuario = text?.split(";");
        if((binding.nombre == usuario?.get(0) && binding.password == usuario?.get(2))
            || (binding.nombre == "admin" && binding.password == "admin")){
            view.findNavController().navigate(R.id.action_fragment_login_to_fragmentInicio)
        }else
            Toast.makeText(context, "Los datos que ingreso son incorrectos!", Toast.LENGTH_SHORT).show()

    }

}