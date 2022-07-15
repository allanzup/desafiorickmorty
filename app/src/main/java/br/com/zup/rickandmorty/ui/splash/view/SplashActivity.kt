package br.com.zup.rickandmorty.ui.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.ui.home.view.HomeActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        timer.schedule(object : TimerTask() {
            override fun run() {
                irhome()
            }
        }, 3000)
    }

    private fun irhome() {
        timer.cancel()
        startActivity(Intent(this, HomeActivity::class.java))
        this.finish()
    }
}