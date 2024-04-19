--- 
    
    class WorkManagerWaterRepository(context: Context) : WaterRepository {
        private val workManager = WorkManager.getInstance(context)
    
        override val plants: List<Plant>
            get() = DataSource.plants
    
        override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) {
            val data = Data.Builder()
            data.putString(WaterReminderWorker.nameKey, plantName)
    
            val workRequestBuilder = OneTimeWorkRequestBuilder<WaterReminderWorker>()
                .setInitialDelay(duration, unit)
                .setInputData(data.build())
                .build()
    
            workManager.enqueueUniqueWork(
                plantName + duration,
                ExistingWorkPolicy.REPLACE,
                workRequestBuilder
            )
        }
    }

---
