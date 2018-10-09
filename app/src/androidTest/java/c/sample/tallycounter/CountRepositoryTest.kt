package c.sample.tallycounter

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import c.sample.tallycounter.Data.CountData
import io.realm.Realm
import junit.framework.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CountRepositoryTest {

    // 取得
    fun getCount() {
        // Given サンプルデータを用意した状態で
        var realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm ->  
            val obj = realm.createObject(CountData::class.java!!, 1)
            obj.count = 1
        }

        // When 取得すると



        // Then 保存したデータと同じデータを取得できる。
    }

    // 保存、取得
    fun saveCount() {
        // Given サンプルデータを用意した状態で

        // When 保存すると

        // Then リポジトリ

    }

    // 更新

}