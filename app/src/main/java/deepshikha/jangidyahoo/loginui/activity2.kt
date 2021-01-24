package deepshikha.jangidyahoo.loginui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_activity2.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URL
import kotlin.concurrent.timer

class activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity2)

        Toast.makeText(this, "click on welcome to continue", Toast.LENGTH_LONG).show()
        val welcome = findViewById<TextView>(R.id.welcome)
        welcome.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out)
            welcome.startAnimation(animation)
            welcome.isEnabled = false
        }



        doAsync {
            val result =
                URL("https://news.google.com/covid19/map?hl=en-IN&mid=/m/02j71&gl=IN&ceid=IN:en").readText()
            uiThread {
                longToast(result)
            }
        }
    }
}