package exception.io;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {

    @Test
    public void testReadFileWithName() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }

    /*
    @Test
    void whenFileDosentExistsReadFileShoudThrowsException() {
        //given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        //when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
        //
    }
 */

/*
    @Test
    void testReadFile() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }
}
*/
}