package com.example.demo;

import org.springframework.stereotype.Service;


@Service
public class UniqueNumberService{

    public long findUniqueNumber(int entries, int[] array, int sum) throws InvalidEntriesException {
        long product = 0;
            for (int i = 0; i < array.length - 2; i++) {
                for (int j = i + 1; j < array.length - 1; j++) {

                    if (entries == 2) {
                        if (array[i] + array[j] == sum) {
                            product = (long) array[i] * array[j];
                        }
                    } else if (entries == 3) {
                        for (int k = j + 1; k < array.length; k++) {
                            if (array[i] + array[j] + array[k] == sum) {
                                product = (long) array[i] * array[j] * array[k];
                            }
                        }
                    } else {
                        throw new InvalidEntriesException("Entries can only be either 2 or 3");
                    }
                }
            }
        return product;

    }
}
