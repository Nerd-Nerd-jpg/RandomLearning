package com.example.randomlearning

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class CashFlowRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val timestamp: Long,
    val incomeOrNot: Boolean,
    val category: Int,
    val amount: Double,
    val comment: String
)

@Dao
interface CashFlowRecordDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCashFlowRecord(cashFlowRecord: CashFlowRecord)

    @Query("SELECT * FROM CashFlowRecord ORDER BY id DESC")
    fun getCashFlowRecord() : MutableList<CashFlowRecord>

    @Query("DELETE FROM CashFlowRecord")
    fun deleteCashFlowRecord()
}

@Database(entities = [CashFlowRecord::class], version = 1)
abstract class CashFlowDatabase: RoomDatabase() {
    abstract val cashFlowRecordDao: CashFlowRecordDao

    companion object { const val DATABASE_NAME = "cash_flow_db" }
}