import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

public class ReactivePractice {

	public static void main(String[] args) throws InterruptedException {
		ConnectableObservable<Long> obs = Observable.interval(1, TimeUnit.SECONDS).publish();
		obs.subscribe(new Action1<Long>() {

			public void call(Long t) {
				System.out.println("Next called  "+t.toString());
			}
		});
		obs.connect();
		Thread.sleep(10000l);
	}

}
