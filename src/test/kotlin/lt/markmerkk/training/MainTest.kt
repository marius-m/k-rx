package lt.markmerkk.training

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.junit.Test
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

/**
 * @author mariusmerkevicius
 * @since 2017-11-09
 */
class MainTest {

    @Test
    fun just_1() {
        Observable.just(1)
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun from() {
        val subscription: Disposable = Observable.fromArray(1, 2, 3, 4, 5)
                .subscribe({ value ->
                    println("onNext:$value")
                }, { error ->
                    println("onError:$error")
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun error() {
        Observable.error<Any>(RuntimeException())
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun empty() {
        Observable.empty<Any>()
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun never() {
        Observable.never<Any>()
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun create() {
        Observable.create<String>({ observable ->
            observable.onNext("value_1")
            observable.onNext("value_2")
            observable.onNext("value_3")
            observable.onComplete()
        }).subscribe({ value ->
            println("onNext:$value")
        }, { error ->
            println("onError:$error")
        }, {
            println("onComplete")
        })
    }

    @Test
    fun interval() {
        Observable.interval(1L, TimeUnit.SECONDS)
                .subscribe({ value ->
                    println("onNext:$value")
                }, { error ->
                    println("onError:$error")
                }, {
                    println("onComplete")
                })
        Thread.sleep(5000)
    }

    @Test
    fun interval_withComplete() {
        val subscription: Disposable = Observable.interval(1L, TimeUnit.SECONDS)
                .subscribe({ value ->
                    println("onNext:$value")
                }, { error ->
                    println("onError:$error")
                }, {
                    println("onComplete")
                })
        Thread.sleep(3000)
        subscription.dispose()
        println("Disposed")
        Thread.sleep(3000)
    }

}