package uniquindio.edu.co;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc= new Scanner(System.in);


        Supermercado supermercado=new Supermercado("Cra.13 #42-23", "Cra 13 #42-21", "321567982");


        int opcion;

        do {
            System.out.println("========== MENÚ SUPERMERCADO MARKETPLUS ==========");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Registrar nuevo producto en inventario");
            System.out.println("3. Realizar y registrar una compra");
            System.out.println("4. Consultar compras de un cliente");
            System.out.println("5. Generar reporte de ventas por fecha");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del cliente");
                        String nombreCliente=sc.nextLine();
                        System.out.println("Ingrese el documento");
                        String documento=sc.nextLine();
                        System.out.println("Ingrese el telefono");
                        String telefonoCliente=sc.nextLine();
                        System.out.println("Ingrese el correo");
                        String correo=sc.nextLine();
                        Cliente nuevoCliente = new Cliente(nombreCliente, documento, telefonoCliente, correo);
                        supermercado.registrarCliente(nuevoCliente);
                        System.out.println("Cliente registrado");
                        break;
                        case 2:
                        System.out.print("Ingrese el código del producto: ");
                        String codProducto = sc.nextLine();
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreProd = sc.nextLine();
                        System.out.print("Ingrese la categoría (ALIMENTOS, BEBIDAS, ASEO, CUIDADO_PERSONAL): ");
                        String textoCategoria = sc.nextLine().toUpperCase();
                        CategoriaProducto categoria = CategoriaProducto.valueOf(textoCategoria);
                        System.out.print("Ingrese el precio unitario: ");
                        double precioUnitario = sc.nextDouble();
                        System.out.print("Ingrese la cantidad disponible (stock): ");
                        int cantidadDisponible = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer
                        Producto nuevoProducto = new Producto(codProducto, nombreProd, categoria, precioUnitario, cantidadDisponible);
                        supermercado.agregarProducto(nuevoProducto);

                        System.out.println("Producto agregado");
                        break;
                    case 3:
                        System.out.print("Ingrese el documento del cliente que realiza la compra: ");
                        String docClienteCompra = sc.nextLine();

                        if (!supermercado.verificarCliente(docClienteCompra)) {
                            System.out.println("El cliente no esta registrado, realize registro (Opcion 1)");
                        } else {
                            System.out.print("Ingrese el codigo del producto: ");
                            String codigoProducto = sc.nextLine();

                            if (!supermercado.verificarProducto(codigoProducto)) {
                                System.out.println("Producto no registrado");
                            } else {
                                System.out.print("Ingrese el codigo de compra: ");
                                String codCompra = sc.nextLine();

                                System.out.print("Ingrese el método de pago (EFECTIVO, TARJETA, TRANSFERENCIA): ");
                                String textoMetodo = sc.nextLine().toUpperCase();
                                MetodoDePago nuevoMetodoDePago = MetodoDePago.valueOf(textoMetodo);

                                System.out.print("Ingrese la cantidad a llevar: ");
                                int cantidad = sc.nextInt();
                                sc.nextLine();

                                for (Cliente cliente : supermercado.getListaSupermercadoClientes()) {
                                    if (cliente.getDocumento().equals(docClienteCompra)) {


                                        Compra nuevaCompra = new Compra(codCompra, LocalDate.now(),nuevoMetodoDePago,cliente);


                                        for (Producto producto: supermercado.getListaSupermercadoProductos()) {
                                            if (producto.getCodigoProducto().equals(codigoProducto)) {
                                                if (cantidad <= producto.getCantidadDisponible()) {
                                                    nuevaCompra.agregarDetalle(producto, cantidad);
                                                    nuevaCompra.confirmarCompra();


                                                    cliente.registrarCompra(nuevaCompra);
                                                    supermercado.registrarCompra(nuevaCompra);

                                                    System.out.println("¡Compra registrada con éxito! Total: $" + nuevaCompra.getValorTotal());
                                                } else {
                                                    System.out.println("Stock insuficiente. Solo hay " + producto.getCantidadDisponible() + " unidades disponibles.");
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 4:


                    case 5:



                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no valida.");
                }

            } while (opcion != 0);

        }
    }

