package com.aashoo17.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        //getting scheduler is easy just get the running service and cast it
        val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        //build JobInfo: CustomJob::class.java.getName() => is it java reflection
        val serviceName = ComponentName(packageName,CustomJobService::class.java.name)

        val jobId = 0
        val jobInfo = JobInfo.Builder(jobId,serviceName).apply {
            //select any network type
            setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            setRequiresCharging(true)
        }.build()

        jobScheduler.schedule(jobInfo)
    }

}



