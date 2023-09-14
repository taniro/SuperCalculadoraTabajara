package ufrn.br.supercalculadoratabajara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import ufrn.br.supercalculadoratabajara.databinding.ActivitySetterBinding

class ActivitySetter : AppCompatActivity() {

    lateinit var binding:ActivitySetterBinding

    var label : String? = ""
    var atual : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setter)

        label = intent.getStringExtra("label")
        atual = intent.getIntExtra("atual", 0)

        binding.textViewLabel.text = label
        binding.editTextNumber.setText(atual.toString())

        binding.buttonOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("atual", Integer.parseInt(binding.editTextNumber.text.toString()))
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}