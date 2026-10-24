import java.util.Scanner;// Main driver class for palindrome verification
public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Packet Payload: ");
        String payload = input.nextLine();
        TransactionStack stack =
                new TransactionStack(payload.length());
        RequestQueue queue =
                new RequestQueue(payload.length());
        for (int i = 0; i < payload.length(); i++) {
            char ch = payload.charAt(i);
            stack.push(ch);
            queue.enqueue(ch);
        }
        boolean symmetric = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.dequeue();
            if (stackChar != queueChar) {
                symmetric = false;
                break;
            }
        }
        System.out.println("\nVerification Result");
        if (symmetric)
            System.out.println("Packet is Symmetric (Palindrome)");
        else
            System.out.println("Packet is NOT Symmetric");
    }
}
