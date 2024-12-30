import com.example.tinashe2.CredentialsManager

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ValidationTests {

    private lateinit var manager: CredentialsManager

    @Before
    fun setUp() {
        manager = CredentialsManager()
    }

    // Login Validation Tests
    @Test
    fun loginWithEmptyEmail_fails() {
        assertFalse(manager.login("", "password123"))
    }

    @Test
    fun loginWithInvalidEmailFormat_fails() {
        assertFalse(manager.login("invalidemail", "password123"))
    }

    @Test
    fun loginWithEmptyPassword_fails() {
        assertFalse(manager.login("test@domain.com", ""))
    }

    // Registration Validation Tests
    @Test
    fun registerWithEmptyEmail_fails() {
        assertFalse(manager.register("", "password123"))
    }

    @Test
    fun registerWithInvalidEmailFormat_fails() {
        assertFalse(manager.register("invalidemail", "password123"))
    }

    @Test
    fun registerWithEmptyPassword_fails() {
        assertFalse(manager.register("test@domain.com", ""))
    }

    @Test
    fun registerWithWeakPassword_fails() {
        assertFalse(manager.register("test@domain.com", "123")) // Assuming password must be at least 6 characters
    }
}
