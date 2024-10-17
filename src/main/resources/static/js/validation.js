document
    .getElementById("signupForm")
    .addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting

        // Clear all previous error messages
        document
            .querySelectorAll(".error-message")
            .forEach((el) => (el.style.display = "none"));

        const username = document.getElementById("username").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        let valid = true;

        if (!username) {
            valid = false;
            document.getElementById("nameError").style.display = "block";
        }

        if (!validateEmail(email)) {
            valid = false;
            document.getElementById("emailError").style.display = "block";
        }

        if (!validatePassword(password)) {
            valid = false;
            document.getElementById("passwordError").style.display = "block";
        }

        if (valid) {
            alert("Form submitted successfully!");
            this.submit();
        }
    });

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function validatePhone(phone) {
    const re = /^\+?[1-9]\d{1,14}$/;
    return re.test(phone);
}

function validatePassword(password) {
    const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    return re.test(password);
}
