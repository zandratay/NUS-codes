import java.util.function.Function;

class Maybe<T> {
    private final T thing;
    //private final Supplier<T> supplier;
    
    protected Maybe(T thing) {
        this.thing = thing;
    }

    /*
    public T getThing() {
        return this.thing;
    }
    */

    static <U> Maybe<U> of(U thing) {
        if (thing == null) {
            throw new NullPointerException();
        }
        return new Maybe<U>(thing);
    }

    static <T> Maybe<T> empty() {
        return new Maybe<T>(null);
    }

    static <U> Maybe<U> ofNullable(U thing) {
        if (thing == null) {
            return Maybe.<U>empty();
        } 
        return new Maybe<U>(thing);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { // trivial case
            return true;
        } else if (this.thing == null) {
            return other.toString().compareTo(Maybe.empty().toString()) == 0;
        } else if (other instanceof Maybe<?> maybe) {
            return this.thing.equals(maybe.thing);
        //} else if (this.thing == null) {
            //return other.toString().compareTo(this.toString()) == 0;
        } else {
            return false;
        }
    }

    Maybe<T> filter(Predicate<? super T> pred) {
        if (this.toString().compareTo(Maybe.empty().toString()) == 0) {
            return Maybe.empty();
        } else if (pred.test(thing)) {
            return this;
        } else {
            return Maybe.empty();
        }
    }

    void ifPresent(Consumer<? super T> action) {
        if (thing == null) {
            // do nothing
        } else {
            action.accept(thing);
        }
    }

    void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (thing == null) {
            emptyAction.run();
        } else {
            action.accept(thing);
        }
    }

    T orElse(T other) {
        if (thing != null) {
            return thing;
        } else {
            return other;
        }
    }

    T orElseGet(Supplier<? extends T> supplier) {
        if (thing != null) {
            return thing;
        } else {
            return supplier.get();
        }
    }

    Maybe<T> or(Supplier<? extends Maybe<? extends T>> supplier) {
        if (thing != null) {
            return this;
        } else {
            Maybe<? extends T> maybe = supplier.get();
            return Maybe.<T>ofNullable(maybe.thing);
        }
    }

    <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
        if (this.thing == null) {
            return Maybe.<R>empty();
        } else {
            return Maybe.<R>of(mapper.apply(this.thing));
        }
    }
    
    <R> Maybe<R> flatMap(Function<? super T, ? extends Maybe<? extends R>> mapper) {
        Maybe<? extends R> maybe = mapper.apply(this.thing);
        return Maybe.<R>ofNullable(maybe.thing);
    }

    @Override
    public String toString() {
        if (this.thing == null) {
            return "Maybe.empty";
        } else {
            return "Maybe[" + this.thing + "]";
        }
    }
}
