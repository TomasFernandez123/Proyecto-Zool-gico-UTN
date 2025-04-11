package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Zoologico<T extends CSVSerializable> {
    private List<T> lista = new ArrayList<>();

    public void agregar(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        lista.add(item);
    }
    
    private void verificarIndex(int index){
        if (!(index >= 0 && index < lista.size())) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
    }
    
    public void eliminar(int index) {
        verificarIndex(index);
        lista.remove(index);
    }
    
    public T obtener(int index) {
        verificarIndex(index);
        return lista.get(index);
    }
    
    public List<T> filtrar(Predicate<T> criterio) {
        List<T> filtrados = new ArrayList<>();
        for (T i : lista) {
            if (criterio.test(i)) {
                filtrados.add(i);
            }
        }
        return filtrados;
    }
    
    public void ordenar(Comparator<T> comparator) {
        lista.sort(comparator);
    }
    
    public void ordenar() {
        if(!lista.isEmpty() && lista.get(0) instanceof Comparable){
            lista.sort(null);
        }
    }
    
    public void paraCadaElemento(Consumer<T> accion) {
        for (T elemento : lista) {
            accion.accept(elemento);
        }
    }
    
    public void guardarEnCSV(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("ID,NOMBRE,ESPECIE,TIPO_ALIMENTACION\n");
            for (T i : lista) {
                bw.write(i.toCSV() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cargarDesdeCSV(String path, Function<String, T> fromCSV) {
        List<T> toReturn = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String linea;

            bf.readLine();
            while ((linea = bf.readLine()) != null) {
                T item = fromCSV.apply(linea);

                if (item != null) {
                    toReturn.add(item);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.lista = toReturn;
    }

    
    public void guardarEnArchivo(String path) {
        if(path == null || path.isEmpty()){
            throw new IllegalArgumentException("La ruta enviada esta vacia");
        }
        try (FileOutputStream archivo = new FileOutputStream(path); ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(lista);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cargarDesdeArchivo(String path){
        if(path == null || path.isEmpty()){
            throw new IllegalArgumentException("La ruta enviada esta vacia");
        }
        List<T> toReturn = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(path))) {
            toReturn = (List<T>) entrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        this.lista = toReturn;
    }
    
    

}
