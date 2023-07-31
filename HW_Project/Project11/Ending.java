package Project11;


class EndingThread extends Thread{

    @Override
    public void run() {

        String ending[] = {"종료"};

        for(int i=0;i<ending.length;i++){
            System.out.println(ending[i]);

            try {
                sleep(100);
            } catch (Exception e) {

            }
        }
        System.out.println();
    }

}


public class Ending {

    public static void main(String[] args) {

        EndingThread ed = new EndingThread();
        System.out.println("\n\n\n\n");

        ed.start();

        try {
            ed.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
