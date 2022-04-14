package com.ve.module.android.repository.database.dao

import androidx.room.*
import com.ve.module.android.repository.database.entity.SearchHistory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Created by yechaoa on 2020/2/4.
 * Describe :
 */
@Dao
interface HistoryDao {

    /**
     * @Insert：增
     * @Delete：删
     * @Update：改
     * @Query：查，此注解需要传入SQL语句作为参数，SQL语句用来限定查询的条件，注意如果是按条件删除数据等操作，也可以使用此注解来修饰。
     */
//Kotlin协程中使用挂起函数（Suspend函数）可以异步地返回单个计算结果，但是如果有多个计算结果希望通过协程的方式异步返回，这时可以使用Flow
    //按类型 查询所有搜索历史，时间倒序 type类型 自己定
    @Query("SELECT * FROM t_history WHERE type=:type ORDER BY insert_time DESC")
    fun getAll(type: Int = 1): Flow<List<SearchHistory>>

    /**
     * 因为 SQLite 数据库的内容更新通知功能是以表 (Table) 数据为单位，而不是以行 (Row) 数据为单位，因此只要是表中的数据有更新，它就触发内容更新通知。
     * Room 不知道表中有更新的数据是哪一个，因此它会重新触发 DAO 中定义的 query 操作。
     * 您可以使用 Flow 的操作符，比如 distinctUntilChanged 来确保只有在当您关心的数据有更新时才会收到通知
     */
    @ExperimentalCoroutinesApi
    fun getAllDistinctUntilChanged() = getAll().distinctUntilChanged()

    //根据name 查询一条搜索历史
    @Query("SELECT id FROM t_history WHERE name = :name")
    fun queryIdByName(name: String): Int?

    //添加一条搜索历史  重复则替换@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    fun insert(history: SearchHistory)

    //更新一条搜索历史
    @Update
    fun update(history: SearchHistory)

    //删除一条搜索历史
    @Delete
    fun delete(history: SearchHistory)

    //根据id 删除一条搜索历史
    @Query("DELETE FROM t_history WHERE id = :id")
    fun deleteByID(id: Int)

    //删除所有搜索历史
    @Query("DELETE FROM t_history")
    fun deleteAll()
}