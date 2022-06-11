package go.faddy.hmrsystem.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import go.faddy.hmrsystem.R

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        supportActionBar?.hide()
    }
}