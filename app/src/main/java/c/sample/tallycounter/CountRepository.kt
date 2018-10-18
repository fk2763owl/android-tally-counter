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

    /**
     * 取得
     */
    fun getCount(): Int? {
        realm = Realm.getDefaultInstance()
        val countData = realm.where(CountData::class.java).findAll()
        realm.close()
        return countData.get(0)?.count
    }

    /**
     * 保存
     */
    fun saveCount(countData: CountData) {
        realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(countData)
        }
        realm.close()
    }

    /**
     * 更新
     *
     * 保存と同じ処理…
     */
    fun updateCount(countData: CountData) {
        realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(countData)
        }
        realm.close()
    }

    /**
     * 削除
     */
    fun deleteCount() {
        realm = Realm.getDefaultInstance()
        realm.executeTransaction{ realm ->
            val results = realm.where(CountData::class.java).findAll();
            results.deleteAllFromRealm()
        }
        realm.close()
    }
}
