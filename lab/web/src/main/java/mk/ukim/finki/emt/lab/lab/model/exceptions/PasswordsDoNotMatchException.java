package mk.ukim.finki.emt.lab.lab.model.exceptions;



public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException(){
        super("Passwords do not match exception.");
    }
}
