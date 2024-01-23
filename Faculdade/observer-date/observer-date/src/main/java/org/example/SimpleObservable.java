package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SimpleObservable<M> implements Observable<M> {

    private Map<Observer<M>, Predicate<M>> subscriptions = new HashMap<>();

    @Override
    public void subscribe(Observer<M> observer, Predicate<M> filter) {
        subscriptions.put(observer, filter);
    }

    public void notifyObservers(M message) {
        subscriptions.forEach((observer, filter) -> {
            if (filter.test(message)) observer.notify(message);
        });
    }
}
