package lt.markmerkk.training

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * @author mariusmerkevicius
 * @since 2017-11-09
 */
class PrintSubscriber : Subscriber<Any> {
    override fun onNext(t: Any?) {
        println("onNext:$t")
    }

    override fun onError(t: Throwable?) {
        println("onError:$t")
    }

    override fun onSubscribe(s: Subscription?) {
        println("onSubscribe:$s")
    }

    override fun onComplete() {
        println("onComplete")
    }
}