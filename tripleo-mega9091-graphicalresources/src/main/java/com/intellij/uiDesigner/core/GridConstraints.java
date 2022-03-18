// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GridConstraints.java

package com.intellij.uiDesigner.core;

import java.awt.Dimension;

public final class GridConstraints
	implements Cloneable
{

	public GridConstraints()
	{
		myRowSpan = 1;
		myColSpan = 1;
		myVSizePolicy = 3;
		myHSizePolicy = 3;
		myFill = 0;
		myAnchor = 0;
		myMinimumSize = new Dimension(-1, -1);
		myPreferredSize = new Dimension(-1, -1);
		myMaximumSize = new Dimension(-1, -1);
	}

	public GridConstraints(int row, int column, int rowSpan, int colSpan, int anchor, int fill, int HSizePolicy, 
			int VSizePolicy, Dimension minimumSize, Dimension preferredSize, Dimension maximumSize)
	{
		myRow = row;
		myColumn = column;
		myRowSpan = rowSpan;
		myColSpan = colSpan;
		myAnchor = anchor;
		myFill = fill;
		myHSizePolicy = HSizePolicy;
		myVSizePolicy = VSizePolicy;
		myMinimumSize = minimumSize == null ? new Dimension(-1, -1) : new Dimension(minimumSize);
		myPreferredSize = preferredSize == null ? new Dimension(-1, -1) : new Dimension(preferredSize);
		myMaximumSize = maximumSize == null ? new Dimension(-1, -1) : new Dimension(maximumSize);
	}

	public Object clone()
	{
		return new GridConstraints(getRow(), getColumn(), getRowSpan(), getColSpan(), getAnchor(), getFill(), getHSizePolicy(), getVSizePolicy(), new Dimension(myMinimumSize), new Dimension(myPreferredSize), new Dimension(myMinimumSize));
	}

	public int getColumn()
	{
		return myColumn;
	}

	public void setColumn(int column)
	{
		if(column < 0)
		{
			throw new IllegalArgumentException("wrong column: " + column);
		} else
		{
			myColumn = column;
			return;
		}
	}

	public int getRow()
	{
		return myRow;
	}

	public void setRow(int row)
	{
		if(row < 0)
		{
			throw new IllegalArgumentException("wrong row: " + row);
		} else
		{
			myRow = row;
			return;
		}
	}

	public int getRowSpan()
	{
		return myRowSpan;
	}

	public void setRowSpan(int rowSpan)
	{
		if(rowSpan <= 0)
		{
			throw new IllegalArgumentException("wrong rowSpan: " + rowSpan);
		} else
		{
			myRowSpan = rowSpan;
			return;
		}
	}

	public int getColSpan()
	{
		return myColSpan;
	}

	public void setColSpan(int colSpan)
	{
		if(colSpan <= 0)
		{
			throw new IllegalArgumentException("wrong colSpan: " + colSpan);
		} else
		{
			myColSpan = colSpan;
			return;
		}
	}

	public int getHSizePolicy()
	{
		return myHSizePolicy;
	}

	public void setHSizePolicy(int sizePolicy)
	{
		if(sizePolicy < 0 || sizePolicy > 7)
		{
			throw new IllegalArgumentException("invalid sizePolicy: " + sizePolicy);
		} else
		{
			myHSizePolicy = sizePolicy;
			return;
		}
	}

	public int getVSizePolicy()
	{
		return myVSizePolicy;
	}

	public void setVSizePolicy(int sizePolicy)
	{
		if(sizePolicy < 0 || sizePolicy > 7)
		{
			throw new IllegalArgumentException("invalid sizePolicy: " + sizePolicy);
		} else
		{
			myVSizePolicy = sizePolicy;
			return;
		}
	}

	public int getAnchor()
	{
		return myAnchor;
	}

	public void setAnchor(int anchor)
	{
		if(anchor < 0 || anchor > 15)
		{
			throw new IllegalArgumentException("invalid anchor: " + anchor);
		} else
		{
			myAnchor = anchor;
			return;
		}
	}

	public int getFill()
	{
		return myFill;
	}

	public void setFill(int fill)
	{
		if(fill != 0 && fill != 1 && fill != 2 && fill != 3)
		{
			throw new IllegalArgumentException("invalid fill: " + fill);
		} else
		{
			myFill = fill;
			return;
		}
	}

	public GridConstraints store()
	{
		GridConstraints copy = new GridConstraints();
		copy.setRow(myRow);
		copy.setColumn(myColumn);
		copy.setColSpan(myColSpan);
		copy.setRowSpan(myRowSpan);
		copy.setVSizePolicy(myVSizePolicy);
		copy.setHSizePolicy(myHSizePolicy);
		copy.setFill(myFill);
		copy.setAnchor(myAnchor);
		copy.myMinimumSize.setSize(myMinimumSize);
		copy.myPreferredSize.setSize(myPreferredSize);
		copy.myMaximumSize.setSize(myMaximumSize);
		return copy;
	}

	public void restore(GridConstraints constraints)
	{
		myRow = constraints.myRow;
		myColumn = constraints.myColumn;
		myRowSpan = constraints.myRowSpan;
		myColSpan = constraints.myColSpan;
		myHSizePolicy = constraints.myHSizePolicy;
		myVSizePolicy = constraints.myVSizePolicy;
		myFill = constraints.myFill;
		myAnchor = constraints.myAnchor;
		myMinimumSize.setSize(constraints.myMinimumSize);
		myPreferredSize.setSize(constraints.myPreferredSize);
		myMaximumSize.setSize(constraints.myMaximumSize);
	}

	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(!(o instanceof GridConstraints))
			return false;
		GridConstraints gridConstraints = (GridConstraints)o;
		if(myAnchor != gridConstraints.myAnchor)
			return false;
		if(myColSpan != gridConstraints.myColSpan)
			return false;
		if(myColumn != gridConstraints.myColumn)
			return false;
		if(myFill != gridConstraints.myFill)
			return false;
		if(myHSizePolicy != gridConstraints.myHSizePolicy)
			return false;
		if(myRow != gridConstraints.myRow)
			return false;
		if(myRowSpan != gridConstraints.myRowSpan)
			return false;
		if(myVSizePolicy != gridConstraints.myVSizePolicy)
			return false;
		if(myMaximumSize == null ? gridConstraints.myMaximumSize != null : !myMaximumSize.equals(gridConstraints.myMaximumSize))
			return false;
		if(myMinimumSize == null ? gridConstraints.myMinimumSize != null : !myMinimumSize.equals(gridConstraints.myMinimumSize))
			return false;
		return myPreferredSize == null ? gridConstraints.myPreferredSize == null : myPreferredSize.equals(gridConstraints.myPreferredSize);
	}

	public int hashCode()
	{
		int result = myRow;
		result = 29 * result + myColumn;
		result = 29 * result + myRowSpan;
		result = 29 * result + myColSpan;
		result = 29 * result + myVSizePolicy;
		result = 29 * result + myHSizePolicy;
		result = 29 * result + myFill;
		result = 29 * result + myAnchor;
		result = 29 * result + (myMinimumSize == null ? 0 : myMinimumSize.hashCode());
		result = 29 * result + (myPreferredSize == null ? 0 : myPreferredSize.hashCode());
		result = 29 * result + (myMaximumSize == null ? 0 : myMaximumSize.hashCode());
		return result;
	}

	public static final int FILL_NONE = 0;
	public static final int FILL_HORIZONTAL = 1;
	public static final int FILL_VERTICAL = 2;
	public static final int FILL_BOTH = 3;
	public static final int ANCHOR_CENTER = 0;
	public static final int ANCHOR_NORTH = 1;
	public static final int ANCHOR_SOUTH = 2;
	public static final int ANCHOR_EAST = 4;
	public static final int ANCHOR_WEST = 8;
	public static final int ANCHOR_NORTHEAST = 5;
	public static final int ANCHOR_SOUTHEAST = 6;
	public static final int ANCHOR_SOUTHWEST = 10;
	public static final int ANCHOR_NORTHWEST = 9;
	public static final int SIZEPOLICY_FIXED = 0;
	public static final int SIZEPOLICY_CAN_SHRINK = 1;
	public static final int SIZEPOLICY_CAN_GROW = 2;
	public static final int SIZEPOLICY_WANT_GROW = 4;
	private int myRow;
	private int myColumn;
	private int myRowSpan;
	private int myColSpan;
	private int myVSizePolicy;
	private int myHSizePolicy;
	private int myFill;
	private int myAnchor;
	public final Dimension myMinimumSize;
	public final Dimension myPreferredSize;
	public final Dimension myMaximumSize;
}
