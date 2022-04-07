/*
Copyright (C) 1998 Stepan Solokov (sts@crocodile.org)

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public
License as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Library General Public License for more details.

You should have received a copy of the GNU Library General Public
License along with this library; if not, write to the
Free Software Foundation, Inc., 59 Temple Place - Suite 330,
Boston, MA  02111-1307, USA.
 */
package gnu.rex;

abstract class State {

    static final short IMPASSE = -1;
    static final short DEFTRAN = IMPASSE;

    byte backRef = -1;

    short getNext0() {
        return IMPASSE;
    }

    short getNext1() {
        return IMPASSE;
    }

    boolean hasTransitionOn(char c) {
        return false;
    }

    void setAccept() {
    }

    void resetAccept() {
    }

    boolean canAccept() {
        return false;
    }

    short getMin() {
        return 0;
    }

    short getMax() {
        return 0;
    }

    short getPass() {
        return -1;
    }

    short incPass() {
        return -1;
    }

    void reset() {
    }

    abstract String stateToString();

}
