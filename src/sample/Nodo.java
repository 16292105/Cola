package sample;

public class Nodo {

    private int valor;//Valor que da el usuario al elemneto
    private Nodo proximo;//Apunta al siguiente
    //Constructor inicializa sin valor
    public Nodo(){
        this.valor=0;
        this.proximo=null;
    }
    //Constructor
    public Nodo(int valor){
        this.valor=valor;
        this.proximo=null;
    }
//Getters y Setters del valor que da el usuario a nuestro puntero.
    public void setValor(int valor){this.valor=valor;}
    public void setProx(Nodo siguiente){this.proximo=siguiente;}
    public int getValor(){
        return this.valor;
    }
    public Nodo getProx(){
        return this.proximo;
    }
}
