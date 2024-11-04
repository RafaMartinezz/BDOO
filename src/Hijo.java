/**
 * Represents a child (Hijo) associated with a boss (Jefe), containing
 * the child's name and age.
 */
public class Hijo {
    private String nombre; // Child's name
    private int edad; // Child's age

    /**
     * Constructs a Hijo object with the specified name and age.
     *
     * @param nombre The name of the child.
     * @param edad   The age of the child.
     */
    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Gets the name of the child.
     *
     * @return The child's name.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets a new name for the child.
     *
     * @param nombre The new name of the child.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the age of the child.
     *
     * @return The child's age.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets a new age for the child.
     *
     * @param edad The new age of the child.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Returns a string representation of the child, including name and age.
     *
     * @return A string describing the child's name and age.
     */
    @Override
    public String toString() {
        return nombre + ", edad: " + edad;
    }

    /**
     * Generates a hash code for the child based on name and age.
     *
     * @return A hash code value for the child.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + edad;
        return result;
    }

    /**
     * Checks if two Hijo objects are equal based on name and age.
     *
     * @param obj The object to compare with.
     * @return true if both children have the same name and age; otherwise, false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hijo other = (Hijo) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (edad != other.edad)
            return false;
        return true;
    }
}
