package Ejer09;

import java.util.concurrent.atomic.AtomicInteger;

class UsuarioCajero implements Runnable {
    private CajeroAutomatico cajero;
    private int cantidad;

    public UsuarioCajero(CajeroAutomatico cajero, int cantidad) {
        this.cajero = cajero;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cajero.retirar(cantidad);
    }
}

public class CajeroAutomatico  {
    private AtomicInteger saldo = new AtomicInteger(1000);

    public void retirar(int cantidad) {
    	int actual;
    	Boolean actualizado;
    
    	do {
    		actual=saldo.get();
    	if(actual-cantidad<=0){
            System.out.println("Saldos insuficientes");
    		}
    	actualizado=saldo.compareAndSet(actual, saldo.get()-cantidad);
    	}while(!actualizado);
    	
            System.out.println("Fondos insuficientes para retirar " + cantidad);
        
    }

    public int consultarSaldo() {
        return saldo.get();
    }
    

}

