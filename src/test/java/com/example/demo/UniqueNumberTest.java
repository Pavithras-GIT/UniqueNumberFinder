package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniqueNumberTest {

     UniqueNumberService service = new UniqueNumberService();
     Controller controller = new Controller(service);



   @Test
    public void given2Entries() throws InvalidEntriesException {
        int entries =2;
        int[] array = {1721,979,366,299,675,1456};
        UniqueNumberRequest request = new UniqueNumberRequest(array, 2020);
        assertThat(controller.getUniqueNumber(entries, request).getStatusCode()).isEqualTo(HttpStatus.OK);
       assertThat(controller.getUniqueNumber(entries, request).getBody()).isEqualTo(514579);
   }

    @Test
    public void given3Entries() throws InvalidEntriesException {
        int entries =3;
        int[] array = {1721,979,366,299,675,1456};
        UniqueNumberRequest request = new UniqueNumberRequest(array, 2020);
        assertThat(controller.getUniqueNumber(entries, request).getBody()).isEqualTo(241861950);
    }

    @Test
    public void given3EntriesNoSumMatches() throws InvalidEntriesException {
        int entries =3;
        int[] array = {1728,978,366,290,600,145};
        UniqueNumberRequest request = new UniqueNumberRequest(array, 2020);
        assertThat(controller.getUniqueNumber(entries, request).getBody()).isZero();
    }
    @Test
    public void given2EntriesNoSumMatches() throws InvalidEntriesException {
        int entries =2;
        int[] array = {1728,978,366,290,600,145};
        UniqueNumberRequest request = new UniqueNumberRequest(array, 2020);
        assertThat(controller.getUniqueNumber(entries, request).getBody()).isZero();
    }


   @Test
    public void given4Entries() {
        int entries =4;
        int[] array = {1721,979,366,299,675,1456};
        UniqueNumberRequest request = new UniqueNumberRequest(array, 2020);
        Throwable exception = assertThrows(InvalidEntriesException.class, () ->   controller.getUniqueNumber(entries, request));
        assertEquals("Entries can only be either 2 or 3", exception.getMessage());
    }
}
