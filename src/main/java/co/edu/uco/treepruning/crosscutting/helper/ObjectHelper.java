package co.edu.uco.treepruning.crosscutting.helper;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;

public class ObjectHelper {
	private ObjectHelper() {
		
	}
	
	public static <O> boolean isNull(O object) {
		return object == null;
	}
	
	public static <O> O getDefault (final O object,final O defaultValue) {
		
		return isNull (object) ? defaultValue : object;
	}
		
}
