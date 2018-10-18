package c.sample.tallycounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*

/**
 * メインアクティビティ
 * トップ画面のアクティビティ。
 */
class MainActivity : AppCompatActivity() {

    var i = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Log.d("MainActivity", "button click")
            i += 1
            textView.text = i.toString()
        }
    }
}
