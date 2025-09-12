package com.marsbooking.domain.payment;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Clase para gastos extras del vuelo
class GastosExtra {
    private String nombre;
    private int precio;
    
    public GastosExtra(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPrecio() {
        return precio;
    }
    
    public void mostrarGasto() {
        System.out.println("- " + nombre + ": $" + precio);
    }
}

// Clase mejorada para el metodo de pago
class MetodoPago {
    private String tipo;
    private int numero;
    private String nombre;
    private String email; // Para PayPal y transferencias
    private String banco; // Para transferencias bancarias
    
    // Constructor para tarjetas de crédito/débito
    public MetodoPago(String tipo, int numero, String nombre) {
        this.tipo = tipo;
        this.numero = numero;
        this.nombre = nombre;

        
    }

    // Constructor para criptomonedas
    public MetodoPago(String tipo, int numero) {
        this.tipo = tipo;
        this.numero = numero;
        this.nombre = "Usuario Cripto";
    }
    
    // Constructor para PayPal
    public MetodoPago(String tipo, String email) {
        this.tipo = tipo;
        this.email = email;
        this.nombre = "Usuario PayPal";
    }
    
    // Constructor para transferencia bancaria
    public MetodoPago(String tipo, int numero, String nombre, String banco) {
        this.tipo = tipo;
        this.numero = numero;
        this.nombre = nombre;
        this.banco = banco;
    }
    
    // Constructor para efectivo
     public MetodoPago(String tipo) {
        this.tipo = tipo;
        this.nombre = "Pago en efectivo";
    }

    
    public String getTipo() {
        return tipo;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public void mostrarMetodo() {
        System.out.println("Metodo de pago: " + tipo);
        
        switch(tipo.toLowerCase()) {
            case "visa":
            case "mastercard":
            case "american express":
                System.out.println("Numero: **** " + numero);
                System.out.println("Titular: " + nombre);
                break;
            case "paypal":
                System.out.println("Email: " + email.substring(0, 3) + "***@" + 
                                 email.substring(email.indexOf("@")+1));
                break;
            case "transferencia bancaria":
                System.out.println("Banco: " + banco);
                System.out.println("Cuenta: **** " + numero);
                System.out.println("Titular: " + nombre);
                break;
            case "bitcoin":
                System.out.println("Wallet: " + numero);
                break;
            case "ethereum":
                System.out.println("Wallet: " + numero);
                break;
            case "efectivo":
                System.out.println("Pago en efectivo en oficinas Galaxy Airlines");
                break;
        }
    }
}

// Clase para el codigo del vuelo
class CodigoPago {
    private String codigo;
    private String planeta;
    
    public CodigoPago(String planeta) {
        this.planeta = planeta;
        this.codigo = generarCodigo();
    }
    
    private String generarCodigo() {
        int num = (int)(Math.random() * 10000);
        return "ESP" + num;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getPlaneta() {
        return planeta;
    }
    
    public void mostrarCodigo() {
        System.out.println("Codigo de vuelo: " + codigo);
        System.out.println("Destino: " + planeta);
    }
}

// Clase para el estado del pago
class Estado {
    private String estadoActual;
    
    public Estado() {
        this.estadoActual = "Pendiente";
    }
    
    public void cambiarEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }
    
    public String getEstado() {
        return estadoActual;
    }
    
    public void mostrarEstado() {
        System.out.println("Estado del pago: " + estadoActual);
    }
}

// Nueva clase TotalPay para imprimir tickets
class TotalPay {
    private PagoVueloEspacial pago;
    
    public TotalPay(PagoVueloEspacial pago) {
        this.pago = pago;
    }
    
    public void imprimirTicket() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            GALAXY AIRLINES TICKET");
        System.out.println("=".repeat(50));
        System.out.println("Fecha de emision: " + ahora.format(formato));
        System.out.println("Codigo de vuelo: " + pago.getCodigoPago().getCodigo());
        System.out.println();
        System.out.println("PASAJERO: " + pago.getPasajero().toUpperCase());
        System.out.println("DESTINO: " + pago.getPlaneta().toUpperCase());
        System.out.println();
        System.out.println("DETALLES DEL VIAJE:");
        System.out.println("-".repeat(30));
        System.out.println("Precio base: $" + pago.getPrecioBase());
        
