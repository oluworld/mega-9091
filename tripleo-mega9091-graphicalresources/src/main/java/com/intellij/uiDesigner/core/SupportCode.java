// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SupportCode.java
package com.intellij.uiDesigner.core;

import java.lang.reflect.Method;
import java.util.ResourceBundle;
import javax.swing.*;

public final class SupportCode {

    public static final class TextWithMnemonic {

        public char getMnemonicChar() {
            if (myMnemonicIndex == -1) {
                throw new IllegalStateException("text doesn't contain mnemonic");
            } else {
                return Character.toUpperCase(myText.charAt(myMnemonicIndex));
            }
        }

        public final String myText;
        public final int myMnemonicIndex;

        private TextWithMnemonic(String text, int index) {
            if (text == null) {
                throw new IllegalArgumentException("text cannot be null");
            }
            if (index != -1 && (index < 0 || index >= text.length())) {
                throw new IllegalArgumentException("wrong index: " + index + "; text = '" + text + "'");
            } else {
                myText = text;
                myMnemonicIndex = index;
                return;
            }
        }

    }

    public SupportCode() {
    }

    public static TextWithMnemonic parseText(String textWithMnemonic) {
        if (textWithMnemonic == null) {
            throw new IllegalArgumentException("textWithMnemonic cannot be null");
        }
        int index = -1;
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < textWithMnemonic.length(); i++) {
            char ch = textWithMnemonic.charAt(i);
            if (ch == '&') {
                if (++i >= textWithMnemonic.length()) {
                    break;
                }
                ch = textWithMnemonic.charAt(i);
                if (ch != '&') {
                    index = plainText.length();
                }
            }
            plainText.append(ch);
        }

        return new TextWithMnemonic(plainText.toString(), index);
    }

    public static void setTextFromBundle(JComponent component, String bundleName, String key) {
        if (component == null) {
            throw new IllegalArgumentException("component cannot be null");
        }
        if (bundleName == null) {
            throw new IllegalArgumentException("bundleName cannot be null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        String text = getResourceString(bundleName, key);
        TextWithMnemonic textWithMnemonic = parseText(text);
        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setText(textWithMnemonic.myText);
            if (textWithMnemonic.myMnemonicIndex != -1) {
                label.setDisplayedMnemonic(textWithMnemonic.getMnemonicChar());
                setDisplayedMnemonicIndex(label, textWithMnemonic.myMnemonicIndex);
            }
        } else if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setText(textWithMnemonic.myText);
            if (textWithMnemonic.myMnemonicIndex != -1) {
                button.setMnemonic(textWithMnemonic.getMnemonicChar());
                setDisplayedMnemonicIndex(button, textWithMnemonic.myMnemonicIndex);
            }
        } else {
            throw new IllegalArgumentException("unexpected class: " + component.getClass());
        }
    }

    public static void setTextFromBundle(JComponent component, String setterName, String bundle, String key) {
        if (component == null) {
            throw new IllegalArgumentException("component cannot be null");
        }
        if (setterName == null) {
            throw new IllegalArgumentException("setterName cannot be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("bundle cannot be null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        String text = getResourceString(bundle, key);
        TextWithMnemonic textWithMnemonic = parseText(text);
        try {
            Method setter = component.getClass().getMethod(setterName, new Class[]{
                java.lang.String.class
            });
            setter.invoke(component, new Object[]{
                textWithMnemonic.myText
            });
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        if (textWithMnemonic.myMnemonicIndex != -1 && setterName.equals("setText")) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setDisplayedMnemonic(textWithMnemonic.getMnemonicChar());
                setDisplayedMnemonicIndex(label, textWithMnemonic.myMnemonicIndex);
            } else if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setMnemonic(textWithMnemonic.getMnemonicChar());
                setDisplayedMnemonicIndex(button, textWithMnemonic.myMnemonicIndex);
            }
        }
    }

    public static void setDisplayedMnemonicIndex(JComponent component, int index) {
        try {
            Method method = component.getClass().getMethod("setDisplayedMnemonicIndex", new Class[]{
                Integer.TYPE
            });
            method.setAccessible(true);
            method.invoke(component, new Object[]{
                new Integer(index)
            });
        } catch (Exception e) {
        }
    }

    public static String getResourceString(String bundleName, String key) {
        return ResourceBundle.getBundle(bundleName).getString(key);
    }
}
