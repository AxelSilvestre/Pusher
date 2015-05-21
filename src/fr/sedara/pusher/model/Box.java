package fr.sedara.pusher.model;

import java.io.Serializable;

/** A simple box with a type and a location.
 * @author Sedara
 *
 */
public class Box implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7685868685838189677L;
    

    /**
     * The location of the Box.
     */
    private final Location location;
    
    /**
     * The type of the Box.
     */
    private       Type     type;

    /** Creates a new Box.
     * @param location : The location of the box.
     */
    public Box(Location location) {
        this.location = location;
        type = Type.NULL;

    }

    /** 
     * @return The location of the box.
     */
    public Location getLocation() {
        return location;
    }

    /** 
     * @return The current type.
     */
    public Type getType() {
        return type;
    }

    /** Sets the Type of the box.
     * @param type : The type.
     */
    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return "[" + type.toString() + "]";
    }


}
