package lt.markmerkk.training

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class PrintSubscriber : Observer<Any> {

    override fun onNext(t: Any) {
        println("onNext:$t")
    }

    override fun onError(t: Throwable) {
        println("onError:$t")
    }

    override fun onComplete() {
        println("onComplete")
    }

    override fun onSubscribe(d: Disposable) {
        println("onSubscribe")
    }

}