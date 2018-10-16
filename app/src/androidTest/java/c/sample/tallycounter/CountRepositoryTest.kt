package c.sample.tallycounter

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import c.sample.tallycounter.Data.CountData
import io.realm.Realm
import junit.framework.Assert.assertEquals
import org.junit.runner.RunWith

/**
 * カウントリポジトリ
 *
 * カウンタリポジトリのCRUD操作について
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class CountRepositoryTest {

    // サンプルデータ
    // val countData = CountData(1,1)

    // Realm
    private lateinit var realm: Realm

    // 取得
    fun getCount() {
        // Given サンプルデータを用意した状態で

        realm = Realm.getDefaultInstance()

        realm.executeTransaction { realm ->
            val countData = realm.createObject<CountData>(CountData::class.java, 0)
        }

        // When 取得すると
        val countRepository = CountRepository()
        val ideal = countRepository.getCount();

        // Then 保存したデータと同じデータを取得できる。
        assertEquals(ideal, CountData(0))
    }

    // 保存、取得
    fun saveCount() {
        // Given サンプルデータを用意した状態で

        // When 保存すると

        // Then リポジトリ

    }

    // 更新

}