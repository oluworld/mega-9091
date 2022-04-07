// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LayoutState.java
package com.intellij.uiDesigner.core;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

// Referenced classes of package com.intellij.uiDesigner.core:
//			GridConstraints, GridLayoutManager
public final class LayoutState {

    public LayoutState(GridLayoutManager layout, boolean ignoreInvisibleComponents) {
        ArrayList<Component> componentsList = new ArrayList<Component>(layout.getComponentCount());
        ArrayList<GridConstraints> constraintsList = new ArrayList<GridConstraints>(layout.getComponentCount());
        for (int i = 0; i < layout.getComponentCount(); i++) {
            Component component = layout.getComponent(i);
            if (!ignoreInvisibleComponents || component.isVisible()) {
                componentsList.add(component);
                GridConstraints constraints = layout.getConstraints(i);
                constraintsList.add(constraints);
            }
        }

        myComponents = (Component[]) (Object[]) componentsList.toArray(new Component[componentsList.size()]);
        myConstraints = (GridConstraints[]) (Object[]) constraintsList.toArray(new GridConstraints[constraintsList.size()]);
        myMinimumSizes = new Dimension[myComponents.length];
        myPreferredSizes = new Dimension[myComponents.length];
        myColumnCount = layout.getColumnCount();
        myRowCount = layout.getRowCount();
    }

    public int getComponentCount() {
        return myComponents.length;
    }

    public Component getComponent(int index) {
        return myComponents[index];
    }

    public GridConstraints getConstraints(int index) {
        return myConstraints[index];
    }

    public int getColumnCount() {
        return myColumnCount;
    }

    public int getRowCount() {
        return myRowCount;
    }

    private final Component myComponents[];
    private final GridConstraints myConstraints[];
    private final int myColumnCount;
    private final int myRowCount;
    final Dimension myPreferredSizes[];
    final Dimension myMinimumSizes[];
}
