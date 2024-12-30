import com.example.tinashe2.CredentialsManager

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CredentialsManagerTest {

    private lateinit var manager: CredentialsManager

    @Before
    fun setUp() {
        manager = CredentialsManager()
    }

    // Login Functionality Tests
    @Test
    fun loginWithValidCredentials_success() {
        manager.register("test@domain.com", "password123")
        assertTrue(manager.login("test@domain.com", "password123"))
    }

    @Test
    fun loginWithInvalidPassword_fails() {
        manager.register("test@domain.com", "password123")
        assertFalse(manager.login("test@domain.com", "wrongPassword"))
    }

    @Test
    fun loginWithUnregisteredEmail_fails() {
        assertFalse(manager.login("unregistered@domain.com", "password123"))
    }

    @Test
    fun loginWithEmptyEmail_fails() {
        assertFalse(manager.login("", "password123"))
    }

    @Test
    fun loginWithEmptyPassword_fails() {
        assertFalse(manager.login("test@domain.com", ""))
    }

    @Test
    fun loginWithInvalidEmailFormat_fails() {
        assertFalse(manager.login("invalidemail", "password123"))
    }

    // Registration Functionality Tests
    @Test
    fun registerNewUser_success() {
        assertTrue(manager.register("newuser@domain.com", "password123"))
    }

    @Test
    fun registerDuplicateUser_fails() {
        manager.register("test@domain.com", "password123")
        assertFalse(manager.register("test@domain.com", "newPassword"))
    }

    @Test
    fun registerWithEmptyEmail_fails() {
        assertFalse(manager.register("", "password123"))
    }

    @Test
    fun registerWithInvalidEmailFormat_fails() {
        assertFalse(manager.register("invalidemail", "password123"))
    }

    @Test
    fun registerWithWeakPassword_fails() {
        assertFalse(manager.register("test@domain.com", "123")) // Assuming password must be at least 6 characters
    }

    @Test
    fun registerWithEmptyPassword_fails() {
        assertFalse(manager.register("test@domain.com", ""))
    }
}
