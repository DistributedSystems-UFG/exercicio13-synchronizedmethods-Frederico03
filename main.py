import threading

class SynchronizedCounter:
    def __init__(self):
        self._c = 0
        self._lock = threading.Lock()

    def increment(self):
        with self._lock:
            self._c += 1

    def decrement(self):
        with self._lock:
            self._c -= 1

    def value(self):
        with self._lock:
            return self._c

if __name__ == "__main__":
    counter = SynchronizedCounter()
    iterations = 100000

    t1 = threading.Thread(target=lambda: [counter.increment() for _ in range(iterations)])
    t2 = threading.Thread(target=lambda: [counter.decrement() for _ in range(iterations)])

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print(f"Final counter value: {counter.value()}")
