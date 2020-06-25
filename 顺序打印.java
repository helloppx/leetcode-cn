class Foo {

    private volatile boolean one = true;
    private volatile boolean two = false;
    private volatile boolean three = false;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(!one){

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two = true;
        one = false;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!two){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three = true;
        two = false;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!three){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        one = true;
        three = false;
    }
}


class Foo {
    private Semaphore a = new Semaphore(1);
    private Semaphore b = new Semaphore(0);
    private Semaphore c = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        a.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        b.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        b.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        a.release();
    }
}
