package com.example.soham.sudoku

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    var solutionfound :Boolean = false
    var mat  = Array(9, {IntArray(9)})
    var solved  = Array(9, {IntArray(9)})
    var buttonIds = Array(9, {IntArray(9)})
    var fix = Array(9,{IntArray(9)})
    val n1:MutableList<Int> = mutableListOf(0,1,2,3,4,5,6,7,8)
    var b:Boolean = false
    var numbers:MutableList<Int> = mutableListOf(1,2,3,4,5,6,7,8,9)
    val k : Int = 47
    val n : Int = 9
    var x = 0
    var y = 0
    var buttonId:Int= 0
    var rand:Random = Random()
    var available = ArrayList<ArrayList<Int>>()
    private var buttons = ArrayList<Button>()
    private var buttonFlag : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mappingButtons()
        fillValues()
        buttons.add(findViewById(R.id.button95))
        buttons.add(findViewById(R.id.button94))
        buttons.add(findViewById(R.id.button93))
        buttons.add(findViewById(R.id.button92))
        buttons.add(findViewById(R.id.button91))
        buttons.add(findViewById(R.id.button90))
        buttons.add(findViewById(R.id.button89))
        buttons.add(findViewById(R.id.button88))
        buttons.add(findViewById(R.id.button87))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId==R.id.Solution){
            var intent:Intent = Intent(this,HintActivity::class.java)
            var x:String = ""
            for (i in 0..8){
                for (j in 0..8){
                    x+=solved[i][j].toString()
                }
            }
            intent.putExtra("Solution",x)
            this.startActivity(intent)
        }
        return true
    }
    fun clearCell(view: View){
        if (mat[x][y] != 0) {
        if(fix[x][y]==0) {
                mat[x][y] = 0
                var b: Button = findViewById(buttonId)
                b.text = ""
            }
        var i:Int = 0
        for(i in 0..8){
            //buttons[i].setBackgroundColor(Color.parseColor("#B8F889"))
            buttons[i].backgroundTintList = resources.getColorStateList(R.color.tint2)
        }
        buttonFlag=0
    }
    }
    fun mappingButtons(){
        buttonIds[0][0]=R.id.button13
        buttonIds[0][1]=R.id.button12
        buttonIds[0][2]=R.id.button11
        buttonIds[0][3]=R.id.button10
        buttonIds[0][4]=R.id.button9
        buttonIds[0][5]=R.id.button8
        buttonIds[0][6]=R.id.button7
        buttonIds[0][7]=R.id.button6
        buttonIds[0][8]=R.id.button
        buttonIds[1][0]=R.id.button22
        buttonIds[1][1]=R.id.button21
        buttonIds[1][2]=R.id.button20
        buttonIds[1][3]=R.id.button19
        buttonIds[1][4]=R.id.button18
        buttonIds[1][5]=R.id.button17
        buttonIds[1][6]=R.id.button16
        buttonIds[1][7]=R.id.button15
        buttonIds[1][8]=R.id.button14
        buttonIds[2][0]=R.id.button31
        buttonIds[2][1]=R.id.button30
        buttonIds[2][2]=R.id.button29
        buttonIds[2][3]=R.id.button28
        buttonIds[2][4]=R.id.button27
        buttonIds[2][5]=R.id.button26
        buttonIds[2][6]=R.id.button25
        buttonIds[2][7]=R.id.button24
        buttonIds[2][8]=R.id.button23
        buttonIds[3][0]=R.id.button40
        buttonIds[3][1]=R.id.button39
        buttonIds[3][2]=R.id.button38
        buttonIds[3][3]=R.id.button37
        buttonIds[3][4]=R.id.button36
        buttonIds[3][5]=R.id.button35
        buttonIds[3][6]=R.id.button34
        buttonIds[3][7]=R.id.button33
        buttonIds[3][8]=R.id.button32
        buttonIds[4][0]=R.id.button49
        buttonIds[4][1]=R.id.button48
        buttonIds[4][2]=R.id.button47
        buttonIds[4][3]=R.id.button46
        buttonIds[4][4]=R.id.button45
        buttonIds[4][5]=R.id.button44
        buttonIds[4][6]=R.id.button43
        buttonIds[4][7]=R.id.button42
        buttonIds[4][8]=R.id.button41
        buttonIds[5][0]=R.id.button58
        buttonIds[5][1]=R.id.button57
        buttonIds[5][2]=R.id.button56
        buttonIds[5][3]=R.id.button55
        buttonIds[5][4]=R.id.button54
        buttonIds[5][5]=R.id.button53
        buttonIds[5][6]=R.id.button52
        buttonIds[5][7]=R.id.button51
        buttonIds[5][8]=R.id.button50
        buttonIds[6][0]=R.id.button67
        buttonIds[6][1]=R.id.button66
        buttonIds[6][2]=R.id.button65
        buttonIds[6][3]=R.id.button64
        buttonIds[6][4]=R.id.button63
        buttonIds[6][5]=R.id.button62
        buttonIds[6][6]=R.id.button61
        buttonIds[6][7]=R.id.button60
        buttonIds[6][8]=R.id.button59
        buttonIds[7][0]=R.id.button76
        buttonIds[7][1]=R.id.button75
        buttonIds[7][2]=R.id.button74
        buttonIds[7][3]=R.id.button73
        buttonIds[7][4]=R.id.button72
        buttonIds[7][5]=R.id.button71
        buttonIds[7][6]=R.id.button70
        buttonIds[7][7]=R.id.button69
        buttonIds[7][8]=R.id.button68
        buttonIds[8][0]=R.id.button85
        buttonIds[8][1]=R.id.button84
        buttonIds[8][2]=R.id.button83
        buttonIds[8][3]=R.id.button82
        buttonIds[8][4]=R.id.button81
        buttonIds[8][5]=R.id.button80
        buttonIds[8][6]=R.id.button79
        buttonIds[8][7]=R.id.button78
        buttonIds[8][8]=R.id.button77
    }
    fun buClick(view:View){
        var buSelected:Button = view as Button
        buttonId = buSelected.id
        when(buSelected.id){
            R.id.button13 -> {x=0
                y=0}
            R.id.button12 -> {x=0
                y=1}
            R.id.button11 -> {x=0
                y=2}
            R.id.button10 -> {x=0
                y=3}
            R.id.button9 -> {x=0
                y=4}
            R.id.button8 -> {x=0
                y=5}
            R.id.button7 -> {x=0
                y=6}
            R.id.button6 -> {x=0
                y=7}
            R.id.button -> {x=0
                y=8}
            R.id.button22 -> {x=1
                y=0}
            R.id.button21 -> {x=1
                y=1}
            R.id.button20 -> {x=1
                y=2}
            R.id.button19 -> {x=1
                y=3}
            R.id.button18 -> {x=1
                y=4}
            R.id.button17 -> {x=1
                y=5}
            R.id.button16 -> {x=1
                y=6}
            R.id.button15 -> {x=1
                y=7}
            R.id.button14 -> {x=1
                y=8}
            R.id.button31 -> {x=2
                y=0}
            R.id.button30 -> {x=2
                y=1}
            R.id.button29 -> {x=2
                y=2}
            R.id.button28 -> {x=2
                y=3}
            R.id.button27 -> {x=2
                y=4}
            R.id.button26 -> {x=2
                y=5}
            R.id.button25 -> {x=2
                y=6}
            R.id.button24 -> {x=2
                y=7}
            R.id.button23 -> {x=2
                y=8}
            R.id.button40 -> {x=3
                y=0}
            R.id.button39 -> {x=3
                y=1}
            R.id.button38 -> {x=3
                y=2}
            R.id.button37 -> {x=3
                y=3}
            R.id.button36 -> {x=3
                y=4}
            R.id.button35 -> {x=3
                y=5}
            R.id.button34 -> {x=3
                y=6}
            R.id.button33 -> {x=3
                y=7}
            R.id.button32 -> {x=3
                y=8}
            R.id.button49 -> {x=4
                y=0}
            R.id.button48 -> {x=4
                y=1}
            R.id.button47 -> {x=4
                y=2}
            R.id.button46 -> {x=4
                y=3}
            R.id.button45 -> {x=4
                y=4}
            R.id.button44 -> {x=4
                y=5}
            R.id.button43 -> {x=4
                y=6}
            R.id.button42 -> {x=4
                y=7}
            R.id.button41 -> {x=4
                y=8}
            R.id.button58 -> {x=5
                y=0}
            R.id.button57 -> {x=5
                y=1}
            R.id.button56 -> {x=5
                y=2}
            R.id.button55 -> {x=5
                y=3}
            R.id.button54 -> {x=5
                y=4}
            R.id.button53 -> {x=5
                y=5}
            R.id.button52 -> {x=5
                y=6}
            R.id.button51 -> {x=5
                y=7}
            R.id.button50 -> {x=5
                y=8}
            R.id.button67 -> {x=6
                y=0}
            R.id.button66 -> {x=6
                y=1}
            R.id.button65 -> {x=6
                y=2}
            R.id.button64 -> {x=6
                y=3}
            R.id.button63 -> {x=6
                y=4}
            R.id.button62 -> {x=6
                y=5}
            R.id.button61 -> {x=6
                y=6}
            R.id.button60 -> {x=6
                y=7}
            R.id.button59 -> {x=6
                y=8}
            R.id.button76 -> {x=7
                y=0}
            R.id.button75 -> {x=7
                y=1}
            R.id.button74 -> {x=7
                y=2}
            R.id.button73 -> {x=7
                y=3}
            R.id.button72 -> {x=7
                y=4}
            R.id.button71 -> {x=7
                y=5}
            R.id.button70 -> {x=7
                y=6}
            R.id.button69 -> {x=7
                y=7}
            R.id.button68 -> {x=7
                y=8}
            R.id.button85 -> {x=8
                y=0}
            R.id.button84 -> {x=8
                y=1}
            R.id.button83 -> {x=8
                y=2}
            R.id.button82 -> {x=8
                y=3}
            R.id.button81 -> {x=8
                y=4}
            R.id.button80 -> {x=8
                y=5}
            R.id.button79 -> {x=8
                y=6}
            R.id.button78 -> {x=8
                y=7}
            R.id.button77 -> {x=8
                y=8}
        }
        var i:Int = 0
        for(i in 0..8){
            //buttons[i].setBackgroundColor(Color.parseColor("#F8A25A"))
            buttons[i].backgroundTintList = resources.getColorStateList(R.color.tint1)
        }
        buttonFlag = 1
        //inputNumber(x,y,buSelected);
    }
    fun buClick1(view: View){
        if(buttonFlag==1){
        var buSel : Button = view as Button
        var s : String = buSel.text.toString()
        var i:Int = 0
        for(i in 0..8){
            //buttons[i].setBackgroundColor(Color.parseColor("#B8F889"))
            buttons[i].backgroundTintList = resources.getColorStateList(R.color.tint2)
        }
            buttonFlag=0
        inputNumber(s)}
    }
    fun inputNumber(s:String){
        mat[x][y] = s.toInt()
        var buttonOut = findViewById<Button>(buttonId)
        buttonOut.text = s
        if(sudokuChecker()){
            val intent = Intent(this, WinnerActivity::class.java)
            startActivity(intent)
        }
    }
    fun makeBoard(){
        while(b==false){
            println("Restarted")
            b = attemptBoard()
        }
    }
    fun attemptBoard():Boolean{
        var checking:MutableList<Int>
        for (x in 0..8){
            for (y in 0..8){
                solved[x][y]=0
            }
        }
        for (i in 0..8){
            for (j in 0..8){
                //println("$i, $j")
                //printSudoku()
                checking = numbers
                checking.shuffle()
                var x = -1
                //var loopStart = 0
                while(solved[i][j]==0){
                    x+=1
                    if(x==9){
                        return false
                    }
                    var checkMe = checking[x]
                    var checkIs1 = false
                    for (j1 in 0..8){
                        if(checkMe == solved[i][j1]){
                            checkIs1=true
                        }
                    }
                    if(checkIs1){
                        continue
                    }
                    var checkIs = false
                    for(i1 in 0..8){
                        if(checkMe == solved[i1][j]){
                            checkIs = true
                        }
                    }
                    if(checkIs)
                        continue
                    if(i%3==1){
                        if((j%3==0)&&((checkMe==solved[i-1][j+1])||(checkMe==solved[i-1][j+2]))){
                            continue
                        }
                        else if((j%3==1)&&((checkMe==solved[i-1][j-1])||(checkMe==solved[i-1][j+1]))){
                            continue
                        }
                        else if((j%3==2)&&((checkMe==solved[i-1][j-1])||(checkMe==solved[i-1][j-2]))){
                            continue
                        }
                    }
                    else if(i%3==2){
                        if((j%3==0)&&((checkMe==solved[i-1][j+1])||(checkMe==solved[i-1][j+2])||(checkMe==solved[i-2][j+1])||(checkMe==solved[i-2][j+2]))){
                            continue
                        }
                        else if((j%3==1)&&((checkMe==solved[i-1][j-1])||(checkMe==solved[i-1][j+1])||(checkMe==solved[i-2][j-1])||(checkMe==solved[i-2][j+1]))){
                            continue
                        }
                        else if((j%3==2)&&((checkMe==solved[i-1][j-1])||(checkMe==solved[i-1][j-2])||(checkMe==solved[i-2][j-1])||(checkMe==solved[i-2][j-2]))){
                            continue
                        }
                    }
                    solved[i][j] = checkMe
                }
            }
        }
        return true
    }
    fun randomNumGenerator():Int{
        val randomInt = n1.shuffled().first()
        assert(randomInt>=0)
        assert(randomInt<=8)
        return randomInt
    }
    fun fillValues() {
        makeBoard()
        removeDigits()
        showInitValues()
    }
    fun removeDigits(){
        for(x in 0..8){
            for(y in 0..8){
                mat[x][y] = solved[x][y]
            }
        }
        var count = k
        while(count!=0){
            var i = randomNumGenerator()
            var j = randomNumGenerator()
            if(mat[i][j]!=0){
                count=count-1
                //n.remove(cell)
                mat[i][j]=0
            }
        }
    }
    fun showInitValues(){
        for(i in 0..8){
            for(j in 0..8){
                fix[i][j]=0
            }
        }
        for (i in 0..8){
            for(j in 0..8){
                if(mat[i][j]!=0){
                    var b:Button = findViewById(buttonIds[i][j])
                    fix[i][j]=1
                    b.setText(mat[i][j].toString())
                    b.backgroundTintList = resources.getColorStateList(R.color.tint3)
                }
            }
        }
    }
    fun sudokuChecker():Boolean{
        for(i in 0..8){
            var col:IntArray = mat[i].clone()
            var row:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0)
            var square:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0)
            for(j in 0..8){
                row[j] = mat[j][i]
                square[j] = mat[(i/3)*3+j/3][i*3%9+j%3]
            }
            if(!(validate(col)&&validate(row)&&validate(square)))
                return false
        }
        return true
    }
    fun validate(c:IntArray):Boolean{
        var i:Int = 0
        c.sort()
        for (number in c){
            if(number != ++i){
                return false
            }
        }
        return true
    }
}
