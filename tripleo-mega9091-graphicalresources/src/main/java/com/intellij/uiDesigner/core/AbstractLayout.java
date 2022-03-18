// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AbstractLayout.java

package com.intellij.uiDesigner.core;

import java.awt.*;

// Referenced classes of package com.intellij.uiDesigner.core:
//			GridConstraints

public abstract class AbstractLayout
	implements LayoutManager2
{

	public AbstractLayout()
	{
		myComponents = new Component[0];
		myConstraints = new GridConstraints[0];
		myMargin = new Insets(0, 0, 0, 0);
		myHGap = -1;
		myVGap = -1;
	}

	public final Insets getMargin()
	{
		return (Insets)myMargin.clone();
	}

	public final int getHGap()
	{
		return myHGap;
	}

	protected static final int getHGapImpl(Container container)
	{
		if(container == null)
			throw new IllegalArgumentException("container cannot be null");
		for(; container != null; container = container.getParent())
			if(container.getLayout() instanceof AbstractLayout)
			{
				AbstractLayout layout = (AbstractLayout)container.getLayout();
				if(layout.getHGap() != -1)
					return layout.getHGap();
			}

		return 10;
	}

	public final void setHGap(int hGap)
	{
		if(hGap < -1)
		{
			throw new IllegalArgumentException("wrong hGap: " + hGap);
		} else
		{
			myHGap = hGap;
			return;
		}
	}

	public final int getVGap()
	{
		return myVGap;
	}

	protected static final int getVGapImpl(Container container)
	{
		if(container == null)
			throw new IllegalArgumentException("container cannot be null");
		for(; container != null; container = container.getParent())
			if(container.getLayout() instanceof AbstractLayout)
			{
				AbstractLayout layout = (AbstractLayout)container.getLayout();
				if(layout.getVGap() != -1)
					return layout.getVGap();
			}

		return 5;
	}

	public final void setVGap(int vGap)
	{
		if(vGap < -1)
		{
			throw new IllegalArgumentException("wrong vGap: " + vGap);
		} else
		{
			myVGap = vGap;
			return;
		}
	}

	public final void setMargin(Insets margin)
	{
		if(margin == null)
		{
			throw new IllegalArgumentException("margin cannot be null");
		} else
		{
			myMargin = (Insets)margin.clone();
			return;
		}
	}

	final int getComponentCount()
	{
		return myComponents.length;
	}

	final Component getComponent(int index)
	{
		return myComponents[index];
	}

	final GridConstraints getConstraints(int index)
	{
		return myConstraints[index];
	}

	public void addLayoutComponent(Component comp, Object constraints)
	{
		if(!(constraints instanceof GridConstraints))
		{
			throw new IllegalArgumentException("constraints: " + constraints);
		} else
		{
			Component newComponents[] = new Component[myComponents.length + 1];
			System.arraycopy(myComponents, 0, newComponents, 0, myComponents.length);
			newComponents[myComponents.length] = comp;
			myComponents = newComponents;
			GridConstraints newConstraints[] = new GridConstraints[myConstraints.length + 1];
			System.arraycopy(myConstraints, 0, newConstraints, 0, myConstraints.length);
			newConstraints[myConstraints.length] = (GridConstraints)constraints;
			myConstraints = newConstraints;
			return;
		}
	}

	public final void addLayoutComponent(String name, Component comp)
	{
		throw new UnsupportedOperationException();
	}

	public final void removeLayoutComponent(Component comp)
	{
		int i = getComponentIndex(comp);
		if(i == -1)
		{
			throw new IllegalArgumentException("component was not added: " + comp);
		} else
		{
			Component newComponents[] = new Component[myComponents.length - 1];
			System.arraycopy(myComponents, 0, newComponents, 0, i);
			System.arraycopy(myComponents, i + 1, newComponents, i, myComponents.length - i - 1);
			myComponents = newComponents;
			GridConstraints newConstraints[] = new GridConstraints[myConstraints.length - 1];
			System.arraycopy(myConstraints, 0, newConstraints, 0, i);
			System.arraycopy(myConstraints, i + 1, newConstraints, i, myConstraints.length - i - 1);
			myConstraints = newConstraints;
			return;
		}
	}

	private int getComponentIndex(Component comp)
	{
		for(int i = 0; i < myComponents.length; i++)
		{
			Component component = myComponents[i];
			if(component == comp)
				return i;
		}

		return -1;
	}

	public final float getLayoutAlignmentX(Container container)
	{
		return 0.5F;
	}

	public final float getLayoutAlignmentY(Container container)
	{
		return 0.5F;
	}

	public abstract void invalidateLayout(Container container);

	public abstract Dimension maximumLayoutSize(Container container);

	public abstract void layoutContainer(Container container);

	public abstract Dimension minimumLayoutSize(Container container);

	public abstract Dimension preferredLayoutSize(Container container);

	private static final int DEFAULT_HGAP = 10;
	private static final int DEFAULT_VGAP = 5;
	protected Component myComponents[];
	protected GridConstraints myConstraints[];
	protected Insets myMargin;
	private int myHGap;
	private int myVGap;
}
