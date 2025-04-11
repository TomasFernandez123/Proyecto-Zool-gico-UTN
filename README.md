    # 🐾 Segundo Parcial - Programación II (Java)
**Sistema de Gestión de Zoológico**  
📌 Autor: Tomás

Este proyecto corresponde al segundo parcial de la materia *Programación II* en Java. Se trata de un sistema de gestión de zoológico, desarrollado utilizando Programación Orientada a Objetos, interfaces funcionales, genéricos y mecanismos de persistencia tanto binaria como en formato CSV.

---

## ⚙️ Funcionalidades principales

- Gestión de animales con atributos como `nombre`, `especie` y tipo de alimentación.
- Posibilidad de agregar, eliminar, filtrar y ordenar animales.
- Persistencia de datos en:
    - Archivos binarios (`.dat`) usando serialización
    - Archivos de texto (`.csv`) usando conversión personalizada
- Uso de programación genérica (`Zoologico<T>`)
- Interfaz `CSVSerializable` para convertir objetos a CSV y viceversa.
- Uso de expresiones lambda con `Predicate`, `Consumer` y `Function`.

---

## 📦 Clases destacadas

### `Animal`
Clase que representa un animal dentro del zoológico. Implementa `Comparable`, `Serializable` y `CSVSerializable`.

```java
public class Animal implements Comparable<Animal>, CSVSerializable, Serializable {
    private int id;
    private String nombre;
    private String especie;
    private TipoAlimentacion alimentacion;
    ...
}
Zoologico<T>
Clase genérica que administra una lista de elementos del tipo T. Permite agregar, eliminar, filtrar, ordenar y guardar/cargar datos en distintos formatos.

TipoAlimentacion
Enum que representa los tipos de alimentación de los animales:

java
Copiar
Editar
public enum TipoAlimentacion {
    CARNIVORO, HERBIVORO, OMNIVORO, INSECTIVORO
}
🧪 Clase de prueba: Test.java
La clase Test contiene un ejemplo completo de uso, incluyendo:

Creación de animales

Aplicación de filtros (por nombre o alimentación)

Ordenamientos naturales y personalizados

Persistencia en archivos binarios y CSV

💻 Cómo ejecutar el proyecto
✅ Opción 1: Con IntelliJ IDEA
Cloná este repositorio o descargalo como .zip.

Abrí IntelliJ y hacé File > Open → seleccioná la carpeta del proyecto.

Verificá que el proyecto tenga asignado un SDK (Java 8 o superior).

Ejecutá la clase Test.java (src/animales/Test.java).

✅ Opción 2: Desde la terminal
bash
Copiar
Editar
javac -d out src/modelo/*.java src/animales/Test.java
java -cp out animales.Test
Asegurate de tener creada la carpeta data/ en la raíz para los archivos .csv y .dat.

📁 Estructura del repositorio
bash
Copiar
Editar
Segundo_Parcial_ProgramacioII/
├── src/
│   ├── animales/           # Clase de prueba
│   └── modelo/             # Clases del modelo
├── data/                   # Archivos CSV y binarios generados
├── .gitignore
└── README.md
📄 Licencia
Este proyecto fue realizado con fines académicos como parte del segundo parcial de la materia Programación II en Java (2025).
