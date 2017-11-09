package lt.markmerkk.training

import io.reactivex.Observable
import org.junit.Test

class SideEffectsTest {

    @Test
    fun side_effect1() {
        Observable.fromArray("1", "2", "3", "4")
                .doOnNext({ println("next <-> text") })
                .subscribe(PrintSubscriber())
    }

    @Test
    fun side_effect2() {
        Observable.fromArray("1", "2", "3", "4")
                .doOnEach({ println("each <-> peach") })
                .subscribe(PrintSubscriber())
    }

    @Test
    fun side_effect_progress() {
        Observable.fromArray("1", "2", "3", "4")
                .doOnSubscribe({ println("subscribed") })
                .doOnTerminate({ println("terminated") })
                .subscribe(PrintSubscriber())
    }

}