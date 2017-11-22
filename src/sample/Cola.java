package sample;

public class Cola {
    private Nodo frente; //el inicial de la cola
    private int tamaño;//Llevara el control del tamaño de nuestra cola
    public boolean vacia(){return frente==null;}//Verifica si nuestra cola tiene valores
    public int getTamaño(){ return tamaño;}//Devuelve el tamaño de la cola
    //constructor simple
    public Cola() {
        frente= null;
        tamaño = 0;
    }
    //Método para insertar siguiente elemento(nodo), el elemento debe colocarse detras del último nodo
    public void insertar(int valor){
        Nodo nuevo=new Nodo(valor);
        if(frente==null){//Coloca nuestra inserción como frente
            frente=nuevo;
        }else{
            Nodo temp=frente;
            while(temp.getProx()!=null){
                temp=temp.getProx();//Recorre la cola
            }
            temp.setProx(nuevo);//Coloca nuestra inserción después del último elemento
        }
        tamaño++;//Aumenta la cola
    }
    //Método para mostrar los elementos de la cola
    public void mostrar(){
        if( frente != null){
            Nodo temp= frente;
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
        if(frente == null){//Si no tiene valores
            return 0;
        }else{
            tamaño--;//Decementa nuestra cola
            int valorExtraer= frente.getValor(); //variable temporal
            frente = frente.getProx(); //cambiar el frente por el siguiente
            return valorExtraer; //devolver el valor extraidode la cola
        }
    }
    public String vaciarLista(){//Vacia nuestra cola
        if(!vacia()){//Si la cola tiene valores
            frente=null;//Borra los elementos de cola
            tamaño=0;//Tamaño toma el valor de 0.
            return "La cola ah sido vaciada";
        }else{//La cola no tiene valores
            return "La cola no tiene valores";
        }
    }

    public String buscarXValor(int valor){//Buscamos por valor en la cola
        if(!vacia()){//Si la cola tiene valores entra al ciclo
            int i =1;//Empieza nuestra conteo en 1
            Nodo temp=frente;//Temporal que almacena nuestra cola
            if(valor==frente.getValor()){//Si el elemento es el primero
                return "El valor "+valor+" se ubica en el lugar "+i;
            }else{//Si el elemento esta después del primero
                while(temp!= null){//Hasta que ya no tenga valores la cola
                    if(valor==temp.getValor()){
                        return "El valor de"+valor+ "es igual a :"+i;
                    }
                    i++;//Incrementa el contador
                    temp= temp.getProx();//Recorre la cola con ayuda del temporal
                }
            }
        }return"Valor no encontrado";
    }

}
