package guicarneiro.com.origin.utils;

import mockit.Mock;
import mockit.MockUp;

import java.util.Calendar;

public final class FakeCalendarMock extends MockUp<Calendar> {

    private final int year;

    public FakeCalendarMock(int year) {
        this.year = year;
    }

    @Mock
    public int get(int id) {
        if (id == Calendar.YEAR) {
            return year;
        }
        return -1;
    }
}