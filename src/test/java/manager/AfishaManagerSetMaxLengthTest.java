package manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerSetMaxLengthTest {
    AfishaManager manager = new AfishaManager();

    @Test
    public void setMaxLengthUnderZero() {
        int userMaxLength = -1;
        manager.setMaxLength(userMaxLength);
        int expected = 10;
        int actual = manager.getMaxLength();
        assertEquals(expected, actual);
    }
    @Test
    public void setMaxLengthZero() {
        int userMaxLength = 0;
        manager.setMaxLength(userMaxLength);
        int expected = 0;
        int actual = manager.getMaxLength();
        assertEquals(expected, actual);
    }
    @Test
    public void setMaxLengthOverZero() {
        int userMaxLength = 1;
        manager.setMaxLength(userMaxLength);
        int expected = 1;
        int actual = manager.getMaxLength();
        assertEquals(expected, actual);
    }
    @Test
    public void setMaxLengthRandom() {
        int userMaxLength = 13;
        manager.setMaxLength(userMaxLength);
        int expected = 13;
        int actual = manager.getMaxLength();
        assertEquals(expected, actual);
    }


}

