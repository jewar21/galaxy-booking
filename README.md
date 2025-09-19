📌 Clase Itinerary

La clase Itinerary es la encargada de organizar y gestionar gran parte de la información del viaje a Marte.

🔹 Atributos

date → Muestra la fecha del vuelo.

scales → Guarda las escalas que se van a realizar durante el vuelo.

activitiesMars → Muestra las actividades que se van a realizar en Marte.

timeTravel → Representa el tiempo de duración del vuelo.

necessaryResources → Indica los recursos necesarios que se van a usar en el viaje.

🔹 Relaciones con otras clases

Destination → Composición (●)
El itinerario depende de un destino. Si Itinerary deja de existir, también desaparece el Destination.

Flight → Agregación (◇)
Un itinerario está formado por uno o varios vuelos. Si Itinerary desaparece, los vuelos pueden seguir existiendo.

Spacecraft → Asociación (—)
El itinerario se realiza con una nave, pero la nave puede usarse en otros itinerarios.

Crew → Agregación (◇)
El itinerario necesita una tripulación, aunque la tripulación puede existir sin ese itinerario.

Passenger → Agregación (◇)
Los pasajeros forman parte del itinerario, pero pueden existir sin estar en uno.

Reservation → Asociación (—)
Relación a través de atributos como la fecha.

Ticket → Asociación (—)
Relación indirecta por compartir datos del viaje.

Payment → Asociación (—)
Relación indirecta porque los pagos están ligados a reservas o tickets.