package com.example.dmc

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.dmc.Persona.Persona
import kotlinx.android.synthetic.main.login_fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var fragmento: DetalleFragment;
    var personas: ArrayList<Persona> = ArrayList<Persona>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        inicializaPersonas();
        fragmento = DetalleFragment();

        next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = "Password demasiado corto.";
            } else {
                password_text_input.error = null;
            }

            if (login(username_edit_text.text.toString(), password_edit_text.text.toString())) {
                var bundle = Bundle();
                bundle.putString("nombre", username_edit_text.text.toString());
                val apodoPersona = apodo(username_edit_text.text.toString())
                bundle.putString("apodo", apodoPersona);
                fragmento.arguments = bundle;

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.contenedor, fragmento)
                    commit()
                }
            }
        }
        password_edit_text.addTextChangedListener {
            if (isPasswordValid(password_edit_text.text!!))
                password_text_input.error = null
        }
    }

    private fun isPasswordValid(text: Editable?): Boolean{
        return text != null && text.length >= 4;
    }

    private fun inicializaPersonas() {
        personas.add(Persona("Paco", "hola123,", "El patas"));
        personas.add(Persona("Fransisco", "hola123,", "El loco"));
        personas.add(Persona("Lucía", "hola123,", "La heavy"));
        personas.add(Persona("Mariana", "hola123,", "La tóxica"));
        personas.add(Persona("Adriana", "hola123,", "La chida"));
    }

    private fun login(nombre: String, Password: String): Boolean {
        return personas.first { it.getNombre() == nombre }.checaPassword(Password);
    }

    private fun apodo(Nombre: String): String {
        return personas.first { it.getNombre() == Nombre }.getApodo()
//        personas.map { persona ->
//            if (persona.getNombre() == Nombre) return persona.getApodo()
//        }
//        return ""
    }
}