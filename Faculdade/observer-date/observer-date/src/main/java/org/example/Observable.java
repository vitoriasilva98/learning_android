package org.example;

import java.util.function.Predicate;

public interface Observable<M> {
    void subscribe(Observer<M> observer, Predicate<M> filter);

    default void subscribe(Observer<M> observer) {
        subscribe(observer, message -> true);
    }
}
