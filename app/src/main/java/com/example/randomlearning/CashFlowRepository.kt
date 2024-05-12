package com.example.randomlearning

interface CashFlowRecordRepositoryDef {
    suspend fun insertCashFlowRecord(cashFlowRecord: CashFlowRecord)
    suspend fun getCashFlowRecords(): List<CashFlowRecord>
    suspend fun deleteCashFlowRecord()
}

class CashFlowRecordRepositoryImpl(
    private val dao: CashFlowRecordDao
) : CashFlowRecordRepositoryDef {

    override suspend fun insertCashFlowRecord(cashFlowRecord: CashFlowRecord) {
        dao.insertCashFlowRecord(cashFlowRecord)
    }

    override suspend fun getCashFlowRecords(): List<CashFlowRecord> {
        return dao.getCashFlowRecord()
    }

    override suspend fun deleteCashFlowRecord() {
        return dao.deleteCashFlowRecord()
    }
}