package org.example;

public interface Observer<M> {
    void notify(M message);
}
