// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VerticalInfo.java
package com.intellij.uiDesigner.core;

import java.awt.Dimension;

// Referenced classes of package com.intellij.uiDesigner.core:
//			DimensionInfo, GridConstraints, LayoutState
final class VerticalInfo extends DimensionInfo {

    public VerticalInfo(LayoutState layoutState, int gap) {
        super(layoutState, gap);
    }

    protected int getOriginalCell(GridConstraints constraints) {
        return constraints.getRow();
    }

    protected int getOriginalSpan(GridConstraints constraints) {
        return constraints.getRowSpan();
    }

    int getSizePolicy(int componentIndex) {
        return myLayoutState.getConstraints(componentIndex).getVSizePolicy();
    }

    public int getMinimumWidth(int componentIndex) {
        return getMinimumSize(componentIndex).height;
    }

    public int getCellCount() {
        return myLayoutState.getRowCount();
    }

    public int getPreferredWidth(int componentIndex) {
        return getPreferredSize(componentIndex).height;
    }
}
