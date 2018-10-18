package c.sample.tallycounter

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import c.sample.tallycounter.Data.CountData
import io.realm.Realm
import io.realm.RealmResults
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * カウントリポジトリ
 *
 * カウンタリポジトリのCRUD操作について
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class CountRepositoryTest {

    // Realm
    private lateinit var realm: Realm

    @Before
    fun setUp() {
        realm = Realm.getDefaultInstance()
    }

    @After
    fun complete() {
        realm.close()
    }

    // 取得
    @Test
    fun getCount() {
        // Given サンプルデータを用意した状態で
        val countData = CountData()
        countData.id = 1
        countData.count = 12

        realm.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(countData)
        }

        // When 取得すると
        val countRepository = CountRepository()
        val count = countRepository.getCount();

        // Then 保存したデータと同じデータを取得できる。
        assertEquals(countData.count, count)
    }

    // 保存
    @Test
    fun saveCount() {
        // Given サンプルデータを用意した状態で
        val countData = CountData()
        countData.id = 1
        countData.count = 34

        // When 保存すると
        val countRepository = CountRepository()
        countRepository.saveCount(countData)

        // Then リポジトリ
        assertEquals(countData.count, countRepository.getCount())
    }

    // 更新
    @Test
    fun updateCount() {
        // Given サンプルデータが保存してある状態で
        val countData = CountData()
        countData.id = 1
        countData.count = 56

        val countRepository = CountRepository()
        countRepository.saveCount(countData)

        // When 異なる値に更新すると
        countData.count = 78
        countRepository.updateCount(countData)

        // Then 更新された値が取得できる。
        assertEquals(countData.count, countRepository.getCount())
    }

    // 削除
    @Test
    fun deleteCount() {
        // Given サンプルデータが保存してある状態で
        val countData = CountData()
        countData.id = 1
        countData.count = 90

        val countRepository = CountRepository()
        countRepository.saveCount(countData)

        assertEquals(countData.count, countRepository.getCount())


        // When 削除すると
        countRepository.deleteCount()

        // Then タスクリポジトリは空になる。
        val test = realm.where(CountData::class.java).findAll()
        assertEquals(0, test.size)
    }
}