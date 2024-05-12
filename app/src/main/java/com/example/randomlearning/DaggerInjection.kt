package com.example.randomlearning

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCashFlowDatabase(app: Application): CashFlowDatabase {
        return Room.databaseBuilder(
            app,
            CashFlowDatabase::class.java,
            CashFlowDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCashFlowRepository(db: CashFlowDatabase): CashFlowRecordRepositoryDef {
        return CashFlowRecordRepositoryImpl(db.cashFlowRecordDao)
    }

    @Provides
    @Singleton
    fun provideInsertCashFlowRecordUseCases(repository: CashFlowRecordRepositoryDef): InsertCashFlowRecordUseCase {
        return InsertCashFlowRecordUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideViewCashFlowRecordsPageUseCases(repository: CashFlowRecordRepositoryDef): ViewCashFlowRecordsPageUseCases {
        return ViewCashFlowRecordsPageUseCases(
            getCashFlowRecordsUseCase = GetCashFlowRecordsUseCase(repository),
            insertCashFlowRecordUseCase = InsertCashFlowRecordUseCase(repository),
            deleteCashFlowRecordsUseCase = DeleteCashFlowRecordsUseCase(repository)
        )
    }
}

data class ViewCashFlowRecordsPageUseCases(
    val getCashFlowRecordsUseCase: GetCashFlowRecordsUseCase,
    val insertCashFlowRecordUseCase: InsertCashFlowRecordUseCase,
    val deleteCashFlowRecordsUseCase: DeleteCashFlowRecordsUseCase
)
//