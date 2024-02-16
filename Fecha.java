package fecha;

/**
 * Dentro de esta clase Fecha hay varias funciones, las cuales cada una tiene
 * una lavor. Esta clase nos proporciona todo tipo de datos sobre la fecha y la
 * fecha correcta.
 */
public class Fecha {
	/**
	 * Nos guarda el valor del dia.
	 */
	private int d; // d�a
	/**
	 * Nos guarda el valor del mes.
	 */
	private int m; // mes
	/**
	 * Nos guarda el valor del año.
	 */
	private int a; // a�o

	/**
	 * Esta funcion fecha esta vacia y no tiene ningun parametro de entrada.
	 */
	public Fecha() {

	}

	/**
	 * Esta función nos proporciona una fecha con su día, mes y año.
	 * 
	 * @param dia  valor de dia introducido por parametro
	 * @param mes  valor de mes introducido por parametro
	 * @param anio valor de año introducido por parametro
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Esta funcion nos comprueba que la fecha es correcta, teniendo en cuenta sie
	 * el año es bisiesto, los dias, etc.
	 * 
	 * 
	 * @param diaCorrecto  Nos guardan el valor del dia correcto
	 * @param mesCorrecto  Nos guardan el valor del mes correcto
	 * @param anioCorrecto Nos guardan el valor del año correcto
	 * @return Nos devuelve el día, el mes y el año correcto.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Este metodo nos comprueba si el año introducido es bisiesto o no.
	 * 
	 * @return Nos devuelve true o false, dependiendo si cumple la función es
	 *         bisiesto o no.
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Esta función suma un dia a la fecha y si es distinto a fecha correcta le suma
	 * un dia o cambia de mes depende de la fecha introducida.
	 * 
	 * @return Nos devuelve la fecha de forma bonita con sus guiones, etc.
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Esta función se encarga de devolvernos la fecha de forma bonita.
	 * Incrementando un 0 al principio si el número es menor de 10.
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
