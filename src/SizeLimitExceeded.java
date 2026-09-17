public class SizeLimitExceeded extends Exception{
    SizeLimitExceeded(){
        super();
    }

    SizeLimitExceeded(String message){
        super(message);
    }
}
