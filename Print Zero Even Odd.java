class ZeroEvenOdd {
   private int n;
    private boolean flag = true;
    private int count = 0;

    private Semaphore zero = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            printNumber.accept(0);
            if (flag) {
                flag = false;
                odd.release();
            } else {
                flag = true;
                even.release();
            }
            zero.acquire();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        double x = Math.ceil(n / 2.0);
        for (int i = 0; i < x; i++) {
            odd.acquire();
            printNumber.accept(++count);
            zero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int x = n / 2;
        for (int i = 0; i < x; i++) {
            even.acquire();
            printNumber.accept(++count);
            zero.release();
        }
    }
}
