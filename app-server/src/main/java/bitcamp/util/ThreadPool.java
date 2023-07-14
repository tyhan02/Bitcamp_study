package bitcamp.util;

import java.util.ArrayList;

public class ThreadPool implements ResourcePool<ManagedThread>{

    ArrayList<ManagedThread> list = new ArrayList<>();

    //  public ThreadPool() {
    //    for (int i = 0; i < 3; i++) {
    //      ManagedThread t = new ManagedThread(this);
    //      t.start();
    //      list.add(t);
    //    }
    //  }

    @Override
    public ManagedThread getResource() {
        ManagedThread t = null;

        if (list.size() == 0) {
            t = new ManagedThread(this);
            System.out.printf("새 스레드 생성: %d\n", t.key);
            t.start();
            //위에서 생성한 스레드가 바로 실행 될 수 있도록 main 스레드는 잠시 cpu 사용권 반납
            // 스레드 실행시 jobbox 객체에 대해 대기 상태가 된다
            try {
                Thread.sleep(100);
            } catch (Exception e) {}

            return t;
        }

        t = list.remove(0);
        System.out.printf("기존 스레드 리턴: %d\n", t.key);
        return t;
    }

    @Override
    public void returnResource(ManagedThread resource) {
        list.add(resource);
        System.out.printf("스레드 반납: %d\n", resource.key);
    }
}