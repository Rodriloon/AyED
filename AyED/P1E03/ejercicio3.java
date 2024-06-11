package P1E03;

public class ejercicio3 {
	
	public static void main (String[] args){
		Estudiante [] vectorE = new Estudiante [2];
		Profesor [] vectorP = new Profesor [3];

		Estudiante est1 = new Estudiante("Sebita", "Alvarez", "sebita@gmail.com", "1a", "Pedro Hita 214");
		Estudiante est2 = new Estudiante("Nazareno", "Capurro", "naylag@gmail.com", "1b", "Canning");

		Profesor prof1 = new Profesor("Jorge", "Garma", "garma@gmail.com", "Ingenieria", "UTN");
		Profesor prof2 = new Profesor("Laura", "Fava", "lfava@info.unlp.edu.ar", "AYED", "UNLP");
		Profesor prof3 = new Profesor("Gonzalo", "Villareal", "gonza@gmail.com", "CADP", "UNLP");

		vectorE[0] = est1;
		vectorE[1] = est2;

		vectorP[0] = prof1;
		vectorP[1] = prof2;
		vectorP[2] = prof3;

		//imprimo los dos arrays
		int i;
		System.out.println("Datos de los estudiantes:");
		for(i = 0; i < 2; i++) {
			System.out.println(vectorE[i].tusDatos());
		}

		System.out.println("Datos de los profesores:");
		for(i = 0; i < 3; i++) {
			System.out.println(vectorP[i].tusDatos());
		}
	}
	
}
