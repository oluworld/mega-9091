// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Spacer.java
package com.intellij.uiDesigner.core;

import java.awt.Dimension;
import javax.swing.JComponent;

public class Spacer extends JComponent {

    public Spacer() {
    }

    public Dimension getMinimumSize() {
        return new Dimension(0, 0);
    }

    public final Dimension getPreferredSize() {
        return getMinimumSize();
    }
}
