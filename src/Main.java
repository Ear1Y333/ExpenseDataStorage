public class Main {
    public static void main(String[] args) {
        ExecuteRequest executeRequest = new ExecuteRequest(new SQLConnection().getConnection());
        executeRequest.getValues();
        executeRequest.insertValues(1,4,23,4, "1978-2-12");
    }
}

