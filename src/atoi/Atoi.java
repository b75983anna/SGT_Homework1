package atoi;

public class Atoi {
    static int myAtoi(char[] str)
    {
        int sign = 1, base = 0, i = 0;

        while (str[i] == ' ')
        {
            i++;
        }

        if (str[i] == '-' || str[i] == '+')
        {
            sign = 1 - 2 * (str[i++] == '-' ? 1 : 0);
        }

        // checking for valid input
        while (i < str.length
                && str[i] >= '0'
                && str[i] <= '9') {

            if (base > Integer.MAX_VALUE / 10
                    || (base == Integer.MAX_VALUE / 10
                    && str[i] - '0' > 7))
            {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base = 10 * base + (str[i++] - '0');
        }
        return base * sign;
    }


    public static void main(String[] args)
    {
        char str[] = "36".toCharArray();

        // Function call
        int val = myAtoi(str);
        System.out.printf("%d ", val);
    }
}
