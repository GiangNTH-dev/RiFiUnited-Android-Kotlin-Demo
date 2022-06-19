package com.giangnth.rifiunitedkotlin.ui.ranking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.giangnth.rifiunitedkotlin.R
import com.giangnth.rifiunitedkotlin.data.model.ListButtonModel

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        Log.e("RankingActivity", "value binhf thuong")
        Log.e("RankingActivity", "${intent.getStringExtra("name")}")
        Log.e("RankingActivity", "bundle")
        val bundle = intent.getBundleExtra("bundle")
        Log.e("RankingActivity", "bundle ${bundle?.getFloat("float")}")
        Log.e("RankingActivity", "bundle ${bundle?.getInt("int")}")
        Log.e("RankingActivity", "model")
        val model : ListButtonModel? = intent.getSerializableExtra("model") as ListButtonModel?
        Log.e("RankingActivity", "model ${model?.index}")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("result", "result tra ve")
        setResult(1, intent)
        super.onBackPressed()
    }
}
