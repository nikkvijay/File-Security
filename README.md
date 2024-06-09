# File-Security
Secure File Locker

Description:

Welcome to the Secure File Locker application! This application allows users to securely lock and unlock files using a PIN-based authentication system. Here's how it works:

Login with PIN:
-Upon opening the application, users are prompted to enter their PIN to access the file locker.
-If the entered PIN matches the permanent PIN received via email during registration, the user gains access to the file locker.
-If the PIN is incorrect, the user is prompted to try again.

Registration:
-If users don't have a PIN or haven't registered yet, they can click on the "Registration" button.
-This opens the registration frame where users can enter their email address.
-After entering the email, a PIN is generated and sent to the provided email address.
-Once the PIN is received, users can close the registration frame and proceed to the login screen.

Lock and Unlock Files:
-After successfully logging in, users are presented with a screen containing "Lock" and "Unlock" buttons.
-To lock a file, users can click on the "Lock" button and select the file they want to secure.
-To unlock a file, users need to enter the PIN received via email during registration.
-Once the correct PIN is entered, the file is unlocked and accessible.

Permanent PIN:
-The PIN received via email during registration serves as the user's permanent PIN.
-This PIN is used for logging in and unlocking files.

-Security Measures:
-All PINs are securely generated and stored.
-Email verification is used during registration to ensure a valid email address.
-PINs are sent securely via email to the registered email address.
