# galaxy-booking

Proyecto educativo en Java para practicar POO con encapsulación construyendo un sistema de reservas turísticas al espacio.
1 .DESCRIPCION DE LA CLASE SPACECRAFT:
	La clase SPACECRAFT representa a la nave espacial que realiza los viajes hacia los destinos por ejemplo (MARTE).
	Esta se encarga de almacenar la informacion técnica de la nave y de relacionarse con los elementos clave del sistema, como tripulación, pasajeros, vuelos y reservas.

2.ATRIBUTOS DE SPACECRAFT :
	model : String -> Modelo de la nave (ejemplo: Falcon X).

	fuelType : String -> Tipo de combustible que usa (ejemplo: Hidrógeno líquido).

	maxSpeed : int -> Velocidad máxima de la nave.

	capacity : int -> Cantidad de pasajeros que puede transportar.

	status : String -> Estado actual de la nave (Disponible, En vuelo, Mantenimiento).

3.RELACIONES 
	
	Crew (tripulación) → Composición 
	La nave tiene una tripulación asignada. Si la nave desaparece, esa asignación deja de tener sentido.

	Passenger (pasajero) → Agregación 
	Los pasajeros se asignan a un vuelo en una nave, pero pueden existir en el sistema aunque no estén abordo en ese momento.

	Flight (vuelo) → Composición 
	Un vuelo está directamente ligado a una nave. Sin la nave, ese vuelo no puede existir.

	Destination (destino) → Asociación
	El vuelo de la nave se dirige a un destino específico, pero el destino existe aunque no haya vuelos.

	Reservation (reserva) → Asociación
	La reserva conecta a un pasajero con un vuelo en una nave.

	Itinerary (itinerario) → Asociación
	Define el plan de viaje de los pasajeros dentro de un vuelo de la nave.