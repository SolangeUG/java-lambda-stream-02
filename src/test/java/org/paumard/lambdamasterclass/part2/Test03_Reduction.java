package org.paumard.lambdamasterclass.part2;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Test03_Reduction {

    @Test
    public void reduction_1() {
        long number = 21;

        BigInteger identity = BigInteger.ONE;

        BigInteger result = LongStream.rangeClosed(1, number)
                .mapToObj(BigInteger::valueOf)
                .reduce(identity, BigInteger::multiply);

        assertThat(result).isEqualTo(new BigInteger("51090942171709440000"));
    }
}
