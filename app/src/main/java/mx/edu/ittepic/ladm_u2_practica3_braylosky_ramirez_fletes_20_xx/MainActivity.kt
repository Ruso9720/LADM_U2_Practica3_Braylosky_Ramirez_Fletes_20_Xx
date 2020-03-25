package mx.edu.ittepic.ladm_u2_practica3_braylosky_ramirez_fletes_20_xx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var player = 0
    var juego = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            var p = Juego(this)
            p.start()
            button.setEnabled(false)
            Game.setText("ROUND 1")

        }

    }

    fun mensaje(s: String){
        AlertDialog.Builder(this).setTitle("CONGRATULATIONS").setMessage("WINNER IS: " + s).setPositiveButton("OK"){d, i ->}.show()
    }
}
