public class DemoApplicationException extends RuntimeException {

    DemoApplicationException(Long id) {
        super("Could not find employee " + id);
    }
}