// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Util.java

package com.intellij.uiDesigner.core;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

// Referenced classes of package com.intellij.uiDesigner.core:
//			GridConstraints

public final class Util
{

	public Util()
	{
	}

	public static Dimension getMinimumSize(Component component, GridConstraints constraints)
	{
		return getSize(constraints.myMinimumSize, component.getMinimumSize());
	}

	public static Dimension getMaximumSize(Component component, GridConstraints constraints)
	{
		return getSize(constraints.myMaximumSize, MAX_SIZE);
	}

	public static Dimension getPreferredSize(Component component, GridConstraints constraints)
	{
		return getSize(constraints.myPreferredSize, component.getPreferredSize());
	}

	private static Dimension getSize(Dimension overridenSize, Dimension ownSize)
	{
		int overridenWidth = overridenSize.width < 0 ? ownSize.width : overridenSize.width;
		int overridenHeight = overridenSize.height < 0 ? ownSize.height : overridenSize.height;
		return new Dimension(overridenWidth, overridenHeight);
	}

	public static void adjustSize(Component component, GridConstraints constraints, Dimension size)
	{
		Dimension minimumSize = getMinimumSize(component, constraints);
		Dimension maximumSize = getMaximumSize(component, constraints);
		size.width = Math.max(size.width, minimumSize.width);
		size.height = Math.max(size.height, minimumSize.height);
		size.width = Math.min(size.width, maximumSize.width);
		size.height = Math.min(size.height, maximumSize.height);
	}

	public static int eliminate(int cellIndices[], int spans[], ArrayList<Integer> elimitated)
	{
		int size = ((int[])cellIndices).length;
		if(size != ((int[])spans).length)
			throw new IllegalArgumentException("size mismatch: " + size + ", " + ((int[])spans).length);
		if(elimitated != null && elimitated.size() != 0)
			throw new IllegalArgumentException("eliminated must be empty");
		int cellCount = 0;
		for(int i = 0; i < size; i++)
			cellCount = Math.max(cellCount, ((int[])cellIndices)[i] + ((int[])spans)[i]);

		for(int cell = cellCount - 1; cell >= 0; cell--)
		{
			boolean starts = false;
			boolean ends = false;
			for(int i = 0; i < size; i++)
			{
				if(((int[])cellIndices)[i] == cell)
					starts = true;
				if((((int[])cellIndices)[i] + ((int[])spans)[i]) - 1 == cell)
					ends = true;
			}

			if(!starts || !ends)
			{
				if(elimitated != null)
					elimitated.add(new Integer(cell));
				for(int i = 0; i < size; i++)
				{
					boolean decreaseSpan = ((int[])cellIndices)[i] <= cell && cell < ((int[])cellIndices)[i] + ((int[])spans)[i];
					boolean decreaseIndex = ((int[])cellIndices)[i] > cell;
					if(decreaseSpan)
						((int[])spans)[i]--;
					if(decreaseIndex)
						((int[])cellIndices)[i]--;
				}

				cellCount--;
			}
		}

		return cellCount;
	}

	private static final Dimension MAX_SIZE = new Dimension(0x7fffffff, 0x7fffffff);

}
