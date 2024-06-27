package Fsec;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class Pinmail {
    private final String username = "yourmail@gmail.com"; //your mail id
    private final String password = "password"; //password
    private Map<String, String> otpStorage = new HashMap<String,String>();

    public void sendOTP(String to) throws MessagingException {
        if (otpStorage.containsKey(to)) {
            return;  // Don't send a new OTP if the email is already registered
        }
        
        Random ra = new Random();
        String otp = String.valueOf(ra.nextInt(9000) + 1000);  // Ensure OTP is 4 digits

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("PIN For Login");
        message.setText("PIN code = " + otp);
        Transport.send(message);

        otpStorage.put(to, otp);  // Store the OTP as the permanent PIN
    }

    public boolean verifyOTP(String email, String userOTP) {
        String storedOTP = otpStorage.get(email);
        return storedOTP != null && storedOTP.equals(userOTP);
    }

    public boolean isEmailRegistered(String email) {
        return otpStorage.containsKey(email);
    }
}
