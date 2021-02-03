# Coroutines:
its a green thread
TODO: learn the meaning of green thread and why it is better(when to use) in places of normal thread

## dependency:
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2'
this dependency is required for coroutines to work

## creating coroutines:
we can create green thread by using launch{} or async{}
TODO: how launch and async are different

## withContext:
TODO: how it is different than launch and async
so i think withContext() will always gets executed serially on background thread whereas code written in async/launch
can execute in any order determined by library not in the order code is written

e.g
withContext() - this will always be executed first
withContext() - then this one is executed as in order code is written

launch{} - this even though written first in code but can be executed 1st/2nd/3rd
launch{} -
launch{} - this block though written last can be executed 1st or 2nd/3rd

## thread or threadpools inside android:
Main: main thread where android usually keeps its UI(drawing on the screen stuff like activity etc)
IO: this thread is used for IOs like disk io, network io etc
Default: threadpool for all other stuffs/code you want to run
now how we will tell android which one to use for that we will use Dispatchers
Dispatchers.Main = Main thread
Dispatchers.IO = IO thread
Dispatchers.Default = Default thread

TODO: accessing main thread in android app normally writing Dispatchers.Main does not allow access some dependency has to be added. find out

## scope of coroutines:
we can start creating coroutines left and right may be even in 1000s cancelling/joining these will be tough task
so coroutines are launched in a scope when we will cancel the scope all corotines launched by it will get cancelled

scope can be given thread (Main,IO,Default) on which it will launch all coroutines inside this scope
launch/async can also take thread (Main,IO,Default) which will override the thread (Main,IO,Default) told in scope

GlobalScope = this is like all threads running in global scope
CoroutineScope = this will let you create own scope
MainScope = this is scope created using Main thread (implicit Dispatcher.Main)

TODO: in your code show how can we create a scope launch 2,3 coroutines and cancel these coroutines using this scope

## suspend functions:
TODO: why not use regular function, whats this all about marking it suspend
so suspend function will not block the underlying thread(cpu thread)
so this is done by writing such code which will not block or suspend does some magic by adding code which will never block
even if blocking code is there

## channels:
channels let u wait on the green thread/coroutines until data is not received from channel from some other coroutines
1. create channel
2. send something from this channel from coroutine which you want to run first
3. receive on channel from coroutine which you want to run after

## Mutex:
this is data which can be modified when we explicitly take lock and are succesful in taking lock,
no other coroutines in the meantime can modify this data and take a lock.
once Mutex is unlocked other coroutines can take lock and make changes
