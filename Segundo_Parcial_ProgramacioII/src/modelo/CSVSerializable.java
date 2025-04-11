package modelo;

public interface CSVSerializable {
    String toCSV();
    static Animal fromCSV(String csv){
        return null;
    }
}
