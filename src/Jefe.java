/**
 * Represents a boss (Jefe) with a name, tenure (antiguedad), age, and
 * optionally, a child (Hijo).
 * This class includes basic details for a boss and methods to access and modify
 * these details.
 */
public class Jefe {
    private String nombre; // Name of the boss
    private int antiguedad; // Years of tenure in the company
    private int edad; // Age of the boss
    private Hijo hijo; // Optional child associated with the boss

    /**
     * Constructs a Jefe object with the specified name, tenure, age, and child.
     *
     * @param nombre     The name of the boss.
     * @param antiguedad The number of years the boss has been in the company.
     * @param edad       The age of the boss.
     * @param hijo       The child associated with the boss, if any.
     */
    public Jefe(String nombre, int antiguedad, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.edad = edad;
        this.hijo = hijo;
    }

    /**
     * Gets the name of the boss.
     *
     * @return The name of the boss.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets a new name for the boss.
     *
     * @param nombre The new name of the boss.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the number of years the boss has been with the company.
     *
     * @return The boss's tenure in years.
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * Sets a new tenure value for the boss.
     *
     * @param antiguedad The number of years of tenure.
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Gets the age of the boss.
     *
     * @return The boss's age.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets a new age for the boss.
     *
     * @param edad The new age of the boss.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Gets the child associated with the boss.
     *
     * @return The child of the boss, or null if the boss has no child.
     */
    public Hijo getHijo() {
        return hijo;
    }

    /**
     * Sets a new child for the boss.
     *
     * @param hijo The new child to associate with the boss.
     */
    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    /**
     * Returns a string representation of the boss, including name, tenure, age, and
     * child.
     *
     * @return A string containing the boss's details.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", antiguedad: " + antiguedad + ", edad: " + edad + ", hijo: " + hijo;
    }

    /**
     * Generates a hash code for the boss based on name, tenure, age, and child.
     *
     * @return A hash code value for the boss.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + antiguedad;
        result = prime * result + edad;
        result = prime * result + ((hijo == null) ? 0 : hijo.hashCode());
        return result;
    }

    /**
     * Checks if two bosses are equal based on their name, tenure, age, and child.
     *
     * @param obj The object to compare with.
     * @return true if the bosses are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jefe other = (Jefe) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (antiguedad != other.antiguedad)
            return false;
        if (edad != other.edad)
            return false;
        if (hijo == null) {
            if (other.hijo != null)
                return false;
        } else if (!hijo.equals(other.hijo))
            return false;
        return true;
    }
}
