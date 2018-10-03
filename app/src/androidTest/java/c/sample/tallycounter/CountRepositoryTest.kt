package c.sample.tallycounter

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CountRepositoryTest {

    // 取得
    fun getCount() {
        // Given
        // When
        // Then
    }

    // 保存、取得
    fun saveCount() {
        // Given サンプルデータを用意した状態で
        val sampleData = new Count(1)

        // When 保存すると
        count.save

        // Then リポジトリ
        assertEquals(sampleData, count.get())
    }

    // 更新

}