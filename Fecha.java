package fecha;

/**
 * Dentro de esta clase Fecha hay varias funciones, las cuales cada una tiene
 * una lavor. Esta clase nos proporciona todo tipo de datos sobre la fecha y la
 * fecha correcta.
 */
public class Fecha {
	public static final int DIEZ = 10;
	/**
	 * Nos guarda el valor del dia.
	 */
	private int diaFecha; // d�a
	/**
	 * Nos guarda el valor del mes.
	 */
	private int mesFecha; // mes
	/**
	 * Nos guarda el valor del año.
	 */
	private int anio; // a�o

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
		this.diaFecha = dia;
		this.mesFecha = mes;
		this.anio = anio;
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
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		
		anioCorrecto = anio > 0;
		mesCorrecto = mesFecha >= 1 && mesFecha <= 12;
		boolean diaMayor1 = diaFecha >= 1;
		switch (mesFecha) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && diaFecha <= 29;
			} else {
				diaCorrecto = diaMayor1 && diaFecha <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && diaFecha <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && diaFecha <= 31;
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
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	/**
	 * Esta función suma un dia a la fecha y si es distinto a fecha correcta le suma
	 * un dia o cambia de mes depende de la fecha introducida.
	 * 
	 * @return Nos devuelve la fecha de forma bonita con sus guiones, etc.
	 */
	public void nextDay() {
		diaFecha++;
		if (!fechaCorrecta()) {
			diaFecha = 1;
			mesFecha++;
			if (!fechaCorrecta()) {
				mesFecha = 1;
				anio++;
			}
		}
	}

	/**
	 * Esta función se encarga de devolvernos la fecha de forma bonita.
	 * Incrementando un 0 al principio si el número es menor de 10.
	 */
	public String toString() {
		String fecha;
		if (diaFecha < DIEZ && mesFecha < 10) {
			fecha = "0" + diaFecha + "-0" + mesFecha + "-" + anio;
		} else if (diaFecha < 10 && mesFecha >= 10) {
			fecha = "0" + diaFecha + "-" + mesFecha + "-" + anio;
		} else if (diaFecha >= 10 && mesFecha < 10) {
			fecha = diaFecha + "-0" + mesFecha + "-" + anio;
		} else {
			fecha = diaFecha + "-" + mesFecha + "-" + anio;
		}
	return fecha;
	}

}
