class FizzBuzz {
    private int n;
    private int current = 1;
    
    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzbuzzSem = new Semaphore(0);
    private Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    private void advance() {
        current++;
        if (current > n) {
            numberSem.release();
            fizzSem.release();
            buzzSem.release();
            fizzbuzzSem.release();
            return;
        }
        if (current % 3 == 0 && current % 5 == 0) fizzbuzzSem.release();
        else if (current % 3 == 0) fizzSem.release();
        else if (current % 5 == 0) buzzSem.release();
        else numberSem.release();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSem.acquire();
            if (current > n) break;
            printFizz.run();
            advance();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSem.acquire();
            if (current > n) break;
            printBuzz.run();
            advance();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzbuzzSem.acquire();
            if (current > n) break;
            printFizzBuzz.run();
            advance();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            numberSem.acquire();
            if (current > n) break;
            printNumber.accept(current);
            advance();
        }
    }
}
