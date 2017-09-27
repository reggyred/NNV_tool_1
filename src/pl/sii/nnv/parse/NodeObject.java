package pl.sii.nnv.parse;

import java.util.ArrayList;

/**
 * NodeObject contains information how objects are connected to each other.
 * <p>
 * This class describes the parent ID, dimension of the connectors
 * and type between connected objects.   
 */
public class NodeObject {
	
	public int parentId;
	public ArrayList<Integer> dim = new ArrayList<Integer>();
	public int type;  // check the connection types

    /** 
     * Default constructor 
     *
     */
	public NodeObject(){
	}
	
    /** 
     * Generic getter for object parentId
     *
     * @return          parentId of the object
     * 
     */	
	public int getId()
	{
		return this.parentId;
	}
	
    /** 
     * Generic getter for object dim <code>ArrayList</code>
     *
     * @return          <code>ArrayList</code> dim of the object
     * 
     */	
	public ArrayList<Integer> getArray()
	{
		return this.dim;
	}
	
    /** 
     * Generic getter for object name
     *
     * @return          Name of the object
     * 
     */	
	public Integer getType()
	{
		return this.type;
	}
}
