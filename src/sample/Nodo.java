package sample;

/**
 * Created by Acer on 21/11/2017.
 */
public class Nodo {

    private int valor;
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

    public void setValor(int valor){
        this.valor=valor;
    }

    public void setProx(Nodo siguiente){
        this.proximo=siguiente;
    }

    public int getValor(){
        return this.valor;
    }

    public Nodo getProx(){
        return this.proximo;
    }
}