// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GridLayoutManager.java
package com.intellij.uiDesigner.core;

import java.awt.*;
import java.util.Arrays;

// Referenced classes of package com.intellij.uiDesigner.core:
//			AbstractLayout, GridConstraints, Spacer, LayoutState, 
//			HorizontalInfo, VerticalInfo, DimensionInfo, Util
public final class GridLayoutManager extends AbstractLayout {

    public GridLayoutManager(int rowCount, int columnCount) {
        myMinCellSize = 20;
        if (columnCount < 1) {
            throw new IllegalArgumentException("wrong columnCount: " + columnCount);
        }
        if (rowCount < 1) {
            throw new IllegalArgumentException("wrong rowCount: " + rowCount);
        }
        myRowStretches = new int[rowCount];
        for (int i = 0; i < rowCount; i++) {
            ((int[]) myRowStretches)[i] = 1;
        }

        myColumnStretches = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            ((int[]) myColumnStretches)[i] = 1;
        }

        myXs = new int[columnCount];
        myWidths = new int[columnCount];
        myYs = new int[rowCount];
        myHeights = new int[rowCount];
    }

    public GridLayoutManager(int rowCount, int columnCount, Insets margin, int hGap, int vGap) {
        this(rowCount, columnCount);
        setMargin(margin);
        setHGap(hGap);
        setVGap(vGap);
        myMinCellSize = 0;
    }

    public GridLayoutManager(int rowCount, int columnCount, Insets margin, int hGap, int vGap, boolean sameSizeHorizontally, boolean sameSizeVertically) {
        this(rowCount, columnCount, margin, hGap, vGap);
        mySameSizeHorizontally = sameSizeHorizontally;
        mySameSizeVertically = sameSizeVertically;
    }

    public void addLayoutComponent(Component comp, Object constraints) {
        GridConstraints c = (GridConstraints) constraints;
        int row = c.getRow();
        int rowSpan = c.getRowSpan();
        int rowCount = getRowCount();
        if (row < 0 || row >= rowCount) {
            throw new IllegalArgumentException("wrong row: " + row);
        }
        if ((row + rowSpan) - 1 >= rowCount) {
            throw new IllegalArgumentException("wrong row span: " + rowSpan + "; row=" + row + " rowCount=" + rowCount);
        }
        int column = c.getColumn();
        int colSpan = c.getColSpan();
        int columnCount = getColumnCount();
        if (column < 0 || column >= columnCount) {
            throw new IllegalArgumentException("wrong column: " + column);
        }
        if ((column + colSpan) - 1 >= columnCount) {
            throw new IllegalArgumentException("wrong col span: " + colSpan + "; column=" + column + " columnCount=" + columnCount);
        } else {
            super.addLayoutComponent(comp, constraints);
            return;
        }
    }

    public int getRowCount() {
        return ((int[]) myRowStretches).length;
    }

    public int getColumnCount() {
        return ((int[]) myColumnStretches).length;
    }

    public int getRowStretch(int rowIndex) {
        return ((int[]) myRowStretches)[rowIndex];
    }

    public void setRowStretch(int rowIndex, int stretch) {
        if (stretch < 1) {
            throw new IllegalArgumentException("wrong stretch: " + stretch);
        } else {
            ((int[]) myRowStretches)[rowIndex] = stretch;
            return;
        }
    }

    public int getColumnStretch(int columnIndex) {
        return ((int[]) myColumnStretches)[columnIndex];
    }

    public void setColumnStretch(int columnIndex, int stretch) {
        if (stretch < 1) {
            throw new IllegalArgumentException("wrong stretch: " + stretch);
        } else {
            ((int[]) myColumnStretches)[columnIndex] = stretch;
            return;
        }
    }

    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(0x7fffffff, 0x7fffffff);
    }

    public Dimension minimumLayoutSize(Container container) {
        validateInfos(container);
        DimensionInfo horizontalInfo = myHorizontalInfo;
        DimensionInfo verticalInfo = myVerticalInfo;
        Dimension result = getTotalGap(container, horizontalInfo, verticalInfo);
        int widths[] = (int[]) getMinSizes(horizontalInfo);
        if (mySameSizeHorizontally) {
            makeSameSizes((int[]) widths);
        }
        result.width += sum((int[]) widths);
        int heights[] = (int[]) getMinSizes(verticalInfo);
        if (mySameSizeVertically) {
            makeSameSizes((int[]) heights);
        }
        result.height += sum((int[]) heights);
        return result;
    }

    private void makeSameSizes(int widths[]) {
        int max = ((int[]) widths)[0];
        for (int i = 0; i < ((int[]) widths).length; i++) {
            int width = ((int[]) widths)[i];
            max = Math.max(width, max);
        }

        for (int i = 0; i < ((int[]) widths).length; i++) {
            ((int[]) widths)[i] = max;
        }

    }

    private int[] getSameSizes(DimensionInfo info, int totalWidth) {
        int widths[] = new int[info.getCellCount()];
        int average = totalWidth / ((int[]) widths).length;
        int rest = totalWidth % ((int[]) widths).length;
        for (int i = 0; i < ((int[]) widths).length; i++) {
            ((int[]) widths)[i] = average;
            if (rest > 0) {
                ((int[]) widths)[i]++;
                rest--;
            }
        }

        return (int[]) widths;
    }

    public Dimension preferredLayoutSize(Container container) {
        validateInfos(container);
        DimensionInfo horizontalInfo = myHorizontalInfo;
        DimensionInfo verticalInfo = myVerticalInfo;
        Dimension result = getTotalGap(container, horizontalInfo, verticalInfo);
        int widths[] = (int[]) getPrefSizes(horizontalInfo);
        if (mySameSizeHorizontally) {
            makeSameSizes((int[]) widths);
        }
        result.width += sum((int[]) widths);
        int heights[] = (int[]) getPrefSizes(verticalInfo);
        if (mySameSizeVertically) {
            makeSameSizes((int[]) heights);
        }
        result.height += sum((int[]) heights);
        return result;
    }

    private static int sum(int ints[]) {
        int result = 0;
        for (int i = ((int[]) ints).length - 1; i >= 0; i--) {
            result += ((int[]) ints)[i];
        }

        return result;
    }

    private Dimension getTotalGap(Container container, DimensionInfo hInfo, DimensionInfo vInfo) {
        Insets insets = container.getInsets();
        return new Dimension(insets.left + insets.right + countGap(hInfo, 0, hInfo.getCellCount()) + myMargin.left + myMargin.right, insets.top + insets.bottom + countGap(vInfo, 0, vInfo.getCellCount()) + myMargin.top + myMargin.bottom);
    }

    private static int countGap(DimensionInfo info, int startCell, int cellCount) {
        int counter = 0;
        for (int cellIndex = (startCell + cellCount) - 2; cellIndex >= startCell; cellIndex--) {
            if (shouldAddGapAfterCell(info, cellIndex)) {
                counter++;
            }
        }

        return counter * info.getGap();
    }

    private static boolean shouldAddGapAfterCell(DimensionInfo info, int cellIndex) {
        if (cellIndex < 0 || cellIndex >= info.getCellCount()) {
            throw new IllegalArgumentException("wrong cellIndex: " + cellIndex + "; cellCount=" + info.getCellCount());
        }
        boolean endsInThis = false;
        boolean startsInNext = false;
        int indexOfNextNotEmpty = -1;
        for (int i = cellIndex + 1; i < info.getCellCount(); i++) {
            if (isCellEmpty(info, i)) {
                continue;
            }
            indexOfNextNotEmpty = i;
            break;
        }

        for (int i = 0; i < info.getComponentCount(); i++) {
            Component component = info.getComponent(i);
            if (!(component instanceof Spacer)) {
                if (info.getCell(i) == indexOfNextNotEmpty) {
                    startsInNext = true;
                }
                if ((info.getCell(i) + info.getSpan(i)) - 1 == cellIndex) {
                    endsInThis = true;
                }
            }
        }

        return startsInNext && endsInThis;
    }

    private static boolean isCellEmpty(DimensionInfo info, int cellIndex) {
        if (cellIndex < 0 || cellIndex >= info.getCellCount()) {
            throw new IllegalArgumentException("wrong cellIndex: " + cellIndex + "; cellCount=" + info.getCellCount());
        }
        for (int i = 0; i < info.getComponentCount(); i++) {
            Component component = info.getComponent(i);
            if (info.getCell(i) == cellIndex && !(component instanceof Spacer)) {
                return false;
            }
        }

        return true;
    }

    public void layoutContainer(Container container) {
        validateInfos(container);
        LayoutState layoutState = myLayoutState;
        DimensionInfo horizontalInfo = myHorizontalInfo;
        DimensionInfo verticalInfo = myVerticalInfo;
        Dimension gap = getTotalGap(container, horizontalInfo, verticalInfo);
        Dimension size = container.getSize();
        size.width -= gap.width;
        size.height -= gap.height;
        Dimension prefSize = preferredLayoutSize(container);
        prefSize.width -= gap.width;
        prefSize.height -= gap.height;
        Dimension minSize = minimumLayoutSize(container);
        minSize.width -= gap.width;
        minSize.height -= gap.height;
        int heights[];
        if (mySameSizeVertically) {
            heights = (int[]) getSameSizes(verticalInfo, Math.max(size.height, minSize.height));
        } else if (size.height < prefSize.height) {
            heights = (int[]) getMinSizes(verticalInfo);
            new_doIt((int[]) heights, 0, verticalInfo.getCellCount(), size.height, verticalInfo, true);
        } else {
            heights = (int[]) getPrefSizes(verticalInfo);
            new_doIt((int[]) heights, 0, verticalInfo.getCellCount(), size.height, verticalInfo, false);
        }
        Insets insets = container.getInsets();
        int y = insets.top + myMargin.top;
        for (int i = 0; i < ((int[]) heights).length; i++) {
            ((int[]) myYs)[i] = y;
            ((int[]) myHeights)[i] = ((int[]) heights)[i];
            y += ((int[]) heights)[i];
            if (shouldAddGapAfterCell(verticalInfo, i)) {
                y += verticalInfo.getGap();
            }
        }

        int widths[];
        if (mySameSizeHorizontally) {
            widths = (int[]) getSameSizes(horizontalInfo, Math.max(size.width, minSize.width));
        } else if (size.width < prefSize.width) {
            widths = (int[]) getMinSizes(horizontalInfo);
            new_doIt((int[]) widths, 0, horizontalInfo.getCellCount(), size.width, horizontalInfo, true);
        } else {
            widths = (int[]) getPrefSizes(horizontalInfo);
            new_doIt((int[]) widths, 0, horizontalInfo.getCellCount(), size.width, horizontalInfo, false);
        }
        int x = insets.left + myMargin.left;
        for (int i = 0; i < ((int[]) widths).length; i++) {
            ((int[]) myXs)[i] = x;
            ((int[]) myWidths)[i] = ((int[]) widths)[i];
            x += ((int[]) widths)[i];
            if (shouldAddGapAfterCell(horizontalInfo, i)) {
                x += horizontalInfo.getGap();
            }
        }

        for (int i = 0; i < layoutState.getComponentCount(); i++) {
            GridConstraints c = layoutState.getConstraints(i);
            Component component = layoutState.getComponent(i);
            int column = horizontalInfo.getCell(i);
            int colSpan = horizontalInfo.getSpan(i);
            int row = verticalInfo.getCell(i);
            int rowSpan = verticalInfo.getSpan(i);
            int cellWidth = (((int[]) myXs)[(column + colSpan) - 1] + ((int[]) myWidths)[(column + colSpan) - 1]) - ((int[]) myXs)[column];
            int cellHeight = (((int[]) myYs)[(row + rowSpan) - 1] + ((int[]) myHeights)[(row + rowSpan) - 1]) - ((int[]) myYs)[row];
            Dimension componentSize = new Dimension(cellWidth, cellHeight);
            if ((c.getFill() & 1) == 0) {
                componentSize.width = Math.min(componentSize.width, horizontalInfo.getPreferredWidth(i));
            }
            if ((c.getFill() & 2) == 0) {
                componentSize.height = Math.min(componentSize.height, verticalInfo.getPreferredWidth(i));
            }
            Util.adjustSize(component, c, componentSize);
            int dx = 0;
            int dy = 0;
            if ((c.getAnchor() & 4) != 0) {
                dx = cellWidth - componentSize.width;
            } else if ((c.getAnchor() & 8) == 0) {
                dx = (cellWidth - componentSize.width) / 2;
            }
            if ((c.getAnchor() & 2) != 0) {
                dy = cellHeight - componentSize.height;
            } else if ((c.getAnchor() & 1) == 0) {
                dy = (cellHeight - componentSize.height) / 2;
            }
            component.setBounds(((int[]) myXs)[column] + dx, ((int[]) myYs)[row] + dy, componentSize.width, componentSize.height);
        }

    }

    public void invalidateLayout(Container container) {
        myLayoutState = null;
        myHorizontalInfo = null;
        myVerticalInfo = null;
    }

    private void validateInfos(Container container) {
        if (myLayoutState == null) {
            myLayoutState = new LayoutState(this, true);
            myHorizontalInfo = new HorizontalInfo(myLayoutState, AbstractLayout.getHGapImpl(container));
            myVerticalInfo = new VerticalInfo(myLayoutState, AbstractLayout.getVGapImpl(container));
        }
    }

    public int[] getXs() {
        return (int[]) myXs;
    }

    public int[] getWidths() {
        return (int[]) myWidths;
    }

    public int[] getYs() {
        return (int[]) myYs;
    }

    public int[] getHeights() {
        return (int[]) myHeights;
    }

    public int getRowAt(int y) {
        for (int i = 0; i < ((int[]) myYs).length; i++) {
            if (((int[]) myYs)[i] <= y && y <= ((int[]) myYs)[i] + ((int[]) myHeights)[i]) {
                return i;
            }
        }

        return -1;
    }

    public int getColumnAt(int x) {
        for (int i = 0; i < ((int[]) myXs).length; i++) {
            if (((int[]) myXs)[i] <= x && x <= ((int[]) myXs)[i] + ((int[]) myWidths)[i]) {
                return i;
            }
        }

        return -1;
    }

    private int[] getMinSizes(DimensionInfo info) {
        return (int[]) getMinOrPrefSizes(info, true);
    }

    private int[] getPrefSizes(DimensionInfo info) {
        return (int[]) getMinOrPrefSizes(info, false);
    }

    private int[] getMinOrPrefSizes(DimensionInfo info, boolean min) {
        int widths[] = new int[info.getCellCount()];
        for (int i = 0; i < ((int[]) widths).length; i++) {
            ((int[]) widths)[i] = myMinCellSize;
        }

        for (int i = info.getComponentCount() - 1; i >= 0; i--) {
            if (info.getSpan(i) == 1) {
                int size = min ? getMin2(info, i) : Math.max(info.getMinimumWidth(i), info.getPreferredWidth(i));
                int gap = countGap(info, info.getCell(i), info.getSpan(i));
                size = Math.max(size - gap, 0);
                ((int[]) widths)[info.getCell(i)] = Math.max(((int[]) widths)[info.getCell(i)], size);
            }
        }

        boolean toProcess[] = new boolean[info.getCellCount()];
        for (int i = info.getComponentCount() - 1; i >= 0; i--) {
            int size = min ? getMin2(info, i) : Math.max(info.getMinimumWidth(i), info.getPreferredWidth(i));
            int span = info.getSpan(i);
            int cell = info.getCell(i);
            int gap = countGap(info, cell, span);
            size = Math.max(size - gap, 0);
            Arrays.fill((boolean[]) toProcess, false);
            int curSize = 0;
            for (int j = 0; j < span; j++) {
                curSize += ((int[]) widths)[j + cell];
                ((boolean[]) toProcess)[j + cell] = true;
            }

            if (curSize < size) {
                boolean higherPriorityCells[] = new boolean[((boolean[]) toProcess).length];
                getCellsWithHigherPriorities(info, (boolean[]) toProcess, (boolean[]) higherPriorityCells, false, (int[]) widths);
                distribute((boolean[]) higherPriorityCells, info, size - curSize, (int[]) widths);
            }
        }

        return (int[]) widths;
    }

    private static int getMin2(DimensionInfo info, int componentIndex) {
        int s;
        if ((info.getSizePolicy(componentIndex) & 1) != 0) {
            s = info.getMinimumWidth(componentIndex);
        } else {
            s = Math.max(info.getMinimumWidth(componentIndex), info.getPreferredWidth(componentIndex));
        }
        return s;
    }

    private void new_doIt(int widths[], int cell, int span, int minWidth, DimensionInfo info, boolean checkPrefs) {
        int toDistribute = minWidth;
        for (int i = cell; i < cell + span; i++) {
            toDistribute -= ((int[]) widths)[i];
        }

        if (toDistribute <= 0) {
            return;
        }
        boolean allowedCells[] = new boolean[info.getCellCount()];
        for (int i = cell; i < cell + span; i++) {
            ((boolean[]) allowedCells)[i] = true;
        }

        boolean higherPriorityCells[] = new boolean[info.getCellCount()];
        getCellsWithHigherPriorities(info, (boolean[]) allowedCells, (boolean[]) higherPriorityCells, checkPrefs, (int[]) widths);
        distribute((boolean[]) higherPriorityCells, info, toDistribute, (int[]) widths);
    }

    private static void distribute(boolean higherPriorityCells[], DimensionInfo info, int toDistribute, int widths[]) {
        int stretches = 0;
        for (int i = 0; i < info.getCellCount(); i++) {
            if (((boolean[]) higherPriorityCells)[i]) {
                stretches += info.getStretch(i);
            }
        }

        int toDistributeFrozen = toDistribute;
        for (int i = 0; i < info.getCellCount(); i++) {
            if (((boolean[]) higherPriorityCells)[i]) {
                int addon = (toDistributeFrozen * info.getStretch(i)) / stretches;
                ((int[]) widths)[i] += addon;
                toDistribute -= addon;
            }
        }

        if (toDistribute != 0) {
            for (int i = 0; i < info.getCellCount(); i++) {
                if (!((boolean[]) higherPriorityCells)[i]) {
                    continue;
                }
                ((int[]) widths)[i]++;
                if (--toDistribute == 0) {
                    break;
                }
            }

        }
        if (toDistribute != 0) {
            throw new IllegalStateException("toDistribute = " + toDistribute);
        } else {
            return;
        }
    }

    private void getCellsWithHigherPriorities(DimensionInfo info, boolean allowedCells[], boolean higherPriorityCells[], boolean checkPrefs, int widths[]) {
        Arrays.fill((boolean[]) higherPriorityCells, false);
        int foundCells = 0;
        if (checkPrefs) {
            int prefs[] = (int[]) getMinOrPrefSizes(info, false);
            for (int cell = 0; cell < ((boolean[]) allowedCells).length; cell++) {
                if (((boolean[]) allowedCells)[cell] && !isCellEmpty(info, cell) && ((int[]) prefs)[cell] > ((int[]) widths)[cell]) {
                    ((boolean[]) higherPriorityCells)[cell] = true;
                    foundCells++;
                }
            }

            if (foundCells > 0) {
                return;
            }
        }
        for (int cell = 0; cell < ((boolean[]) allowedCells).length; cell++) {
            if (((boolean[]) allowedCells)[cell] && (info.getCellSizePolicy(cell) & 4) != 0) {
                ((boolean[]) higherPriorityCells)[cell] = true;
                foundCells++;
            }
        }

        if (foundCells > 0) {
            return;
        }
        for (int cell = 0; cell < ((boolean[]) allowedCells).length; cell++) {
            if (((boolean[]) allowedCells)[cell] && (info.getCellSizePolicy(cell) & 2) != 0) {
                ((boolean[]) higherPriorityCells)[cell] = true;
                foundCells++;
            }
        }

        if (foundCells > 0) {
            return;
        }
        for (int cell = 0; cell < ((boolean[]) allowedCells).length; cell++) {
            if (((boolean[]) allowedCells)[cell] && !isCellEmpty(info, cell)) {
                ((boolean[]) higherPriorityCells)[cell] = true;
                foundCells++;
            }
        }

        if (foundCells > 0) {
            return;
        }
        for (int cell = 0; cell < ((boolean[]) allowedCells).length; cell++) {
            if (((boolean[]) allowedCells)[cell]) {
                ((boolean[]) higherPriorityCells)[cell] = true;
            }
        }

    }

    public boolean isSameSizeHorizontally() {
        return mySameSizeHorizontally;
    }

    public boolean isSameSizeVertically() {
        return mySameSizeVertically;
    }

    public void setSameSizeHorizontally(boolean sameSizeHorizontally) {
        mySameSizeHorizontally = sameSizeHorizontally;
    }

    public void setSameSizeVertically(boolean sameSizeVertically) {
        mySameSizeVertically = sameSizeVertically;
    }

    private int myMinCellSize;
    private final int myRowStretches[];
    private final int myColumnStretches[];
    private final int myYs[];
    private final int myHeights[];
    private final int myXs[];
    private final int myWidths[];
    private LayoutState myLayoutState;
    DimensionInfo myHorizontalInfo;
    DimensionInfo myVerticalInfo;
    private boolean mySameSizeHorizontally;
    private boolean mySameSizeVertically;
}
