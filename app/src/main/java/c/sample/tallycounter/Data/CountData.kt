package c.sample.tallycounter.Data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

/**
 * カウントデータ
 *
 * クラスにopenがついている理由は以下
 * Realmのデータベースはテーブルにアクセスするために中でModelクラスを継承する必要があります。
 * しかしながらKotlinのデフォルトではJavaでいうfinalクラスで定義され、継承ができなくなってしまいます。
 * この状況を防ぐためにopen修飾子をつけています。
 */
open class CountData(
        @PrimaryKey var id: Int = 0,
        var count: Int = 0
): RealmObject() {

}
