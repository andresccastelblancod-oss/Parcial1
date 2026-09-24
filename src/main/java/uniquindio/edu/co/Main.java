package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supermercado supermercado = new Supermercado("MarketPlus", "Calle Principal #10-20", "3001234567");

        int opcion = 0;

        do {
            System.out.println("\n========== MENÚ SUPERMERCADO MARKETPLUS ==========");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Producto");
            System.out.println("3. Registrar Compra");
            System.out.println("4. Ver Historial de Compras de un Cliente");
            System.out.println("5. Ver Ventas Totales por Fecha");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR CLIENTE ---");
                    System.out.print("Ingrese nombre completo: ");
                    String nombreCompleto = sc.nextLine().trim();

                    System.out.print("Ingrese documento: ");
                    String documento = sc.nextLine().trim();

                    System.out.print("Ingrese teléfono: ");
                    String telefono = sc.nextLine().trim();

                    System.out.print("Ingrese correo: ");
                    String correo = sc.nextLine().trim();

                    if (supermercado.verificarCliente(documento)) {
                        System.out.println("El cliente con este documento ya existe.");
                    } else {
                        Cliente nuevoCliente = new Cliente(nombreCompleto, documento, telefono, correo);
                        supermercado.registrarCliente(nuevoCliente);
                        System.out.println("Cliente registrado exitosamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");
                    System.out.print("Ingrese código del producto: ");
                    String codigoProducto = sc.nextLine().trim();

                    System.out.print("Ingrese nombre del producto: ");
                    String nombreProducto = sc.nextLine().trim();

                    System.out.print("Ingrese precio del producto: ");
                    double precioProducto = Double.parseDouble(sc.nextLine().trim());

                    System.out.print("Ingrese categoría (ALIMENTOS, BEBIDAS, ASEO, CUIDADO_PERSONAL): ");
                    String textoCategoria = sc.nextLine().trim().toUpperCase();
                    CategoriaProducto categoria = CategoriaProducto.valueOf(textoCategoria);

                    System.out.print("Ingrese cantidad disponible en stock: ");
                    int cantidadDisponible = Integer.parseInt(sc.nextLine().trim());

                    if (supermercado.verificarProducto(codigoProducto)) {
                        System.out.println("El producto con este código ya existe.");
                    } else {
                        Producto nuevoProducto = new Producto(codigoProducto, nombreProducto, categoria, precioProducto, cantidadDisponible);
                        supermercado.agregarProducto(nuevoProducto);
                        System.out.println("Producto registrado exitosamente.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- REGISTRAR NUEVA COMPRA ---");
                    System.out.print("Ingrese el documento del cliente: ");
                    String docClienteCompra = sc.nextLine().trim();

                    if (!supermercado.verificarCliente(docClienteCompra)) {
                        System.out.println("El cliente no está registrado. Realice el registro primero (Opción 1).");
                    } else {
                        System.out.print("Ingrese el código del producto a comprar: ");
                        String codProdCompra = sc.nextLine().trim();

                        if (!supermercado.verificarProducto(codProdCompra)) {
                            System.out.println("El producto no está registrado.");
                        } else {
                            System.out.print("Ingrese el código de la compra: ");
                            String codCompra = sc.nextLine().trim();

                            System.out.print("Ingrese método de pago (EFECTIVO, TARJETA, TRANSFERENCIA): ");
                            String textoMetodo = sc.nextLine().trim().toUpperCase();
                            MetodoDePago nuevoMetodoDePago = MetodoDePago.valueOf(textoMetodo);

                            System.out.print("Ingrese la cantidad a llevar: ");
                            int cantidad = Integer.parseInt(sc.nextLine().trim());

                            Cliente clienteEncontrado = supermercado.obtenerCliente(docClienteCompra);
                            Producto productoEncontrado = supermercado.obtenerProducto(codProdCompra);

                            if (productoEncontrado.validarDisponibilidad(cantidad)) {
                                Compra nuevaCompra = new Compra(codCompra, LocalDate.now(), nuevoMetodoDePago, clienteEncontrado, 0.0);
                                nuevaCompra.agregarDetalle(cantidad, productoEncontrado);
                                nuevaCompra.confirmarCompra();

                                clienteEncontrado.registrarCompra(nuevaCompra);
                                supermercado.registrarCompra(nuevaCompra);

                                System.out.println("¡Compra registrada con éxito! Total: $" + nuevaCompra.getValorTotal());
                            } else {
                                System.out.println("Stock insuficiente. Solo hay " + productoEncontrado.getCantidadDisponible() + " unidades disponibles.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- HISTORIAL DE COMPRAS DE UN CLIENTE ---");
                    System.out.print("Ingrese el documento del cliente: ");
                    String docHistorial = sc.nextLine().trim();

                    if (!supermercado.verificarCliente(docHistorial)) {
                        System.out.println("El cliente no está registrado.");
                    } else {
                        Cliente clienteHistorial = supermercado.obtenerCliente(docHistorial);
                        System.out.println("Historial para " + clienteHistorial.getNombreCompleto() + ":");
                        if (clienteHistorial.getHistorialCompras().isEmpty()) {
                            System.out.println("No registra compras aún.");
                        } else {
                            for (Compra comp : clienteHistorial.getHistorialCompras()) {
                                System.out.println(comp);
                            }
                            System.out.println("Total gastado: $" + clienteHistorial.calcularTotalGastado());
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- VENTAS TOTALES POR FECHA ---");
                    System.out.print("Ingrese la fecha (YYYY-MM-DD) o presione ENTER para la fecha de hoy: ");
                    String fechaTexto = sc.nextLine().trim();

                    LocalDate fechaConsulta;
                    if (fechaTexto.isEmpty()) {
                        fechaConsulta = LocalDate.now();
                    } else {
                        fechaConsulta = LocalDate.parse(fechaTexto);
                    }

                    double totalVentas = supermercado.obtenerVentasFechas(fechaConsulta);
                    System.out.println("Total de ventas para " + fechaConsulta + ": $" + totalVentas);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema MarketPlus");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}