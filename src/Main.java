import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        BuscaMoneda buscar = new BuscaMoneda();
        String menu = """
                Bienvenido al conversor de monedas, elija una opcion para continuar:
                1) MXN a USD
                2) USD a MXN
                3) USD a EUR
                4) EUR a USD
                5) EUR a MXN
                6) MXN a EUR
                7) Salir.
                """;
        Moneda moneda = null;
        float tasaConversion = 0;
        int opcion = 0;
        String divisa = "";

        while (opcion != 7) {
            System.out.println(menu);
            opcion = lectura.nextInt();
                if (opcion == 7){
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    System.exit(0);
                }else {
                    System.out.println("Ingrese el monto a convertir: ");
                    float monto = lectura.nextFloat();

                    switch (opcion) {
                        case 1 -> {
                            divisa = "MXN";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("USD");
                            mostrarResultado(monto, divisa, tasaConversion, "USD");
                        }
                        case 2 -> {
                            divisa = "USD";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("MXN");
                            mostrarResultado(monto, divisa, tasaConversion, "MXN");
                        }
                        case 3 -> {
                            divisa = "USD";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("EUR");
                            mostrarResultado(monto, divisa, tasaConversion, "EUR");
                        }
                        case 4 -> {
                            divisa = "EUR";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("USD");
                            mostrarResultado(monto, divisa, tasaConversion, "USD");
                        }
                        case 5 -> {
                            divisa = "EUR";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("MXN");
                            mostrarResultado(monto, divisa, tasaConversion, "MXN");
                        }
                        case 6 -> {
                            divisa = "MXN";
                            moneda = buscar.buscaMoneda(divisa);
                            tasaConversion = moneda.conversion_rates().get("EUR");
                            mostrarResultado(monto, divisa, tasaConversion, "EUR");
                        }
                        default -> {
                            System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        }
                    }
                }
        }
    }

    private static void mostrarResultado(float monto, String divisa,
                                         float tasaConversion, String divisaDestino) {
        float resultado = monto * tasaConversion;
        System.out.printf("$%.2f %s son $%.2f %s%n", monto, divisa, resultado, divisaDestino);
    }

}
