package lt.markmerkk.training

import io.reactivex.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * @author mariusmerkevicius
 * @since 2017-11-09
 */
class TransformTest {

    @Test
    fun map() {
        Observable.fromArray("1", "2", "3", "4")
                .map { "a" + it }
                .subscribe(PrintSubscriber())
    }

    @Test
    fun cast() {
        Observable.fromArray(1, 2, 3, 4)
                .cast(Integer::class.java)
                .subscribe(PrintSubscriber())
    }

    @Test
    fun flatMap() {
        Observable.fromArray("1", "2", "3", "4")
                .flatMap { Observable.fromArray(it + 1, it + 2, it + 3) }
                .subscribe(PrintSubscriber())
    }

    @Test
    fun flatMap_conditional() {
        Observable.fromArray("1", "2", "3", "4")
                .flatMap {
                    if (it == "3") {
                        Observable.just(it)
                    } else {
                        Observable.empty()
                    }
                }
                .subscribe(PrintSubscriber())
    }

    @Test
    fun timestamped() {
        Observable.fromArray(1, 2, 3, 4)
                .timestamp()
                .subscribe(PrintSubscriber())
    }

    @Test
    fun timeInterval() {
        Observable.fromArray(1, 2, 3, 4)
                .timeInterval()
                .subscribe(PrintSubscriber())
    }

}