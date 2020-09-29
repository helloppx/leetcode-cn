class ZeroEvenOdd {
    private volatile int zeroLimit;
    private volatile int evenLimit;
    private volatile int oddLimit;

    private boolean flagA = false;
    private boolean flagB = false;
    private boolean flagC = false;
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        if(n % 2 == 0){
            this.zeroLimit = n;
            this.evenLimit = n;
            this.oddLimit = n - 1;
        }else{
            this.zeroLimit = n;
            this.oddLimit = n;
            this.evenLimit = n - 1;
        }
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(zeroLimit > 0) {
            try{
                lock.lock();
                zeroLimit--;
                while(flagA) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                if(num % 2 == 0) {
                    flagA = true;
                    flagB = true;
                    oddCondition.signalAll();
                }else{
                    flagA = true;
                    flagC = true;
                    evenCondition.signalAll();
                }
            }finally{
                lock.unlock();
            }
        }
    }

    public  void even(IntConsumer printNumber) throws InterruptedException {
        while(evenLimit > 0) {
            try{
                lock.lock();
                evenLimit -= 2;
                while(!flagC) {
                    evenCondition.await();
                }
                printNumber.accept(++num);
                flagA = false;
                flagC = false;
                zeroCondition.signal();
            }finally{
                lock.unlock();
            }
        }
    }


    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(oddLimit > 0) {
            try{
                lock.lock();
                oddLimit -= 2;
                while(!flagB) {
                    oddCondition.await();
                }
                printNumber.accept(++num);
                flagA = false;
                flagB = false;
                zeroCondition.signal();
            }finally{
                lock.unlock();
            }
        }
    }
}
