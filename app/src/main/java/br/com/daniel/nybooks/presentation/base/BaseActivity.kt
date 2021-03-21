package br.com.daniel.nybooks.presentation.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


open class BaseActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int) {
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
    }
}