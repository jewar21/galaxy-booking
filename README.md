
# CrewMember

Valiendo monda desde tiempos inmemoriables

La clase Crew está pensada para representar al personal de la tripulación dentro del codigo. 
crew member hace referencia a todo lo relacionado con los miembros y sus atributos los cuales se extienden desde el nombre hasta los años de servicio de la tribulacion.

- id → Identificador único del tripulante.
- name → Nombre del tripulante.
- role → Rol que cumple (ejemplo: piloto, ingeniero, médico, etc.).
- rank → Rango jerárquico (ejemplo: capitán, teniente, etc.).
- experienceYears → Años de experiencia.
- onDuty → Si está de servicio o no en ese momento.

# Atributos de crewMember

## private String id;
Identificador único del miembro de la tripulación.
Sirve para diferenciar a cada persona, como una “cédula” o “ID” dentro del sistema.

## private String name;
Nombre del tripulante.
Permite identificarlo de forma más humana (ej: “John Carter”).

## private String role;
Rol que cumple dentro de la tripulación.
Indica la función principal del tripulante.

## private String rank;
Rango jerárquico del tripulante.
Define su posición en la cadena de mando.

## private int experienceYears;
Cantidad de años de experiencia que tiene el tripulante.
Sirve como indicador de nivel de habilidad y trayectoria.

## private boolean onDuty;
Estado del tripulante:
true → Está actualmente en servicio (activo en la misión).
false → No está en servicio (descansando o fuera de turno).



# Relaciones de CrewMember con otras clases

las ramas con las cuales tenemos relacion es:
	
- Passanger es una relacion de asociacion 
- Spacecraft es una relacion de asociacion
- Fligth es una relacion de asociacion
