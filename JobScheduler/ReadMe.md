# JobScheduler

schedule a job which is to be executed 

JobScheduler has two parts  
- JobInfo  
- JobService  

JobInfo will describe what will be the required conditions when Job can be run such as wifi on, device idle etc  
JobInfo.Builder is class which will help in creating JobInfo  
Builder(int jobId, ComponentName jobService)   

jobId is an integer number which is used for identifying different jobs. that means different jobId means different job  
ComponentName = package name + class name will make a unique Component(Activity, Service, Broadcast) etc

see these constructors for ComponentName creation 
ComponentName(String pkg, String cls)  
ComponentName(Context pkg, String cls)   
ComponentName(Context pkg, Class<?> cls)  

one way to create   
val serviceName: ComponentName = ComponentName(getPackageName(),CustomJobService.class.getName());  

[JonInfo api reference](https://developer.android.com/reference/android/app/job/JobInfo)

JobService describes the logic which is to be run by JobScheduler (i.e. code to be run)  inheriting from 

for this we will create our own class inheriting from JobService  

[JobService api reference](https://developer.android.com/reference/android/app/job/JobService)  

in reference under constants check this PERMISSION_BIND  

<service
   android:name=".CustomJob"
   android:permission="android.permission.BIND_JOB_SERVICE"/>
why this is required in manifest withot this JobSchedular doesn't work  

