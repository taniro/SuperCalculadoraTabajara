package ufrn.br.supercalculadoratabajara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import ufrn.br.supercalculadoratabajara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    var x = 0
    var y = 0
    var resultado = 0

    val setxActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            x = it.data!!.getIntExtra("atual",0)
            binding.textViewX.text = x.toString()
        }
    }

    val setyActicityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            y = it.data!!.getIntExtra("atual",0)
            binding.textViewY.text = y.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.textViewX.text = x.toString()
        binding.textViewY.text = y.toString()

        binding.textViewResultado.text = resultado.toString()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null){
            Log.i("Aula", "Activity foi aberta pela primeira vez e não há estado")
        }else{
            Log.i("Aula", "Activity tem estado")
            Log.i("Aula", "Resultado = $resultado")
        }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonSetX.setOnClickListener {
            val intent = Intent(this, ActivitySetter::class.java)
            intent.putExtra("label", "X")
            intent.putExtra("atual", x)

            setxActivityLauncher.launch(intent)
        }

        binding.buttonSetY.setOnClickListener {
            val intent = Intent(this, ActivitySetter::class.java)
            intent.putExtra("label", "Y")
            intent.putExtra("atual", y)

            setyActicityLauncher.launch(intent)
        }

        binding.buttonCalcular.setOnClickListener {
            binding.textViewResultado.text = (x + y).toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("x", x)
        outState.putInt("y", y)
        resultado = x + y
        outState.putInt("resultado", resultado)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        x = savedInstanceState.getInt("x")
        y = savedInstanceState.getInt("y")
        resultado = savedInstanceState.getInt("resultado")

        binding.textViewResultado.text = resultado.toString()

    }
}