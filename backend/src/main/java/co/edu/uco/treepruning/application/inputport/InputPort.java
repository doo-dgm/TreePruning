package co.edu.uco.treepruning.application.inputport;

public interface InputPort<D, R> {
    R execute(D data);
}
