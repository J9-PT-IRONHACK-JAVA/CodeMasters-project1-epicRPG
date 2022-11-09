package com.ironhack;

public class EpicUtils {

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            else
            {
                System.out.print("\033[H\033[2J");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public static void loadingBar() throws InterruptedException {
        String loading = "Loading...";
        String bar = "[";
        int percentage = 0;
        for (int i = 0; i < 21; i++) {
            clearConsole();
            System.out.println(loading);
            System.out.println(percentage + "%");
            percentage += 5;
            System.out.print(bar + "|");
            bar += "|";
            Thread.sleep(150);
        }

        System.out.println("]");
    }
}
