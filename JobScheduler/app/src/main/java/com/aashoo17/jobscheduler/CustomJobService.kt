package com.aashoo17.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.widget.Toast

class CustomJobService: JobService(){
    override fun onStartJob(params: JobParameters?): Boolean {

        //what to do inside this background job
        Toast.makeText(applicationContext,"from JobScheduler", Toast.LENGTH_LONG).show()

        //don't send the task on different thread
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {

        // if the job is not finished. If the return value is true, the job is rescheduled; otherwise, the job is dropped.
        return false
    }

}