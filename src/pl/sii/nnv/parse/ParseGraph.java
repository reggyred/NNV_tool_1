package pl.sii.nnv.parse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.tensorflow.framework.GraphDef;
import org.tensorflow.framework.GraphDef.Builder;

import com.google.protobuf.TextFormat;

import caffe.Caffe.NetParameter;

import org.tensorflow.framework.NodeDef;

/**
 * ParseGraph contains methods to process graph objects from Caffe and Tensorflow.
 * <p>
 * The methods includes:
 * <ul>
 * <li>Reading graph from .proto input (text and binary)
 * <li>Writing graph to .proto output (text and binary)
 * <li>Mapping graph to inner MappedRoot structure
 * <li>Processing of the nodes
 * </ul>
 */
public class ParseGraph {

    /** 
     * Default constructor 
     *
     */
	public ParseGraph(){
	}
	
    /** 
     * Parses binary input protobuf file from Tensorflow into GraphDef Java object 
     *
     * @param dir       Directory to the Tensorflow protobuf file that is being read
	 *
     * @return          Object of <code>GraphDef</code> type
     * 
     * @exception       IOException possible during file reading
     */	
	public static GraphDef readGraphBin(String dir) throws IOException
	{
		FileInputStream input = null;
		try {
			//input = new FileInputStream("C://Tst//out_tst.pb");
			input = new FileInputStream(dir);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GraphDef graphRead = GraphDef.parseFrom(input);
		
		return graphRead;
	}

    /** 
     * Parses text input protobuf file from Tensorflow into <code>GraphDef.Builder</code> Java object 
     *
     * @param dir       Directory to the Tensorflow protobuf file that is being read
	 *
     * @return          Object of <code>GraphDef.Builder</code> type
     * 
     * @exception       IOException possible during file reading
     */	
	public static GraphDef.Builder readGraphText(String dir) throws IOException
	{
		GraphDef.Builder graph_fromTxt = GraphDef.newBuilder();
		
		//***** BufferedReader for reading the Text version of graph ******//
		 /*BufferedReader in
		   = new BufferedReader(new FileReader("C://tmp//load//test.pbtxt"));*/
		 
		 BufferedReader in
		   = new BufferedReader(new FileReader(dir));
		 	 
		//***** Merge Text graph into BufferedReader input ******// 
		TextFormat.merge(in, graph_fromTxt);
		
		return graph_fromTxt;
	}

    /** 
     * Parses text input protobuf file from Caffe into NerParameter.Builder Java object
     *
     * @param dir       Directory to the Caffe protobuf file that is being read
	 *
     * @return          Object of <code>NetParameter.Builder</code> type
     * 
     * @exception       IOException possible during file reading
     */	
	public static NetParameter.Builder readGraphTextCaffe(String dir)
	{
		NetParameter.Builder graph = NetParameter.newBuilder();
		return graph;
	}
	
    /** 
     * Parses binary input protobuf file from Caffe into NerParameter Java object
     *
     * @param dir  		Directory to the Caffe protobuf file that is being read     
	 *
     * @return  		Object of <code>NetParameter</code> type        
     * 
     * @exception  		IOException possible during file reading     
     */	
	public static NetParameter readGraphBinCaffe(String dir)
	{
		NetParameter net = NetParameter.getDefaultInstance();
		return net;
	}
	
    /** 
     * Gets root object for nested MappedRoot structure
     *
     * @return			<code>MappedRoot</code> object          
     * 
     */	
	private static MappedRoot getRoot()
	{
		MappedRoot map = new MappedRoot();
		return map;
	}
	
    /** 
     * Writes graph from GraphDef.Builder to binary protobuf Tensorflow file
     *
     * @param dir       Directory where the file is written to
     * 
     * @param graph		<code>GraphDef.Builder</code> Java object that is being written to a Tensorflow file
	 *
     * @return          void
     * 
     * @exception  		IOException possible during file writing    
     */	
	public static void writeGraphBin(String dir, GraphDef.Builder graph) throws IOException
	{
		FileOutputStream output = null;

		output = new FileOutputStream(dir);
		graph.build().writeTo(output);

		output.close();
	}
	
    /**  
     * Writes graph from GraphDef.Builder to text protobuf Tensorflow file
     *
     * @param dir       Directory where the file is written to
     * 
     * @param graph		<code>GraphDef.Builder</code> Java object that is being written to a Tensorflow file
	 *
     * @return          void
     * 
     * @exception  		IOException possible during file writing    
     */	
	public static void writeGraphText(String dir, GraphDef.Builder graph) throws IOException
	{
		BufferedWriter out
		   = new BufferedWriter(new FileWriter(dir));

		TextFormat.print(graph, out);
		out.close();
	}
	
    /**
     * Writes graph from <code>NetParameter</code> to binary protobuf Caffe file
     *
     * @param dir       Directory where the file is written to
     * 
     * @param graph		<code>NetParameter</code> Java object that is being written to a Caffe file
	 *
     * @return          void
     * 
     * @exception  		IOException possible during file writing    
     */	
	public static boolean writeGraphBinCaffe(String dir, NetParameter net)
	{
		return true;
	}
	
    /** 
     * Writes graph from <code>NetParameter</code> to text protobuf Caffe file
     *
     * @param dir       Directory where the file is written to
     * 
     * @param graph		<code>NetParameter</code> Java object that is being written to a Caffe file
	 *
     * @return          void
     * 
     * @exception  		IOException possible during file writing    
     */	
	
	public static boolean writeGraphTextCaffe(String dir, NetParameter net)
	{
		return true;
	}
	
    /** 
     * Iterates through <code>MappedRoot</code> object
     *
     * @param root		Object passed for breadth iteration
     * 
     * @param builder	Builder passed for processing
     * 
     * @param depth		Breadth iteration performed on given depth				
	 *
     * @return          void
     *      
     */	
	public static void iterate(MappedRoot root, Builder builder, int depth)
	{
	    int cnt=0;	
		for(NodeDef node: builder.getNodeList())
		{
			MappedRoot new_root = new MappedRoot();
			//System.out.println("iterate: "+node.getName());
			new_root.name = node.getName();
			new_root.id = cnt;
			if(!containsName(new_root.object, new_root.name))
			{
				root.object.add(cnt, new_root);
			}
			node.getName();
			cnt++;
		}
		
	}
	
    /** 
     * Performs checking if the given name is contained in the given list of <code>MappedRoot</code> objects
     *
     * @param list		List of <code>MappedRoot</code> objects for searching
     * 
     * @param name		<code>MappedRoot</code> object name, that is being checked for existence 
	 *
     * @return          <code>True</code> if name is present in the list;
     * 					<code>False</code> otherwise.     
     */	
	public static boolean containsName(final List<MappedRoot> list, final String name){
	    return list.stream().map(MappedRoot::getName).filter(name::equals).findFirst().isPresent();
	}
	
    /** 
     * Performs checking what is the unique ID of the node according to given name
     *
     * @param list  	List of <code>MappedRoot</code> objects for searching 
     * 
     * @param name		<code>MappedRoot</code> object name, that is being checked for its id		
	 *
     * @return          ID of objected
     * 
     */	
	public static int checkId(final List<MappedRoot> list, final String name){
		Iterator<MappedRoot> myIterator = list.iterator();
		while(myIterator.hasNext())
		{
			MappedRoot obj = myIterator.next();
			if (obj.getName().equals(name))
			{
				return obj.getId();
			}
		}
		return -1;
	}
	
    /** 
     * Performs checking what is the name of the node according to given unique ID
     *
     * @param list  	List of <code>MappedRoot</code> objects for searching 
     * 
     * @param id		ID of the object being checked		
	 *
     * @return          String with the name of the object
     * 
     */	
	public static String checkName(final List<MappedRoot> list, final Integer id){
		Iterator<MappedRoot> myIterator = list.iterator();
		while(myIterator.hasNext())
		{
			MappedRoot obj = myIterator.next();
			if (obj.getId() == id)
			{
				return obj.getName();
			}
		}
		return null;
	}
	
    /** 
     * Assigns order of nodes for the given layer based on the inputs starting from root node.
     * This order is used for purposes of visualization.
     *
     * @param root		Root object of <code>MappedRoot</code> type       
	 *
	 * @param depth		Depth of the nested structure to be ordered
	 *
     * @return          void
     * 
     */	
	public static void assignOrder(MappedRoot root, int depth)
	{
		System.out.println("Egzaminuj");
		int chk;
		int start_id = 0;
		int layer = 0;
		ArrayList<Integer> examined = new ArrayList<Integer>();
		ArrayList<Integer> to_examin = new ArrayList<Integer>();
		examined.add(start_id);
		Iterator<MappedRoot> it = root.object.iterator();
		while(it.hasNext())
		{
			
			MappedRoot obj = it.next();
				   
			if(obj.node.size() != 0)
			{
				if(!Collections.disjoint(examined, obj.nodes))
				{
					//examined.add(obj.ID);
					to_examin.add(obj.id);
					obj.layer = layer;
				}
				else
				{
					layer++; ///????
					obj.layer = layer;
					
					examined = new ArrayList<>(to_examin);
					to_examin.clear();
					to_examin.add(obj.id);
				}
			}
			else
			{
				obj.layer = layer;
				layer++;
			}
			
		}

	}

    /** 
     * Recursively checks if the given node name is added to the root <code>MappedRoot</code> list.
     * If not it adds the node to the list based on the parents nodes.
     *
     * @param obj		Object of type <code>MappedRoot</code> being assembled by parser       
	 *
	 * @param name		Name of the node under processing
	 * 
	 * @param depth		Recursive depth of processing.
	 *
     * @return          void
     * 
     */	
	public static void addRecursive(MappedRoot obj, String[] name, int depth)
	{

		if(!obj.object.isEmpty())
		{
			ListIterator<MappedRoot> it = obj.object.listIterator();
			MappedRoot tmp;
			while(it.hasNext())
			{
				tmp = it.next();
				if(!containsName(obj.object, name[depth]))
				{			
					MappedRoot add_new = new MappedRoot();
					add_new.name=name[depth];
					//obj.object.

					if(!it.hasNext())
					{
						it.add(add_new);
						it.previous();
					}
					else
					{
						while(it.hasNext())
						{
							tmp = it.next();
						}
						it.add(add_new);
						it.previous();
					}
			
					if(depth+1 < name.length)
					{
						if(!tmp.name.equals(name[depth]))
						{
							continue;
						}
						depth++;
						addRecursive(tmp, name, depth);
					}
					break;
				}
				if(!tmp.name.equals(name[depth]))
				{
					continue;
				}
				depth++;
				if(depth < name.length)
				{
					addRecursive(tmp, name, depth);
				}
				break;
			}
		}
		else
		{
			MappedRoot add_new = new MappedRoot();
			add_new.name=name[depth];
			obj.object.add(add_new);
			depth++;
			if(depth < name.length)
			{
				addRecursive(obj.object.get(0), name, depth);
			}
		}
	}
	
    /** 
     * Assembles <code>MappedRoot</code> root from the nodes being parsed from input protobuf file
     * into inner object structure.
     *
     * @param root   	Object of type <code>MappedRoot</code> being assembled by parser 
     * 
     * @param builder	Builder from protobuf framework used for iteration over parsed nodes
	 *
     * @return          void
     * 
     */	
	public static void nestedRecursive(MappedRoot root, Builder builder)
	{
	    int cnt_objects = 0;
	    int cnt_inputs = 0;
	    int layer_cnt = 0;
	    
	    // build 1st level
		for(NodeDef node: builder.getNodeList())
		{
			String name;
			//String input;
			MappedRoot new_root = new MappedRoot();	
			new_root.id = cnt_objects;
			name = node.getName();
			
			String[] tokens = name.split("/");
			
			addRecursive(root, tokens, 0);

		}
	}
	
    /** 
     * Test function for layer 0
     *
     * @param root		Object of type <code>MappedRoot</code> being assembled by parser
     * 
     * @param builder	Builder from protobuf framework used for iteration over parsed nodes
	 *
     * @return    		void      
     * 
     */	
	public static void nestedIterate(MappedRoot root, Builder builder)
	{
		
	    int cnt_objects = 0;
	    int cnt_inputs = 0;
	    int layer_cnt = 0;
	    
	    // build 1st level
		for(NodeDef node: builder.getNodeList())
		{
			String name;
			//String input;
			MappedRoot new_root = new MappedRoot();	
			new_root.id = cnt_objects;
			name = node.getName();
			
			String[] tokens = name.split("/");
			
			new_root.name = tokens[0];
			if(containsName(root.object, tokens[0]))
			{
				;
			}
			else
			{
				if(new_root.id == 0)
				{
					new_root.order = 0;
				}
				root.object.add(new_root);
				System.out.println("Name: "+new_root.name);
				cnt_objects++;
			}

			// get inputs 
			if(node.getInputCount()!=0)
			{
				List<String> input = node.getInputList();

				for(String in: input)
				{
					String[] in2 = in.split("/");
				    //System.out.println();
					if(!new_root.name.equals(in2[0]))
					{
						int ck = checkId(root.object, in2[0]);
						if(ck > -1)
						{
							new_root.nodes.add(cnt_inputs, ck);
							MappedRoot tmp = root.object.get(cnt_objects-1);
							tmp.nodes.add(cnt_inputs, ck);
							cnt_inputs++;
						}
					}
				}
			}
			cnt_inputs = 0;
		}
		//assign layer levels
		assignOrder(root, 0);
	}	
	
   
	/*public static void main(String[] args) throws IOException
	{
		Builder my_graph =  GraphDef.newBuilder();
		Builder my_graph_txt = GraphDef.newBuilder();
		String s_bin = "C://Tst//out_tst.pb";
		String s_text = "C://tmp//load//test.pbtxt";

		my_graph =	readGraphBin(s_bin).toBuilder();
		my_graph_txt = readGraphText(s_text);
		
		MappedRoot root = getRoot();
		MappedRoot root_txt = getRoot();
        root.name = "root";
        root.id = -1;

        nestedRecursive(root, my_graph);
		//nested_iterate(root, my_graph);
		System.out.println("TXT");
		nestedIterate(root_txt, my_graph_txt);
		System.out.println("wypierdol output");
	}	*/
	
}
