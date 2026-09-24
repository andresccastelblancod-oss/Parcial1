package uniquindio.edu.co;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc= new Scanner(System.in);
        private List<Cliente> listaSupermercadoClientes;
        private List<Producto> listaSupermercadoProductos;
        private List<Compra> listaSupermercadoCompras;

        Supermercado supermercado=new Supermercado("Cra.13 #42-23", "Cra 13 #42-21", "321567982");


        int opcion;
            do {
                System.out.println("--- MENÚ PRINCIPAL ---");
                System.out.println("1. Registrar cliente");
                System.out.println("2. Registrar producto");
                System.out.println("3. Registrar compra");
                System.out.println("4. Consultar compras por cliente");
                System.out.println("5. Reporte de ventas diarias");
                System.out.println("6. Salir");
                System.out.print("Ingrese una opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); //

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del cliente");
                        String nombre=sc.nextLine();
                        System.out.println("Ingrese el documento");
                        int documento=sc.nextInt();
                        System.out.println("Ingrese el telefono");
                        String telefono=sc.nextLine();
                        System.out.println("Ingrese el correo");
                        String correo=sc.nextLine();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no valida.");
                }

            } while (opcion != 0);

        }
    }

