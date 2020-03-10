class H2O {
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);
    
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
	h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        h.release(2);
    }
}


class H2O {
    private Lock lock = new ReentrantLock();
    private Condition h = lock.newCondition();
    private Condition o = lock.newCondition();
    private int state = 0;
    
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try{
            while(state == 0){
                h.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            
            if(state == 2) {
                state = 0;
                o.signal();
            }else{
               state++;
            }
        }finally{
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try{
            while(state != 0) {
                o.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
		    releaseOxygen.run();
            state = 1;
            h.signal();
        }finally{
            lock.unlock();
        }
    }
}




class H2O {
    private int state = 0;
    
    public H2O() {
        
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while(state == 0){
            wait();
        }
        
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(state == 1){
            state = 2;
        }else {
            state = 0;
        }
        notify();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(state != 0){
            wait();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        state = 1;
        notify();
    }
}
