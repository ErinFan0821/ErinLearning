/**
 * Created by techops on 10/20/14.
 */
public class CleanCode {
    public void correctUsingCondition(boolean condition) {
        if (condition) {
            SendMsg("000", "Process Success", 1);
        } else {
            SendMsg("000", "Process Failure", 1);
        }
    }

    public void SendMsg(String number, String info, int result) {
        System.out.println(info);
    }
}
