# Passenger
La clase Passenger representa a cada pasajero que participa en el vuelo hacia Marte, encargándose de almacenar y gestionar toda la información relevante sobre ellos. Esta información incluye datos personales como nombre, edad y género, además de detalles específicos para la misión, como el estado de salud, historial médico y preferencias durante el viaje. La clase también puede manejar el seguimiento del bienestar físico y psicológico del pasajero, crucial en una misión espacial de larga duración, asegurando que se puedan tomar medidas adecuadas en caso de cualquier eventualidad. Además, Passenger gestiona la asignación de recursos y servicios a bordo, como el acceso a alimentos, espacios de descanso y actividades recreativas, garantizando una experiencia confortable y segura. En este sentido, esta clase es fundamental para coordinar el cuidado individualizado y la logística relacionada con cada viajero, contribuyendo así al éxito y la seguridad de la misión interplanetaria hacia Marte.

## Atributos
- *Name*: Almacena el nombre completo del pasajero, permitiendo su identificación personal y formal dentro de la misión.

- *Document*: Representa el número de identificación oficial del pasajero (cédula, pasaporte u otro), usado para fines legales, administrativos y de control en el viaje.

- *Phone*: Guarda el número de contacto del pasajero, fundamental para establecer comunicación con familiares o con la base terrestre en caso de necesidad.

- *Age*: Registra la edad del pasajero, lo cual es esencial para evaluar condiciones físicas, psicológicas y médicas, asegurando que cumpla con los requisitos de la misión.

- *Nationality*: Indica la nacionalidad del pasajero, lo que permite gestionar la diversidad cultural a bordo, cumplir con normativas internacionales y organizar aspectos logísticos relacionados con cada país de origen.

## Relación de la clase Passenger con las demás clases
- *Destination*: Muchos pasajeros pueden compartir el mismo destino, ya que el destino existe aunque el pasajero no esté vinculado.  
  → Agregación (◇)

- *Flight*: Los pasajeros forman parte de un vuelo dentro del itinerario, pero el vuelo puede existir aunque un pasajero no esté asignado.  
  → Agregación (◇)

- *Itinerary*: Cada pasajero cuenta con un itinerario personalizado, que organiza escalas, actividades y horarios, pero el itinerario puede existir sin un pasajero en específico.  
  → Agregación (◇)

- *SpaceCrafts*: Varios pasajeros viajan en una misma nave espacial, pero la nave no depende de un pasajero en particular.  
  → Asociación (—)

- *CrewMember*: Los pasajeros están bajo el cuidado de varios tripulantes; la relación es de cooperación, no de dependencia.  
  → Asociación (—)

- *Reservation*: Un pasajero puede tener una o varias reservas, que vinculan su identidad con asientos y servicios.  
  → Asociación (—)

- *Ticket*: El pasajero obtiene un ticket como comprobante de viaje; este documento refleja la relación pasajero–reserva–vuelo.  
  → Asociación (—)

- *Payment*: Cada pasajero puede realizar pagos asociados a sus reservas o tickets, sin que el pago dependa directamente del pasajero.  
  → Asociación (—)
