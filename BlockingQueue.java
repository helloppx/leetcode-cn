public class BlockingQueue {
    private Object[] list = null;
    private int size;
    private int count = 0;
    private int right = -1;

    public BlockingQueue(int size) {
        this.size = size;
        this.list = new Object[size];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == size;
    }

    public synchronized void offer(Object obj) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        list[++right] = obj;
        count++;
        notify();
    }

    public synchronized Object poll() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        count--;
        Object res = list[0];
        for (int i = 0; i < right; i++) {
            list[i] = list[i + 1];
        }
        right--;
        notify();
        return res;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue q = new BlockingQueue(2);
        Thread a = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    q.offer(i);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        Thread aa = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    q.offer("X" + i );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        Thread b = new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    Object o = q.poll();
                    System.out.println("poll " + o);
//                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        a.start();
        aa.start();
        b.start();
        a.join();
        aa.join();
        b.join();
    }
}

