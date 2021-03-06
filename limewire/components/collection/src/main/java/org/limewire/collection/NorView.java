package org.limewire.collection;

/**
 * 
 * <pre>
 * Output: bf1: 1100 
 *         bf2: 1010 
 *         av:  0001
 * </pre>
 */
public class NorView extends BooleanFunction {

    public NorView(BitField first, BitField... more) {
        super(first, more);
    }

    public boolean get(int i) {

        boolean interesting = true;
        for (BitField bf : fields) {
            if (bf.get(i)) {
                return false;
            }
        }
        return interesting;
    }

    public int nextClearBit(int startIndex) {
        for (int i = startIndex; i < maxSize(); i++) {
            boolean set = get(i);
            if (!set) {
                return i;
            }
        }

        return -1;
    }

    public int nextSetBit(int startIndex) {
        for (int i = startIndex; i < maxSize(); i++) {
            boolean set = get(i);
            if (set) {
                return i;
            }
        }
        return -1;
    }

}
