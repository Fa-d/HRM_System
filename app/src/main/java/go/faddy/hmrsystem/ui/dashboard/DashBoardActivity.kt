package go.faddy.hmrsystem.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import go.faddy.hmrsystem.R

@AndroidEntryPoint
class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar?.hide()
    }
}