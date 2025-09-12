package com.marsbooking.domain.reservation;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String date;
    private String status;
    private String seatClass;
    private String idReservation;
    private String asignedSeat;

    // Constructor
    public Reservation(String date, String status, String seatclass, String idReservation, String asignedSeat) {
        this.date = date;
        this.status = status;
        this.seatClass = seatclass;
        this.idReservation = idReservation;
        this.asignedSeat = asignedSeat;
    }

    public static Reservation crearDesdeInput(Scanner scanner) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDate startDate = LocalDate.of(2050, 1, 1);
        Random rand = new Random();
        String[] fechas = new String[5];
        int baseOffset = rand.nextInt(365 * 2);
        LocalDate baseDate = startDate.plusDays(baseOffset);

        for (int i = 0; i < 5; i++) {
            int monthsOffset = i == 0 ? 0 : (2 + rand.nextInt(2));
            baseDate = (i == 0) ? baseDate : baseDate.plusMonths(monthsOffset);
            int hour = 6 + rand.nextInt(17);
            int minute = rand.nextInt(60);
            String fechaHora = baseDate.atTime(hour, minute).format(formatter);
            fechas[i] = fechaHora;
        }

        System.out.println("Fechas y horas disponibles para reservar:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + fechas[i]);
        }

        String date = "";
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.print("Seleccione el número de la fecha y hora que desea reservar: ");
            String opcion = scanner.nextLine();
            try {
                int idx = Integer.parseInt(opcion) - 1;
                if (idx >= 0 && idx < 5) {
                    date = fechas[idx];
                    fechaValida = true;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }


        String[] estados = {"pago", "en proceso", "cancelado"};
        System.out.println("Opciones de estado de la reserva:");
        for (int i = 0; i < estados.length; i++) {
            System.out.println((i + 1) + ". " + estados[i]);
        }
        String status = "";
        boolean estadoValido = false;
        while (!estadoValido) {
            System.out.print("Seleccione el número del estado de la reserva: ");
            String opcionEstado = scanner.nextLine();
            try {
                int idx = Integer.parseInt(opcionEstado) - 1;
                if (idx >= 0 && idx < estados.length) {
                    status = estados[idx];
                    estadoValido = true;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }



        String[] clases = {"Turista", "Turista premiun", "Ejecutivo", "Primera clase", "VIP"};
        System.out.println("Opciones de clase de asiento:");
        for (int i = 0; i < clases.length; i++) {
            System.out.println((i + 1) + ". " + clases[i]);
        }
        String seatclass = "";
        boolean claseValida = false;
        int claseIdx = -1;
        while (!claseValida) {
            System.out.print("Seleccione el número de la clase de asiento: ");
            String opcionClase = scanner.nextLine();
            try {
                int idx = Integer.parseInt(opcionClase) - 1;
                if (idx >= 0 && idx < clases.length) {
                    seatclass = clases[idx];
                    claseIdx = idx;
                    claseValida = true;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }

        String[][] asientosPorClase = {
            {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"}, // Turista
            {"B1", "B2", "B3", "B4", "B5"}, // Turista premiun
            {"C1", "C2", "C3", "C4"}, // Ejecutivo
            {"D1", "D2", "D3"}, // Primera clase
            {"VIP1", "VIP2"} // VIP
        };
        String[] asientosDisponibles = asientosPorClase[claseIdx];
        System.out.println("Asientos disponibles para la clase seleccionada:");
        for (int i = 0; i < asientosDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + asientosDisponibles[i]);
        }
        String asignedSeat = "";
        boolean asientoValido = false;
        while (!asientoValido) {
            System.out.print("Seleccione el número del asiento: ");
            String opcionAsiento = scanner.nextLine();
            try {
                int idx = Integer.parseInt(opcionAsiento) - 1;
                if (idx >= 0 && idx < asientosDisponibles.length) {
                    asignedSeat = asientosDisponibles[idx];
                    asientoValido = true;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }

    String idReservation = String.valueOf(10000 + rand.nextInt(90000));
    System.out.println("ID de la reserva generado: " + idReservation);

    return new Reservation(date, status, seatclass, idReservation, asignedSeat);
    }

    public boolean modificarDesdeInput(Scanner scanner) {
        String resp = "";
        while (true) {
            System.out.print("\n¿Desea modificar el estado de la reserva? (s/n): ");
            resp = scanner.nextLine().trim().toLowerCase();
            if (resp.equals("s") || resp.equals("n")) {
                break;
            } else {
                System.out.println("Por favor, ingrese solo 's' para sí o 'n' para no.");
            }
        }
        if (resp.equals("s")) {
            String[] estados = {"pago", "en proceso", "cancelado"};
            System.out.println("Opciones de estado de la reserva:");
            for (int i = 0; i < estados.length; i++) {
                System.out.println((i + 1) + ". " + estados[i]);
            }
            String status = "";
            boolean estadoValido = false;
            while (!estadoValido) {
                System.out.print("Seleccione el número del nuevo estado: ");
                String opcionEstado = scanner.nextLine();
                try {
                    int idx = Integer.parseInt(opcionEstado) - 1;
                    if (idx >= 0 && idx < estados.length) {
                        status = estados[idx];
                        estadoValido = true;
                    } else {
                        System.out.println("Opción inválida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Intente de nuevo.");
                }
            }
            setStatus(status);
            if (status.equalsIgnoreCase("pago")) {
                System.out.println("El estado de su reserva ya está pago.");
            } else if (status.equalsIgnoreCase("en proceso")) {
                System.out.println("El estado de pago está en espera.");
            } else if (status.equalsIgnoreCase("cancelado")) {
                System.out.println("El estado de su reserva ha sido cancelado.");
                return false;
            }
        }

        while (true) {
            System.out.print("¿Desea modificar el asiento asignado? (s/n): ");
            resp = scanner.nextLine().trim().toLowerCase();
            if (resp.equals("s") || resp.equals("n")) {
                break;
            } else {
                System.out.println("Por favor, ingrese solo 's' para sí o 'n' para no.");
            }
        }
    if (resp.equals("s")) {
            String[] clases = {"Turista", "Turista premiun", "Ejecutivo", "Primera clase", "VIP"};
            String[][] asientosPorClase = {
                {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"}, // Turista
                {"B1", "B2", "B3", "B4", "B5"}, // Turista premiun
                {"C1", "C2", "C3", "C4"}, // Ejecutivo
                {"D1", "D2", "D3"}, // Primera clase
                {"VIP1", "VIP2"} // VIP
            };
            int claseIdx = 0;
            for (int i = 0; i < clases.length; i++) {
                if (clases[i].equalsIgnoreCase(this.seatClass)) {
                    claseIdx = i;
                    break;
                }
            }
            String[] asientosDisponibles = asientosPorClase[claseIdx];
            System.out.println("Asientos disponibles para la clase " + this.seatClass + ":");
            for (int i = 0; i < asientosDisponibles.length; i++) {
                System.out.println((i + 1) + ". " + asientosDisponibles[i]);
            }
            String asignedSeat = "";
            boolean asientoValido = false;
            while (!asientoValido) {
                System.out.print("Seleccione el número del nuevo asiento: ");
                String opcionAsiento = scanner.nextLine();
                try {
                    int idx = Integer.parseInt(opcionAsiento) - 1;
                    if (idx >= 0 && idx < asientosDisponibles.length) {
                        asignedSeat = asientosDisponibles[idx];
                        asientoValido = true;
                    } else {
                        System.out.println("Opción inválida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Intente de nuevo.");
                }
            }
            setAsignedSeat(asignedSeat);
        }
        return true;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getSeatclass() {
        return seatClass;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public String getAsignedSeat() {
        return asignedSeat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSeatclass(String seatclass) {
        this.seatClass = seatclass;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void setAsignedSeat(String asignedSeat) {
        this.asignedSeat = asignedSeat;
    }

    @Override
    public String toString() {
        return "Reservation:" +
                "date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", seatclass='" + seatClass + '\'' +
                ", idReservation='" + idReservation + '\'' +
                ", asignedSeat='" + asignedSeat + '/';
    }
}
