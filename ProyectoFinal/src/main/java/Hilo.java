public class Hilo extends Thread {

    private long initialTime;
    private int tiempo;
    private String nombre;
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_RESET = "\u001B[0m";
    public Hilo(String nombre,int tiempo, long initialTime) {
        this.nombre=nombre;
        this.tiempo = tiempo;
        this.initialTime = initialTime;

    }

    @Override
    public void run() {


        for (int i = 0; i < this.tiempo; i++) {
            this.esperarXsegundos(i);
        }

        System.out.println(
                ANSI_BLUE +"\n"+nombre+ " tu pedido llego en: " + ANSI_RESET +
                        +(System.currentTimeMillis() - this.initialTime) / 1000
                        + "min");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}


