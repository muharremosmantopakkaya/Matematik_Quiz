package com.example.mathmagic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide() // Eğer action bar'ı gizlemek istiyorsanız

        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // İsteğe bağlı: Geri sayım süresi boyunca yapılacak işlemler
            }

            override fun onFinish() {
                // Geri sayım tamamlandığında MainActivity'ye geçiş yapılması
                val intent= Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish() // Bu aktiviteyi kapatmak istiyorsanız
            }
        }
        timer.start() // Geri sayımı başlatmak
    }
}
