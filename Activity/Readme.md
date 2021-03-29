# What I am trying to achieve in this app

## Activity
which can be the first activity to get launched how to ensure ?  
lifecycle of activity - which lifecycle methods gets called when ?  
Intent - moving from 1 activity to another using intent and passing extra data  

## Fragment


## Navigation with fragment




















# Activity:
[activity theory](https://developer.android.com/guide/components/activities/intro-activities)  
- activity tag in manifest file and check all major options - intent-filter (action, category,data) 
[activity tag all options](https://developer.android.com/guide/topics/manifest/activity-element)  
[intent-filter tag all options](https://developer.android.com/guide/topics/manifest/intent-filter-element)  
contained in - activity, receiver, service etc  
what intent-filter contains - action, category, data etc  
intent filer attributes - 

[all about inents and what they convey](https://developer.android.com/guide/components/intents-filters)  

- permissions in manifest vs requesting at runtime  
- activity lifecycle  
- activity state changes - configuration changes, other activity appers in foreground, back button used, system kills activity  
- activity on back stack and something about task  
- Parcelables and Bundles - share data  
- fragments  
- interacting with other app and allowing your app to be called from others  


[activity api reference](https://developer.android.com/reference/android/app/Activity)

- see what api level Activty works and when we will be needing AppCompatActivity - anyway using AppCompatActivity is better  
as it will use Activity available and falls back when not available  
