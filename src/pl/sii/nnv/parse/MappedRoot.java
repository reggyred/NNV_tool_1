package pl.sii.nnv.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * MappedRoot is a base class representing each modular node that is parsed from .proto files. 
 * <p>
 * Nodes are ordered by their depth. List<MappedRoot> contains objects that belong to this layer.
 * Further nodes are nested recursively depending on membership to parent object. 
 * <p>
 * Connections between each object members are kept in List<NodeObject>.
 */
public class MappedRoot{
	
	public String name;
	public int id; // ID == node number in .proto
	public int order;  // old layer
	public String op; // op from .proto to every node
	//
	//public ArrayList<Integer> nodes = new ArrayList<Integer>();
	//
	// NEW CLASS
	public List<NodeObject> node = new ArrayList<NodeObject>(); 
	public List<MappedRoot> object = new ArrayList<MappedRoot>();
	
    /** 
     * Default constructor 
     *
     */
	public MappedRoot() {
	}
	
    /** 
     * Generic getter for object name
     *
     * @return          Name of the object
     * 
     */	
	public String getName()
	{
		return this.name;
	}
	
    /** 
     * Generic getter for object id
     *
     * @return          Id of the object
     * 
     */	
	public int getId()
	{
		return this.id;
	}
	
    /** 
     * Generic getter for object order
     *
     * @return          Order of the object
     * 
     */	
	public int getOrder()
	{
		return this.order;
	}
}
