package co.edu.uco.treepruning.application.inputport;

public interface InputPort<T, R> {
	R execute(T data);
}
