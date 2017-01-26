package fr.lmsys.client.reporting;


/**
 * @author Y.ELMARIKY
 * @Since 10 janv. 2017 
 */
	public class RequestCorrelation {

	    public static final String CORRELATION_ID_HEADER = "correlationId";


	    private static final ThreadLocal<String> id = new ThreadLocal<String>();

	    public static String getId() {
	        return id.get();
	    }

	    public static void setId(String correlationId) {
	        id.set(correlationId);
	    }
}
