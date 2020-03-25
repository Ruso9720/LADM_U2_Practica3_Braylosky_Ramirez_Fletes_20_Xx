package mx.edu.ittepic.ladm_u2_practica3_braylosky_ramirez_fletes_20_xx

import android.graphics.Color.*
import kotlinx.android.synthetic.main.activity_main.*

class Juego (p: MainActivity): Thread(){

    var puntero = p
    var start = false
    var arreglo = ArrayList<Int>()
    var p1c = 0
    var p3c = 0
    var p4c = 0
    var p2c = 0



    override fun run() {
        super.run()
        while (!start ) {
            var dado_1= (1..6).random().toInt()
            var dado_2 = (1..6).random().toInt()
            sleep(1500)
            puntero.runOnUiThread {
                if(puntero.player == 4 ) {
                    puntero.juego++
                    puntero.Game.setText("ROUND "+puntero.juego)
                    puntero.player = 0
                    puntero.P4.setTextColor(RED)

                    if(puntero.juego > 4 ){
                        start = true
                        puntero.Game.setText("ROUND 4")
                    }
                }
                if(puntero.juego <= 4) {
                semaforo()

                    when(dado_1){
                        1->{
                            puntero.dado_1.setText("1")

                        }
                        2->{
                            puntero.dado_1.setText("2")
                        }
                        3->{
                            puntero.dado_1.setText("3")
                        }
                        4->{
                            puntero.dado_1.setText("4")
                        }
                        5->{
                            puntero.dado_1.setText("5")
                        }
                        6->{
                            puntero.dado_1.setText("6")
                        }
                    }
                    when(dado_2){
                        1->{
                            puntero.dado_2.setText("1")
                        }
                        2->{
                            puntero.dado_2.setText("2")
                        }
                        3->{
                            puntero.dado_2.setText("3")
                        }
                        4->{
                            puntero.dado_2.setText("4")
                        }
                        5->{
                            puntero.dado_2.setText("5")
                        }
                        6->{
                            puntero.dado_2.setText("6")
                        }
                    }

                    if(puntero.player == 1) {
                        p2c += suma(dado_1,dado_2)
                        puntero.points2.setText(""+p2c)
                    }
                    if(puntero.player == 2){
                        p3c += suma(dado_1,dado_2)
                        puntero.points3.setText(""+p3c)
                    }
                    if(puntero.player == 3){
                        p4c += suma(dado_1,dado_2)
                        puntero.points4.setText(""+p4c)
                    }
                    if(puntero.player == 0){
                        p1c += suma(dado_1,dado_2)
                        puntero.points1.setText(""+p1c)
                    }
                    sleep(200)
                    puntero.player++
                }
            }
        }

        puntero.runOnUiThread {
           winner()
        }
    }
fun suma(a:Int,b:Int): Int {
       var r = a+b
    return r

    }

fun winner(){
    arreglo.add(p1c)
    arreglo.add(p2c)
    arreglo.add(p3c)
    arreglo.add(p4c)

    if (arreglo[1] == arreglo.max()) {
        puntero.P2.setTextColor(WHITE)
        puntero.P_2.setTextColor(WHITE)
        puntero.points2.setTextColor(WHITE)
        puntero.mensaje("PLAYER #2")
    }
    if (arreglo[2] == arreglo.max()) {
        puntero.P3.setTextColor(WHITE)
        puntero.P_3.setTextColor(WHITE)
        puntero.points3.setTextColor(WHITE)
        puntero.mensaje("PLAYER #3")
    }
    if (arreglo[3] == arreglo.max()) {
        puntero.P4.setTextColor(WHITE)
        puntero.P_4.setTextColor(WHITE)
        puntero.points4.setTextColor(WHITE)
        puntero.mensaje(" PLAYER #4")
    }
    if (arreglo[0] == arreglo.max()) {
        puntero.P1.setTextColor(WHITE)
        puntero.P_1.setTextColor(WHITE)
        puntero.points1.setTextColor(WHITE)
        puntero.mensaje("PLAYER #1")
    }
}
    fun semaforo (){
        if (puntero.player == 1) {
            puntero.P1.setTextColor(RED)
            puntero.P2.setTextColor(GREEN)
            puntero.P3.setTextColor(RED)
            puntero.P4.setTextColor(RED)
        }
        if (puntero.player == 2) {
            puntero.P1.setTextColor(RED)
            puntero.P2.setTextColor(RED)
            puntero.P3.setTextColor(GREEN)
            puntero.P4.setTextColor(RED)
        }
        if (puntero.player == 3) {
            puntero.P1.setTextColor(RED)
            puntero.P2.setTextColor(RED)
            puntero.P3.setTextColor(RED)
            puntero.P4.setTextColor(GREEN)
        }
        if (puntero.player == 0) {
            puntero.P1.setTextColor(GREEN)
            puntero.P2.setTextColor(RED)
            puntero.P3.setTextColor(RED)
            puntero.P4.setTextColor(RED)
        }
    }
    fun pause(){
        start = false
    }
    fun stopJ(){
        start = false
    }
}