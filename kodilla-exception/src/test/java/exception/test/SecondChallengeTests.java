package exception.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTests {

    @Test
    public void probablyIWillThrowException() {

        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5.00, 2.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 1.6))
        );
    }
}
