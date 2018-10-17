package c.sample.tallycounter

import c.sample.tallycounter.Data.CountData
import io.realm.Realm
import io.realm.RealmResults

/**
 * カウントリポジトリ
 * CRUD操作を行う。
 * CountRepository.getCountでカウントデータ
 * CountRepository.saveCountで
 */
class CountRepository() {

    // Realm
    private lateinit var realm: Realm

    // 取得
    fun getCount(): Int{
        realm = Realm.getDefaultInstance()
        val countData:Int = realm.where(CountData::class.java).equalTo("count", 0)

        return countData
    }

    // 保存
    fun saveCount() {

    }
}
