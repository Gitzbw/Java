import org.junit.jupiter.api.Test;

import java.util.Objects;

public class t {
    public static void main(String[] args) {
    }
}

class a
{
    int i = 0;
    @Test
    void test()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        a a = (a) o;
        return i == a.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}