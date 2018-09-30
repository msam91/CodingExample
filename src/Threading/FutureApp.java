package Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




public class FutureApp {

    public static void main(String args[]){
        
        System.out.print(Runtime.getRuntime().availableProcessors());
        int nThread = Runtime.getRuntime().availableProcessors()*10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        
        Future<Integer>future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // TODO Auto-generated method stub
                return null;
            }
        });
    }
    

    
    
}