        if (!pago.getGastos().isEmpty()) {
            System.out.println("Servicios adicionales:");
            for (GastosExtra gasto : pago.getGastos()) {
                System.out.printf("  %-20s $%d%n", gasto.getNombre(), gasto.getPrecio());
            }
        }
        
        System.out.println("-".repeat(30));
        System.out.println("TOTAL PAGADO: $" + pago.getTotal());
        System.out.println();
        System.out.println("METODO DE PAGO:");
        pago.getMetodoPago().mostrarMetodo();
        System.out.println();
        System.out.println("ESTADO: " + pago.getEstado().getEstado());
        System.out.println();
        System.out.println("¡Gracias por elegir Galaxy Airlines!");
        System.out.println("Buen viaje a " + pago.getPlaneta() + "! 🚀");
        System.out.println("=".repeat(50));
    }
}

// Clase principal del pago
class PagoVueloEspacial {
    private String pasajero;
    private String planeta;
    private int precioBase;
    private int total;
    private ArrayList<GastosExtra> gastos;
    private MetodoPago metodoPago;
    private CodigoPago codigoPago;
    private Estado estado;
    private TotalPay totalPay;
    
    public PagoVueloEspacial(String pasajero, String planeta, int precioBase) {
        this.pasajero = pasajero;
        this.planeta = planeta;
        this.precioBase = precioBase;
        this.total = precioBase;
        this.gastos = new ArrayList<GastosExtra>();
        this.codigoPago = new CodigoPago(planeta);
        this.estado = new Estado();
        this.totalPay = new TotalPay(this);
    }
    
    public void agregarGasto(GastosExtra gasto) {
        gastos.add(gasto);
        total = total + gasto.getPrecio();
    }
    
    public void asignarMetodoPago(MetodoPago metodo) {
        this.metodoPago = metodo;
    }
    
    public void procesarPago() {
        if (metodoPago == null) {
            System.out.println("Error: No hay metodo de pago");
            return;
        }
        
        estado.cambiarEstado("Procesando");
        System.out.println("Procesando pago...");
        
        // Simular procesamiento
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        estado.cambiarEstado("Completado");
        System.out.println("¡Pago exitoso!");
    }
    
    public void imprimirTicket() {
        totalPay.imprimirTicket();
    }
    
    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN DEL VIAJE ESPACIAL ===");
        System.out.println("Pasajero: " + pasajero);
        System.out.println("Destino: " + planeta);
        System.out.println("Precio base: $" + precioBase);
        
        if (!gastos.isEmpty()) {
            System.out.println("\nGastos adicionales:");
            for (GastosExtra gasto : gastos) {
                gasto.mostrarGasto();
            }
        }
        
        System.out.println("\nTOTAL: $" + total);
        System.out.println();
        codigoPago.mostrarCodigo();
        System.out.println();
        
        if (metodoPago != null) {
            metodoPago.mostrarMetodo();
        }
        
        System.out.println();
        estado.mostrarEstado();
    }
    
    // Métodos getter para TotalPay
    public String getPasajero() { return pasajero; }
    public String getPlaneta() { return planeta; }
    public int getPrecioBase() { return precioBase; }
    public int getTotal() { return total; }
    public ArrayList<GastosExtra> getGastos() { return gastos; }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public CodigoPago getCodigoPago() { return codigoPago; }
    public Estado getEstado() { return estado; }
}

// Clase principal para probar el sistema
public class AerolineaEspacial {
    
