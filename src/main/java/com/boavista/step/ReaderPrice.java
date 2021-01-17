package com.boavista.step;

import com.boavista.model.PriceQuote;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class ReaderPrice {

    public static FlatFileItemReader<PriceQuote> reader(String path) {
        FlatFileItemReader<PriceQuote> reader = new FlatFileItemReader<PriceQuote>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<PriceQuote>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<PriceQuote>() {
                    {
                        setTargetType(PriceQuote.class);
                    }
                });
            }
        });
        return reader;
    }

}
