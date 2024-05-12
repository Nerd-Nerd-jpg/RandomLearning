package com.example.randomlearning

//region InsertCashFlowRecordUseCase
class InsertCashFlowRecordUseCase(
    private val repository: CashFlowRecordRepositoryDef
) {
    //for some reason, applying the try catch block here does nothing to stop a crash if bad values are entered
    suspend operator fun invoke(cashFlowRecord: CashFlowRecord): Result<Unit> {
        try {
            return Result.Success(repository.insertCashFlowRecord(cashFlowRecord))
        }
        catch (e: java.lang.Exception) {
            return Result.Failure("Insert Cash Flow Record Fail")
        }
    }
}
//endregion

//region GetCashFlowRecordsUseCase
class GetCashFlowRecordsUseCase(
    private val repository: CashFlowRecordRepositoryDef
) {
    suspend operator fun invoke(): Result<List<CashFlowRecord>> {
        try {
            return Result.Success(repository.getCashFlowRecords())
        }
        catch(e:java.lang.Exception) {
            return Result.Failure("Get Cash Flow Records Fail: " + e.toString())
        }
    }
}
//endregion

//region DeleteCashFlowRecordsUseCase
class DeleteCashFlowRecordsUseCase(
    private val repository: CashFlowRecordRepositoryDef
) {
    suspend operator fun invoke(): Result<Unit> {
        try{
            return Result.Success(repository.deleteCashFlowRecord())
        }
        catch (e:java.lang.Exception) {
            return Result.Failure("Delete Cash Flow Record fail")
        }
    }
}
//endregion

sealed class Result<out T> {
    companion object {
        const val ERROR_CODE_UNAUTHORIZED = 401
    }
    data class Success<T>(val data: T?) : Result<T>()
    data class Failure(val errors: String?, val errorCode: Int? = null, val rawException: Throwable? = null) : Result<Nothing>()
    object NetworkError : Result<Nothing>()
}
