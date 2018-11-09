package com.example.soham.sudoku

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class HintActivity:AppCompatActivity() {
    var s:String = ""
    var buttonIds = Array(9, {IntArray(9)})
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)
        var bundle:Bundle = intent.getExtras()
        s = bundle.getString("Solution")
        mappingButtons()
        showValues()
    }
    fun showValues(){
        var count:Int = 0
        for(i in 0..8){
            for(j in 0..8){
                var b: Button = findViewById<Button>(buttonIds[i][j])
                b.text = s.get(count).toString()
                count+=1
            }
        }
    }
    fun mappingButtons(){
        buttonIds[0][0]=R.id.b13
        buttonIds[0][1]=R.id.b12
        buttonIds[0][2]=R.id.b11
        buttonIds[0][3]=R.id.b10
        buttonIds[0][4]=R.id.b9
        buttonIds[0][5]=R.id.b8
        buttonIds[0][6]=R.id.b7
        buttonIds[0][7]=R.id.b6
        buttonIds[0][8]=R.id.b
        buttonIds[1][0]=R.id.b22
        buttonIds[1][1]=R.id.b21
        buttonIds[1][2]=R.id.b20
        buttonIds[1][3]=R.id.b19
        buttonIds[1][4]=R.id.b18
        buttonIds[1][5]=R.id.b17
        buttonIds[1][6]=R.id.b16
        buttonIds[1][7]=R.id.b15
        buttonIds[1][8]=R.id.b14
        buttonIds[2][0]=R.id.b31
        buttonIds[2][1]=R.id.b30
        buttonIds[2][2]=R.id.b29
        buttonIds[2][3]=R.id.b28
        buttonIds[2][4]=R.id.b27
        buttonIds[2][5]=R.id.b26
        buttonIds[2][6]=R.id.b25
        buttonIds[2][7]=R.id.b24
        buttonIds[2][8]=R.id.b23
        buttonIds[3][0]=R.id.b40
        buttonIds[3][1]=R.id.b39
        buttonIds[3][2]=R.id.b38
        buttonIds[3][3]=R.id.b37
        buttonIds[3][4]=R.id.b36
        buttonIds[3][5]=R.id.b35
        buttonIds[3][6]=R.id.b34
        buttonIds[3][7]=R.id.b33
        buttonIds[3][8]=R.id.b32
        buttonIds[4][0]=R.id.b49
        buttonIds[4][1]=R.id.b48
        buttonIds[4][2]=R.id.b47
        buttonIds[4][3]=R.id.b46
        buttonIds[4][4]=R.id.b45
        buttonIds[4][5]=R.id.b44
        buttonIds[4][6]=R.id.b43
        buttonIds[4][7]=R.id.b42
        buttonIds[4][8]=R.id.b41
        buttonIds[5][0]=R.id.b58
        buttonIds[5][1]=R.id.b57
        buttonIds[5][2]=R.id.b56
        buttonIds[5][3]=R.id.b55
        buttonIds[5][4]=R.id.b54
        buttonIds[5][5]=R.id.b53
        buttonIds[5][6]=R.id.b52
        buttonIds[5][7]=R.id.b51
        buttonIds[5][8]=R.id.b50
        buttonIds[6][0]=R.id.b67
        buttonIds[6][1]=R.id.b66
        buttonIds[6][2]=R.id.b65
        buttonIds[6][3]=R.id.b64
        buttonIds[6][4]=R.id.b63
        buttonIds[6][5]=R.id.b62
        buttonIds[6][6]=R.id.b61
        buttonIds[6][7]=R.id.b60
        buttonIds[6][8]=R.id.b59
        buttonIds[7][0]=R.id.b76
        buttonIds[7][1]=R.id.b75
        buttonIds[7][2]=R.id.b74
        buttonIds[7][3]=R.id.b73
        buttonIds[7][4]=R.id.b72
        buttonIds[7][5]=R.id.b71
        buttonIds[7][6]=R.id.b70
        buttonIds[7][7]=R.id.b69
        buttonIds[7][8]=R.id.b68
        buttonIds[8][0]=R.id.b85
        buttonIds[8][1]=R.id.b84
        buttonIds[8][2]=R.id.b83
        buttonIds[8][3]=R.id.b82
        buttonIds[8][4]=R.id.b81
        buttonIds[8][5]=R.id.b80
        buttonIds[8][6]=R.id.b79
        buttonIds[8][7]=R.id.b78
        buttonIds[8][8]=R.id.b77
    }
}