    public static MetodoPago crearMetodoPago(Scanner scanner) {
        System.out.println("\n=== METODOS DE PAGO DISPONIBLES ===");
        System.out.println("1. Visa");
        System.out.println("2. MasterCard");
        System.out.println("3. American Express");
        System.out.println("4. PayPal");
        System.out.println("5. Transferencia Bancaria");
        System.out.println("6. Bitcoin");
        System.out.println("7. Ethereum");
        System.out.println("8. Efectivo");
        System.out.print("Selecciona tu método de pago (1-8): ");
        
        int opcionPago = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch(opcionPago) {
            case 1:
                return crearTarjeta(scanner, "Visa");
            case 2:
                return crearTarjeta(scanner, "MasterCard");
            case 3:
                return crearTarjeta(scanner, "American Express");
            case 4:
                return crearPayPal(scanner);
            case 5:
                return crearTransferencia(scanner);
            case 6:
                return crearCripto(scanner, "Bitcoin");
            case 7:
                return crearCripto(scanner, "Ethereum");
            case 8:
                return new MetodoPago("Efectivo");
            default:
                return crearTarjeta(scanner, "Visa");
        }
    }
    
    private static MetodoPago crearTarjeta(Scanner scanner, String tipo) {
        System.out.print("Numero de tarjeta: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre en la tarjeta: ");
        String nombre = scanner.nextLine();
        return new MetodoPago(tipo, numero, nombre);
    }
    
    private static MetodoPago crearPayPal(Scanner scanner) {
        System.out.print("Email de PayPal: ");
        String email = scanner.nextLine();
        return new MetodoPago("PayPal", email);
    }
    
    private static MetodoPago crearTransferencia(Scanner scanner) {
        System.out.print("Nombre del banco: ");
        String banco = scanner.nextLine();
        System.out.print("Numero de cuenta: ");
        int cuenta = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre del titular: ");
        String titular = scanner.nextLine();
        return new MetodoPago("Transferencia Bancaria", cuenta, titular, banco);
    }
    
    private static MetodoPago crearCripto(Scanner scanner, String tipo) {
        System.out.print("Direccion de wallet " + tipo + ": ");
        String wallet = scanner.nextLine();
        return new MetodoPago(tipo, wallet);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BIENVENIDO A GALAXY AIRLINES ===");
        System.out.println("Vuelos a cualquier planeta del sistema solar!");
        
        // Pedir datos del pasajero
        System.out.print("Nombre del pasajero: ");
        String nombre = scanner.nextLine();
        
        // Elegir planeta
        System.out.println("\nPlanetas disponibles:");
        System.out.println("1. Marte - $5000");
        System.out.println("2. Jupiter - $8000");
        System.out.println("3. Saturno - $12000");
        System.out.println("4. Venus - $4000");
        System.out.print("Elije tu destino (1-4): ");
        int opcion = scanner.nextInt();
        
        String planeta = "";
        int precio = 0;
        
        switch(opcion) {
            case 1:
                planeta = "Marte";
                precio = 5000;
                break;
            case 2:
                planeta = "Jupiter";
                precio = 8000;
                break;
            case 3:
                planeta = "Saturno";
                precio = 12000;
                break;
            case 4:
                planeta = "Venus";
                precio = 4000;
                break;
            default:
                planeta = "Marte";
                precio = 5000;
        }
        
        // Crear el pago
        PagoVueloEspacial pago = new PagoVueloEspacial(nombre, planeta, precio);
        
        // Agregar gastos extras
        pago.agregarGasto(new GastosExtra("Traje espacial", 500));
        pago.agregarGasto(new GastosExtra("Seguro de viaje", 300));
        pago.agregarGasto(new GastosExtra("Comida espacial", 200));
        
        // Crear metodo de pago
        MetodoPago metodo = crearMetodoPago(scanner);
        pago.asignarMetodoPago(metodo);
        
        // Mostrar resumen
        pago.mostrarResumen();
        
        // Procesar pago
        System.out.print("\n¿Confirmar pago? (s/n): ");
        String confirma = scanner.nextLine();
        
        if (confirma.equalsIgnoreCase("s")) {
            pago.procesarPago();
            System.out.println("\n¡Buen viaje a " + planeta + "! ");
            
            // Imprimir ticket
            System.out.println("\nGenerando tu ticket...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pago.imprimirTicket();
        } else {
            System.out.println("Pago cancelado");
        }
        
        scanner.close();
    }
}