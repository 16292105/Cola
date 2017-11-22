package sample;

public class Cola {
    private Nodo frente; //el inicial de la cola
    private int tamaño;
    public boolean vacia(){return frente==null;}
    public int getTamaño(){ return tamaño;}
    //constructor simple
    public Cola() {
        frente= null;
        tamaño = 0;
    }
    //Método para insertar siguiente elemento(nodo), el elemento debe colocarse detras del último nodo
    public void insertar(int valor){
        Nodo nuevo=new Nodo(valor);
        if(frente==null){
            frente=nuevo;
        }else{
            Nodo temp=frente;
            while(temp.getProx()!=null){
                temp=temp.getProx();
            }
            temp.setProx(nuevo);
        }
        tamaño++;
    }
    //Método para mostrar los elementos de la cola
    public void mostrar(){
        if( frente != null){
            Nodo temp= frente;
            System.out.println("Los valores de la cola son: ");
            while(temp!= null){
                System.out.println(temp.getValor());
                temp= temp.getProx();
            }
        }else{
            System.out.println("La cola está vacía.");
        }
    }
    //Método para extraer el elemento del frente
    public int extraer(){
        if(frente == null){
            System.out.println("La cola no tiene valores");
            return 0;
        }else{
            tamaño--;
            System.out.println("Valor extraido: "+ frente.getValor());
            int valorExtraer= frente.getValor(); //variable temporal
            frente = frente.getProx(); //cambiar el frente por el siguiente
            return valorExtraer; //devolver el valor extraidode la cola

        }
    }
    public String vaciarLista(){
        if(!vacia()){
            frente=null;
            tamaño=0;
            return "La cola ah sido vaciada";
        }else{

            return "La cola no tiene valores";
        }
    }

    public String buscarXValor(int valor){
        if(!vacia()){
            int i =1;
            Nodo temp=frente;
            if(valor==frente.getValor()){
                return "El valor "+valor+" se ubica en el lugar "+i;
            }else{
                while(temp!= null){
                    if(valor==temp.getValor()){
                        return "El valor de"+valor+ "es igual a :"+i;
                    }
                    i++;
                    temp= temp.getProx();
                }
            }
        }return"Valor no encontrado";
    }

}
