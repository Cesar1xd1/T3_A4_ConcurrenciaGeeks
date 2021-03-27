class thread implements Runnable
{
    public void run()
    {
        // moving thread2 to timed waiting state
        try
        {
            Thread.sleep(1500);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
          
        System.out.println("Estado del Hilo1 con metodo Join() en el Hilo2 - "+
            CiclosDeVida.thread1.getState());
        try
        {
            Thread.sleep(200);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }     
    }
}
  
public class CiclosDeVida implements Runnable
{
    public static Thread thread1;
    public static CiclosDeVida obj;
      
    public static void main(String[] args)
    {
        obj = new CiclosDeVida();
        thread1 = new Thread(obj);
          
        // thread1 created and is currently in the NEW state.
        System.out.println("Estado del Hilo1 despues de ser creado - " + thread1.getState());
        thread1.start();
          
        // thread1 moved to Runnable state
        System.out.println("Estado del Hilo1 despues de llamar al metodo start() - " + 
            thread1.getState());
    }
      
    public void run()
    {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);
          
        // thread1 created and is currently in the NEW state.
        System.out.println("Estado del Hilo2 despues de ser creado - "+ thread2.getState());
        thread2.start();
          
        // thread2 moved to Runnable state
        System.out.println("Estado del Hilo2 despues de llamar al metodo start() - " + 
            thread2.getState());
          
        // moving thread1 to timed waiting state
        try
        {
            //moving thread1 to timed waiting state
            Thread.sleep(200);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Estado del Hilo2 despues de llamar al metodo sleep() - "+ 
            thread2.getState() );
          
          
        try 
        {
            // waiting for thread2 to die
            thread2.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Estado del Hilo2 al terminar la ejecucion - " + 
            thread2.getState());
    }
      
}

