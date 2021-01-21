package com.lav.learnandroidthings.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_test_coroutine.*
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

private const val TAG = "CoroutineTest>>>>"

class CoroutineTestActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coroutine)
        job = Job()
        btn.setOnClickListener {
            Log.i(TAG, "BtnClick on thread : ${Thread.currentThread().name}")
            //testGlobalScopeLaunch()
            //testGlobalScopeAsync()
//            testWithContext()
            //testExceptionHandler()
            testRunBlocking()
        }
        btn_start.setOnClickListener {
            testJob()
        }
        btn_stop.setOnClickListener {
            cancelJob()
        }
    }

    private fun testGlobalScopeLaunch() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                throw IOException()
            } catch (e: Exception) {
                Log.i(TAG, "Exception handled: $e")
            }
        }
    }

    private fun testExceptionHandler() {
        GlobalScope.launch(Dispatchers.Main + handler) {
            Log.i(
                TAG,
                "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
            )
            count()
            throw IOException()
        }
    }

    private fun testGlobalScopeAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            val result1 = async(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Success"
                throw IOException()
            }
            val result2 = async(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Failure"
            }
            /*Log.i(
                TAG,
                "Result from async is  : $result1 & $result2 on thread ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
            )*/

            combinedResult(result1.await(), result2.await())
        }
    }

    private fun testWithContext() {
        GlobalScope.launch(Dispatchers.Main) {
            val result1 = withContext(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Success"
            }
            val result2 = withContext(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Failure"
            }
            Log.i(
                TAG,
                "Result from async is  : $result1 & $result2 on thread ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
            )
            combinedResult(result1, result2)
        }
    }

    private fun testJob() {
        launch {
            val result1 = async(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Success"
            }
            val result2 = async(Dispatchers.IO) {
                Log.i(
                    TAG,
                    "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
                )
                count()
                "Failure"
            }
            combinedResult(result1.await(), result2.await())
        }
    }

    private suspend fun count() {
        for (i in 1..30) {
            delay(20)
            Log.i(TAG, "Number: $i")
        }
    }

    private fun combinedResult(result1: String, result2: String) {
        Log.i(TAG, "Results are $result1 & $result2")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler

    private fun cancelJob() {
        job.cancel()
    }

    override fun onDestroy() {
        cancelJob()
        super.onDestroy()
    }

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.i(TAG, "Exception handled: $exception")
    }

    private fun testRunBlocking() {
        /* runBlocking {
             Log.i(
                 TAG,
                 "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
             )
             count()
         }*/
        val deferred = GlobalScope.async(Dispatchers.IO) {
            Log.i(
                TAG,
                "Running on thread : ${Thread.currentThread().name} & coroutinecontext: $coroutineContext"
            )
            count()
            //delay(2000L)
            "World!"
        }
        runBlocking {
            delay(60000L) // This is not crashing app
//            Thread.sleep(60000L) // This is crashing app
            Log.i(TAG, "Hello ${deferred.await()}")
        }
        Log.i(TAG, "After runBlocking")
    }
}