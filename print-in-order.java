class Foo {

    private Lock lock;
    private Condition a;
    private Condition b;
    private Condition c;
    private int state = 0;
    
    public Foo() {
        this.lock = new ReentrantLock();
        this.a = lock.newCondition();
        this.b = lock.newCondition();
        this.c = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            while(state != 0){
                a.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 1;
            b.signal();
        }finally{
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(state != 1){
                b.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state = 2;
            c.signal();
        }finally{
            lock.unlock();
        }
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(state != 2){
                c.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            state = 0;
            a.signal();
        }finally{
            lock.unlock();
        }
    }
}








class Foo {
    private CountDownLatch a = new CountDownLatch(1);
    private CountDownLatch b = new CountDownLatch(1);
    
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
            a.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            b.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
            b.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
    }
}
