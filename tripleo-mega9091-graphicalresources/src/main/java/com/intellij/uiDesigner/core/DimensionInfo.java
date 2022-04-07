// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DimensionInfo.java

package com.intellij.uiDesigner.core;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

// Referenced classes of package com.intellij.uiDesigner.core:
//			LayoutState, Util, GridConstraints

public abstract class DimensionInfo
{

	public DimensionInfo(LayoutState layoutState, int gap)
	{
		if(layoutState == null)
			throw new IllegalArgumentException("layoutState cannot be null");
		if(gap < 0)
			throw new IllegalArgumentException("invalid gap: " + gap);
		myLayoutState = layoutState;
		myGap = gap;
		myCell = new int[layoutState.getComponentCount()];
		mySpan = new int[layoutState.getComponentCount()];
		for(int i = 0; i < layoutState.getComponentCount(); i++)
		{
			GridConstraints c = layoutState.getConstraints(i);
			((int[])myCell)[i] = getOriginalCell(c);
			((int[])mySpan)[i] = getOriginalSpan(c);
		}

		for(int i = 0; i < ((int[])myStretches).length; i++)
			((int[])myStretches)[i] = 1;

		ArrayList<Integer> elimitated = new ArrayList<Integer>();
		mySpansAfterElimination = (int[])(int[])((int[])mySpan).clone();
		Util.eliminate((int[])(int[])((int[])myCell).clone(), (int[])mySpansAfterElimination, elimitated);
		for(int i = 0; i < ((int[])myCellSizePolicies).length; i++)
			((int[])myCellSizePolicies)[i] = getCellSizePolicyImpl(i, elimitated);

	}

	public final int getComponentCount()
	{
		return myLayoutState.getComponentCount();
	}

	public final Component getComponent(int componentIndex)
	{
		return myLayoutState.getComponent(componentIndex);
	}

	public abstract int getCellCount();

	public abstract int getPreferredWidth(int i);

	public abstract int getMinimumWidth(int i);

	public final int getCell(int componentIndex)
	{
		return ((int[])myCell)[componentIndex];
	}

	public final int getSpan(int componentIndex)
	{
		return ((int[])mySpan)[componentIndex];
	}

	public final int getStretch(int cellIndex)
	{
		return ((int[])myStretches)[cellIndex];
	}

	protected abstract int getOriginalCell(GridConstraints gridconstraints);

	protected abstract int getOriginalSpan(GridConstraints gridconstraints);

	abstract int getSizePolicy(int i);

	public final int getGap()
	{
		return myGap;
	}

	private boolean componentBelongsCell(int componentIndex, int cellIndex)
	{
		int componentStartCell = getCell(componentIndex);
		int span = getSpan(componentIndex);
		return componentStartCell <= cellIndex && cellIndex < componentStartCell + span;
	}

	public final int getCellSizePolicy(int cellIndex)
	{
		return ((int[])myCellSizePolicies)[cellIndex];
	}

	private int getCellSizePolicyImpl(int cellIndex, ArrayList<Integer> eliminatedCells)
	{
		for(int i = eliminatedCells.size() - 1; i >= 0; i--)
			if(cellIndex == (eliminatedCells.get(i)).intValue())
				return 1;

		boolean canShrink = true;
		boolean canGrow = false;
		boolean wantGrow = false;
		boolean weakCanGrow = true;
		boolean weakWantGrow = true;
		int countOfBelongingComponents = 0;
		for(int i = 0; i < getComponentCount(); i++)
			if(componentBelongsCell(i, cellIndex))
			{
				countOfBelongingComponents++;
				int p = getSizePolicy(i);
				boolean thisCanShrink = (p & 1) != 0;
				boolean thisCanGrow = (p & 2) != 0;
				boolean thisWantGrow = (p & 4) != 0;
				if(getCell(i) == cellIndex && ((int[])mySpansAfterElimination)[i] == 1)
				{
					canShrink &= thisCanShrink;
					canGrow |= thisCanGrow;
					wantGrow |= thisWantGrow;
				}
				if(!thisCanGrow)
					weakCanGrow = false;
				if(!thisWantGrow)
					weakWantGrow = false;
			}

		return (canShrink ? 1 : 0) | (!canGrow && (countOfBelongingComponents <= 0 || !weakCanGrow) ? 0 : 2) | (!wantGrow && (countOfBelongingComponents <= 0 || !weakWantGrow) ? 0 : 4);
	}

	protected final Dimension getPreferredSize(int componentIndex)
	{
		Dimension size = myLayoutState.myPreferredSizes[componentIndex];
		if(size == null)
		{
			size = Util.getPreferredSize(myLayoutState.getComponent(componentIndex), myLayoutState.getConstraints(componentIndex));
			myLayoutState.myPreferredSizes[componentIndex] = size;
		}
		return size;
	}

	protected final Dimension getMinimumSize(int componentIndex)
	{
		Dimension size = myLayoutState.myMinimumSizes[componentIndex];
		if(size == null)
		{
			size = Util.getMinimumSize(myLayoutState.getComponent(componentIndex), myLayoutState.getConstraints(componentIndex));
			myLayoutState.myMinimumSizes[componentIndex] = size;
		}
		return size;
	}

	private final int myCell[];
	private final int mySpan[];
	protected final LayoutState myLayoutState;
	private final int myStretches[] = new int[getCellCount()];
	private final int mySpansAfterElimination[];
	private final int myCellSizePolicies[] = new int[getCellCount()];
	private final int myGap;
}
