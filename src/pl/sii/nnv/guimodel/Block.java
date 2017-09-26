package pl.sii.nnv.guimodel;

import java.util.ArrayList;

import javafx.geometry.Point2D;

public class Block {

	static int nextID = 0;
	int blockID;
	String blockName;
	String blockGroup;
	BlockType blockType;
	int blockOrder;
	int blockColumn;
	String value;
	Point2D position;

	ArrayList<Connection> blockParents = new ArrayList<Connection>();
	ArrayList<Block> nestedBlocks = new ArrayList<Block>();
	
	public Block(String blockName, String blockGroup, BlockType blockType, int blockOrder, int blockColumn,
			String value) {
		blockID = nextID;
		nextID++;
		this.blockName = blockName;
		this.blockGroup = blockGroup;
		this.blockType = blockType;
		this.blockOrder = blockOrder;
		this.blockColumn = blockColumn;
		this.value = value;
		position = new Point2D(0, 0);
	}

	public void setBlockColumn(int column) {
		blockColumn = column;
	}

	public int getBlockColumn() {
		return blockColumn;
	}

	public void setBlockOrder(int order) {
		blockOrder = order;
	}

	public int getBlockOrder() {
		return blockOrder;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public void setPosition(float x, float y) {
		position = new Point2D(x, y);
	}

	public Point2D getPosition() {
		return position;
	}
	
	public double getPositionX() {
		return position.getX();
	}
	
	public double getPositionY() {
		return position.getY();
	}

}
