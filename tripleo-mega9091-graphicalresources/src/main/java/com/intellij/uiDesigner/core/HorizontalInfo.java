// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HorizontalInfo.java

package com.intellij.uiDesigner.core;

import java.awt.Dimension;

// Referenced classes of package com.intellij.uiDesigner.core:
//			DimensionInfo, GridConstraints, LayoutState

final class HorizontalInfo extends DimensionInfo
{

	public HorizontalInfo(LayoutState layoutState, int gap)
	{
		super(layoutState, gap);
	}

	protected int getOriginalCell(GridConstraints constraints)
	{
		return constraints.getColumn();
	}

	protected int getOriginalSpan(GridConstraints constraints)
	{
		return constraints.getColSpan();
	}

	int getSizePolicy(int componentIndex)
	{
		return myLayoutState.getConstraints(componentIndex).getHSizePolicy();
	}

	public int getMinimumWidth(int componentIndex)
	{
		return getMinimumSize(componentIndex).width;
	}

	public int getCellCount()
	{
		return myLayoutState.getColumnCount();
	}

	public int getPreferredWidth(int componentIndex)
	{
		return getPreferredSize(componentIndex).width;
	}
}
