package lt.markmerkk.training

import io.reactivex.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit

class ReduceTest {
    @Test
    fun filter() {
        Observable.fromArray(1, 2, 3, 4, 5, 6)
                .filter({ it % 2 == 0 })
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun distinct() {
        Observable.fromArray(1, 2, 1, 4, 1, 6)
                .distinct()
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun skip() {
        Observable.fromArray(1, 2, 3, 4, 5, 6)
                .skip(3)
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun take() {
        Observable.fromArray(1, 2, 3, 4, 5, 6)
                .take(2)
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
    }

    @Test
    fun takeWhile() {
        Observable.interval(0L, 1L, TimeUnit.SECONDS)
                .takeWhile({ tick -> tick <= 3 })
                .subscribe({
                    value -> println("onNext:$value")
                }, {
                    error -> println("onError:$error" )
                }, {
                    println("onComplete")
                })
        Thread.sleep(5000)
    }
}