package modelo;

import java.io.Serializable;

public class Animal implements Comparable<Animal>, CSVSerializable, Serializable{
    private int id;
    private String nombre;
    private String especie;
    private TipoAlimentacion alimentacion;

    public Animal(int id, String nombre, String especie, TipoAlimentacion alimentacion) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.alimentacion = alimentacion;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", alimentacion=" + alimentacion + '}';
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(id, o.id);
    }
    
    @Override
    public String toCSV() {
        return id + "," + nombre + "," + especie + "," + alimentacion;
    }
    
    public static Animal fromCSV(String csv) {
        String[] data = csv.split(",");
        int id = Integer.parseInt(data[0]);
        String nombre = data[1];
        String especie = data[2];
        TipoAlimentacion alimentacion = TipoAlimentacion.valueOf(data[3]);
        return new Animal(id, nombre, especie, alimentacion);
    }

    public String getNombre() {
        return nombre;
    }

    public TipoAlimentacion getAlimentacion() {
        return alimentacion;
    }
    
    
    
}
