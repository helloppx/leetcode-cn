class FizzBuzz {

    private int n;
    private AtomicInteger i = new AtomicInteger(1);
    private Semaphore number = new Semaphore(0);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);
    private volatile boolean flag = true;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(flag) {
            fizz.acquire();
            if(!flag) return;
            i.getAndIncrement();
            printFizz.run();
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(flag){
            buzz.acquire();
            if(!flag) return;
            i.getAndIncrement();
            printBuzz.run();
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(flag) {
            fizzbuzz.acquire();
            if(!flag) return;
            i.getAndIncrement();
            printFizzBuzz.run();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i.get() <= n){
            if(i.get() % 3 == 0 && i.get() % 5 == 0){
                fizzbuzz.release();
                number.acquire();
            }else if(i.get() % 3 == 0) {
                fizz.release();
                number.acquire();
            }else if(i.get() % 5 == 0) {
                buzz.release();
                number.acquire();
            }else{
                printNumber.accept(i.getAndIncrement());
            }
        }
        flag = false;
        buzz.release();
        fizz.release();
        fizzbuzz.release();
    }
}
